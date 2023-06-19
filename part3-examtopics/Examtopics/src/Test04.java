public class Test04 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(5);
        System.out.println(sb + " :: sb.length():" + sb.length() + ", sb.capacity(): " + sb.capacity());

        sb.append("HOWDY");
        System.out.println(sb + " :: sb.length():" + sb.length() + ", sb.capacity(): " + sb.capacity());

        sb.insert(0, '_');
        System.out.println(sb + " :: sb.length():" + sb.length() + ", sb.capacity(): " + sb.capacity());

        sb.replace(3, 5, "LL");
        System.out.println(sb + " :: sb.length():" + sb.length() + ", sb.capacity(): " + sb.capacity());

        sb.insert(6, "cow");
        System.out.println(sb + " :: sb.length():" + sb.length() + ", sb.capacity(): " + sb.capacity());

        sb.delete(2, 7);
        System.out.println(sb + " :: sb.length():" + sb.length() + ", sb.capacity(): " + sb.capacity());


        int[][][] e = {{new int[]{1}, new int[]{1}, new int[]{1}}, {new int[]{2}, new int[]{2}, new int[]{2}}};

        int[][] e1 = {{1, 1, 1}, {2, 2, 2}};

        short sh = (short) 'A';

        float x = 1f;

        byte b = 105;
        char c = (char) b;

        String contact = "(+2) (999) (232)";

        int x1 = 12_34;




        PersonTest personTest = new PersonTest("Joe");
        System.out.println(checkPerson(personTest));
        personTest = null;
        System.out.println(checkPerson(personTest));

    }

    public static PersonTest checkPerson(PersonTest s) {
        if (s == null) {
            s = new PersonTest("Mary");
        } else {
            s = null;
        }

        return s;

    }
}
