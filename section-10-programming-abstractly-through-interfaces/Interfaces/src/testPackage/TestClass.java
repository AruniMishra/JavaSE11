package testPackage;

import packageA.*;

public class TestClass implements TestInterface {
    @Override
    public void test() {
        System.out.println(TestInterface.name);
    }
}
