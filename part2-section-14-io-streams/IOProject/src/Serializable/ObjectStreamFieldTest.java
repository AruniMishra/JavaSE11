package Serializable;

import java.io.*;
/*
'serialPersistentFields' is used and it is declared with private, static and final modifiers.

Also private methods 'writeObject(ObjectOutputStream)' and 'readObject(ObjectInputStream)' are present,
hence serialization and de-serialization will depend upon the implementation of these methods.

Variable 'i' is not serialized in 'writeObject(ObjectOutputStream)' method,
therefore on de-serialization it is initialized to default value, which is 0.


In 'writeObject(ObjectOutputStream)' method, "BOOK" is stored against "name" filed and
'String [] {"Fiction", "Mystery", "Thriller"}' is stored against "geners" field.


In 'readObject(ObjectInputStream s)' method, `fields.get("name", "NOVELS")` returns "BOOK" and
not the default value "NOVELS"

`System.out.println(fields.get("name", "NOVELS"));` prints BOOK

and

`fields.get("geners", new String[]{"F", "M", "T"})` returns 'String [] {"Fiction", "Mystery", "Thriller"}' and
not the default value 'String [] {"F", "M", "T"}'.

`System.out.println(((String[])fields.get("geners", new String[]{"F", "M", "T"}))[1]);`
prints the element at index no. 1, which is Mystery.


Finally,

`System.out.println(s.i);` prints 0.
 */

class Product implements Serializable {
    int i = 100;
    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("name", String.class),
            new ObjectStreamField("geners", String[].class)
    };

    private void writeObject(ObjectOutputStream s) throws IOException {
        ObjectOutputStream.PutField fields = s.putFields();
        fields.put("name", "BOOK");
        fields.put("geners", new String[]{"Fiction", "Mystery", "Thriller"});

        s.writeFields();
    }

    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = s.readFields();
        System.out.println(fields.get("name", "NOVELS"));
        System.out.println(((String[]) fields.get("geners", new String[]{"F", "M", "T"}))[1]);
    }
}

public class ObjectStreamFieldTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var product = new Product();
        try (var oos = new ObjectOutputStream(new FileOutputStream(("product.ser")));
             var ois = new ObjectInputStream(new FileInputStream("product.ser"))) {
            oos.writeObject(product);

            var s = (Product) ois.readObject();
            System.out.println(s.i);
        }
    }
}