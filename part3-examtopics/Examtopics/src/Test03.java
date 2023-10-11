import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test03 {
  private  void Test03 (){}

    public static void main(String[] args) {
        /*
        group all employees with a salary greater than 30 by neighborhood
         */
        List<Employee> roster = new ArrayList<>(List.of(
                new Employee("a", "delhi", 35),
                new Employee("b", "agra", 20),
                new Employee("c", "delhi", 40),
                new Employee("a", "chennai", 42),
                new Employee("aa", "agra", 25),
                new Employee("ac", "chennai", 48)));

        Predicate<Employee> p = e -> e.getSalary() > 30;
        Function<Employee, Optional<String>> f = e -> Optional.ofNullable(e.getNeighborhood());


        System.out.println("\nr4-----------------------------------------");
        Map<Optional<String>, List<Employee>> r4 =
                roster.stream()
                        .collect(Collectors.groupingBy(f,
                                Collectors.filtering(p, Collectors.toList()))
                        );
        r4.entrySet().forEach(System.out::println);


        System.out.println("\nr1-----------------------------------------");
        Map<String, List<Employee>> r1 =
                roster.stream()
                        .collect(Collectors.groupingBy(Employee::getNeighborhood,
                                Collectors.filtering(p, Collectors.toList()))
                        );
        r1.entrySet().forEach(System.out::println);


        System.out.println("\nr3-----------------------------------------");
        Map<Optional<String>, List<Employee>> r3 =
                roster.stream()
                        .filter(p)
                        .collect(Collectors.groupingBy(f));
        r3.entrySet().forEach(System.out::println);

    }
}

class Employee {

    private String name;
    private String neighborhood;
    private int salary;

    public Employee(String name, String neighborhood, int salary) {
        this.name = name;
        this.neighborhood = neighborhood;
        this.salary = salary;
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", salary=" + salary +
                '}';
    }
}