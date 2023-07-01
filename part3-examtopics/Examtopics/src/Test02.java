public class Test02 {

    int aCount;
    int tCount;
    int cCount;
    int gCount;

    Test02(int a, int tCount, int c, int g) {
        setGCount(g);
        aCount = a;
    }

    public static void main(String[] args) {
        Test02 pop = new Test02(1, 2, 3, 4);
        System.out.println(pop.aCount + " " + pop.cCount + " " + pop.gCount); // 1 3 4
    }

    int setCCount(int c) {
        return c;
    }

    void setGCount(int gCount) {
        this.gCount = gCount;
    }
}
