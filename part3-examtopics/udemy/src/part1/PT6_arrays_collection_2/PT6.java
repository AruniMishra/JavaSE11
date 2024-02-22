package part1.PT6_arrays_collection_2;

import java.util.*;

class Test3 {
    public static void main(String[] args) {

        List list1 = new ArrayList<String>(); // Line n5
        List<String> list2 = new ArrayList(); // Line n6
        // List<> list3 = new ArrayList<String>(); //Line n7
        List<String> list4 = new ArrayList<String>(); // Line n8
        List<String> list5 = new ArrayList<>(); // Line n9
    }
}


class Test27 {
    public static void main(String[] args) {
        ArrayList<Integer> original = new ArrayList<>(); //Line n1
        original.add(10); //Line n2

        ArrayList<Integer> cloned = (ArrayList<Integer>) original.clone();
        Integer i1 = cloned.get(0);
        ++i1;

        System.out.println(cloned);
        System.out.println(original);
    }
}

class Test49 {
    public static void main(String[] args) {
        List list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add("3"); //Line n1
        // list.removeIf(i -> i % 2 == 1); //Line n2
        System.out.println(list);


        // List<String> list2 = Arrays.asList(1,2);

        var list1 = List.of("A"); //Line n1
        var list2 = List.of("A"); //Line n2
        list1 = list2; //Line n3

        Integer.valueOf(15);
    }
}


class Father {}

class Son extends Father {}

class GrandSon extends Son {}

abstract class Super {
    abstract List<Father> get();
}

class Sub45 extends Super {
    @Override
    List<Father> get() {
        return null;
    }
    /*INSERT*/
}

class Test48 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        list.removeIf(i -> i % 2 == 1);
        System.out.println(list);

        list.sort(Comparator.naturalOrder());
    }
}

class Student56 {
    private String name;
    private int age;

    Student56(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int hashCode() {
        return name.hashCode() + age;
    }

    public String toString() {
        return "Student56[" + name + ", " + age + "]";
    }

    public boolean equals(Object obj) {
        if(obj instanceof Student56) {
            Student56 stud = (Student56)obj;
            return this.name.equals(stud.name) && this.age == stud.age;
        }
        return false;
    }
}

class Test56 {
    public static void main(String[] args) {
        Set<Student56> students = new TreeSet<>();
        students.add(new Student56("James", 20));
        students.add(new Student56("James", 20));
        students.add(new Student56("James", 22));

        System.out.println(students.size());
    }
}