class SubClass {
    public static String classyName = "abc";

    public static String getClassyName() {
        return classyName;
    }
}

public class Test2 extends SubClass {
    public static String classyName = "def";

    public static String getClassyName() {
        return classyName;
    }

    public static void main(String[] args) {
        Test2 tt = new Test2();
        Object t = tt;
        Object s = new SubClass();
        int abcCount = 0;
        int defCount = 0;

        int tempcount = ((Test2) t).classyName == "abc" ? abcCount++ : defCount++;
        tempcount = ((SubClass) s).classyName == "abc" ? abcCount++ : defCount++;

        tempcount = tt.getClassyName(t) == "abc" ? abcCount++ : defCount++;

        // JVM won't compile
        //tempcount = tt.getClassyName(s) == "abc" ? abcCount++ : defCount++;


        //JVM works fine for all below line
        tempcount = tt.getClassyName((Test2) t) == "abc" ? abcCount++ : defCount++;
        tempcount = tt.getClassyName((SubClass) s) == "abc" ? abcCount++ : defCount++;

        System.out.println("");
        System.out.println("abcCount = " + abcCount);
    }

    public String getClassyName(Object t) {
        Test2 tt = (Test2) t;
        return tt.getClassyName();
    }

    public String getClassyName(SubClass sc) {
        return sc.getClassyName();
    }
}