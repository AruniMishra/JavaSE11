package standardTest;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class S13 {
}

class WidgetT5 {
    static {
        MAX = 111;
        CLASS_GUID = "XYZ123"; // initialization at line 1 not needed, if static block
    }

    static final String CLASS_GUID;   // 1
    static int MAX;     // 2


    WidgetT5() {
        // 3
    }

    WidgetT5(int k) {
        // 4
    }
}

class A9{
    protected int i;
    A9(int i) {    this.i = i;    }

}

class B9 extends A9{
    B9(){
        super(1); // pass it any integer
        new A9(1);
    }
    // or
    B9(int number){
        super(number);
    }
}

interface Bar25{
    static void bar(){};
}

abstract class FooBase{

    public static void bar(){
        System.out.println("In static bar");
    }
}

class Foo extends FooBase implements Bar25 {

}




class Super { static String ID = "QBANK"; }

class Sub extends Super{
    // static String ID = "QBANK2";
    static { System.out.println("In Sub"); }
}
 class Test32{
    public static void main(String[] args){
        //A reference to a static field causes initialization of only the class or interface that actually declares it,
        // even though it might be referred to through the name of a subclass, a subinterface, or a class that implements an interface.
        System.out.println(Sub.ID);
    }
}



class Cache39 {

    static ConcurrentHashMap<String, Object> chm
            = new ConcurrentHashMap<String, Object>();

    public static void main(String[] args) {
        chm.put("a", "aaa");
        chm.put("b", "bbb");
        chm.put("c", "ccc");

        new Thread(){
            public void run(){
                Iterator<Map.Entry<String, Object>> it = Cache39.chm.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry<String, Object> en = it.next();
                    if(en.getKey().equals("a") || en.getKey().equals("b")){
                        it.remove();
                    }
                }
            }
        }.start();

        new Thread(){
            public void run(){
                Iterator<Map.Entry<String, Object>> it = Cache39.chm.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry<String, Object> en = it.next();
                    System.out.print(en.getKey()+", ");
                }
            }
        }.start();
    }
}


class NewClass40 {
    public static Optional<String> getGrade(int marks){
        Optional<String> grade = Optional.empty();
        if(marks>50){
            grade = Optional.of("PASS");
        }
        else {
            grade.of("FAIL");
        }
        return grade;
    }
    public static void main(String[] args) {
        Optional<String> grade1 = getGrade(50);
        Optional<String> grade2 = getGrade(55);
        System.out.println(grade1.orElse("UNKNOWN"));
        if(grade2.isPresent()){
            grade2.ifPresent(x->System.out.println(x));
        }else{
            System.out.println(grade2.orElse("Empty"));
        }
    }
}



class SomeClass{
    String s1 = "green mile";   // 0
    public void generateReport( int n ){
        String local;   // 1
        if( n > 0 ) local = "good";   //2
        // System.out.println( s1+" = " + local );   //3
    }
}
