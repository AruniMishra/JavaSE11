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


    }
}
