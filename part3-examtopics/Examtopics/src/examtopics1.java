import java.util.List;

public class examtopics1 {
}


class T15 {
    public static void main(String[] args) {
        List<Integer> list = List.of(11, 12, 13, 12, 13);

        Double d = Double.valueOf(list.get(0));
        double f = list.get(0);
        Integer a = Integer.valueOf(list.get(0));
        int c = list.get(0);
    }
}

class Person {
    private String name = "Green";

    public void getName(String name) {

    }

    public void setName(String name) {
        name = "Mr." + name;
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class eTest23 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Blue");
        System.out.println(p);

    }
}