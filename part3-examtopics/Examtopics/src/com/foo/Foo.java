package com.foo;

public class Foo {
    public static final int B = 0;
    static final int A = 0;
    private static final int C = 0;
    public int f = 0;
    protected int e = 0;
    int d = 0;
    private int g = 0;

    public void foo(int h) {
        int i = 0;
    }
}

class Bar2 extends com.foo.Foo {
    @Override
    public void foo(int j) {

        int temp = d;

    }
}
