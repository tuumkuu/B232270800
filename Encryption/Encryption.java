import java.util.*;

public class Encryption {
    public static String encryption(String s) {
        s = s.replaceAll(" ", "");
        int L = s.length();
        int rows = (int) Math.floor(Math.sqrt(L));
        int cols = (int) Math.ceil(Math.sqrt(L));
        if (rows * cols < L) {
            rows++;
        }
        List<String> grid = new ArrayList<>();
        for (int i = 0; i < L; i += cols) {
            grid.add(s.substring(i, Math.min(i + cols, L)));
        }
        StringBuilder result = new StringBuilder();
        for (int c = 0; c < cols; c++) {
            for (String row : grid) {
                if (c < row.length()) {
                    result.append(row.charAt(c));
                }
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = encryption(input);
        System.out.println(output);
    }
}
