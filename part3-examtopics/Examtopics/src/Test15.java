public class Test15 {
    public static void main(String[] args) {
        String[] furnitures = {"Door", "Window", "Chair"};
        var sb = new StringBuilder();
        for (var i = 0; i < furnitures.length; i++) {
            var index = i + 1;
            sb.append(i)
                    .append("). ")
                    .append(furnitures[i].charAt(i))
                    .append(", ");
            if (index < furnitures.length) {
                sb.append(" | ");
            }
            sb.delete(sb.length() - 2, sb.length() - 1);
            sb.insert(0, '[').insert(sb.length() - 1, ']');
            System.out.println(sb);
        }
    }
}