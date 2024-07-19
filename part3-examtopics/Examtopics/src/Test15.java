public class Test15 {
    public static void main(String[] args) {
        String[] furnitures = {"Door", "Window", "Chair"};
        var sb = new StringBuilder();
        for (var i = 0; i < furnitures.length; i++) {
            var index = i + 1;
            sb.append(i)
                    .append("). ")
                    .append(furnitures[i].charAt(i))
                    .append(",~");
            if (index < furnitures.length) {
                System.out.println("---");
                sb.append("-|-");

            }
            System.out.println(sb);
            System.out.println("###########");
            sb.delete(sb.length() - 2, sb.length() - 1);
            System.out.println(sb);
            sb.insert(0, '[').insert(sb.length() - 1, ']');
            System.out.println(sb);
            System.out.println();
        }
    }
}


