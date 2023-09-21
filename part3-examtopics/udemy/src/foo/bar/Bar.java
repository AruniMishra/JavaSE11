package foo.bar;

import foo.Foo;

public class Bar extends Foo {
    @Override
    public void foo(int j) {
        int temp = e;
        /*
        e: Protected, visible outside package by subclass only
        f: public
        j: overridden function's parameter
        B: public
         */
    }
}
