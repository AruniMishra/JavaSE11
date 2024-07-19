import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Test11 {
    public static void main(String[] args) {
        Test11 test11 = new Test11();
        test11.extracted();


        /*
        If a Lambda expression is like:

        // If a lambda expression just call an instance method of a  ObjectType
        (obj, args) -> obj.instanceMethod(args)

        Then method reference is like:
        // Shorthand if a lambda expression just call an instance method of a ObjectType

        ObjectType::instanceMethod
         */
        // Creating an empty ArrayList of user defined type
        // List of person
        List<String> personList = new ArrayList<>();

        // Adding elements to above object of List
        // using add() method
        personList.add("vicky");
        personList.add("poonam");
        personList.add("sachin");

        // Method reference to String type
        Collections.sort(personList,
                String::compareToIgnoreCase);
        Collections.sort(personList,
                (s, str) -> s.compareToIgnoreCase(str));
    }

    private static boolean getTest11Boolean(Member member) {
        return true;
    }

    private static Predicate<Member> getMemberPredicate() {
        return m -> m.getYearsMembership() >= 5;
    }

    private static Integer getMemberIntegerFunction(Member m1) {
        return "testName".compareToIgnoreCase(String.valueOf(m1));
    }

    private void extracted() {
        String testName = "smith";
        int testMembershipLength = 5;
        ArrayList<Member> clubMembers = new ArrayList<>();
        clubMembers.add(new Member("smith"));
        clubMembers.add(new Member("asdfg"));

        new Member("").print();

        long matches = clubMembers.
                stream()
                .peek(new Consumer<Member>() {
                    @Override
                    public void accept(Member m) {
                        m.print();
                    }
                })
                .peek(Member::print)
                .peek(member -> member.print()) // valid too
                .filter(m -> m.getYearsMembership() >= testMembershipLength)

                // Bad return type in method reference: cannot convert int to boolean
                // filter waits a lambda(predicate) whose return type is boolean
                // .filter(Member::getYearsMembership() >= testMembershipLength)

                .filter(Member::getYearsMembershipBoolean)//valid; .filter(member -> member.getYearsMembershipBoolean())
                .filter(Test11::getTest11Boolean)// valid, should be static


                .map(m -> testName.compareToIgnoreCase(m.toString()))
                // valid too
                // .map(Test11::getMemberIntegerFunction)


                .filter(a -> a == 0)
                // .filter(Integer::equals(0))// invalid
                .count();
        System.out.println(matches);

    }
}

class Member {
    String name;

    public Member(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(name);
    }

    public int getYearsMembership() {
        return 5;
    }

    public boolean getYearsMembershipBoolean() {
        return true;
    }

    public Predicate<Member> valid() {
        return m -> m.getYearsMembership() >= 5;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name=" + name +
                '}';
    }
}
