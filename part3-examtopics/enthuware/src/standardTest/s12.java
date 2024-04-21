package standardTest;

public class s12 {


}

/*
  Trying to override a static method with a non-static method (and vice-versa) in a class will result in a compilation error.
  Instance method(non-static) 'public void addEmployee(Employee e)' in 'company.Branch'
  cannot override static method 'static void addEmployee(Employee e)' in 'company.Company'
  else, needs to be declared as static also.

  Note: if parent is interface, then the scope of interface is limited to Interface and the
  child class can have a non-static method
 */
class TestA {
    public static void demo() {

    }
}

class TestB extends TestA {
    public static void demo() {

    }
}

