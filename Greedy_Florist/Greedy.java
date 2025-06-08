import java.util.*;

public class Greedy {
    public static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c); // sort prices ascending
        int totalCost = 0;
        int n = c.length;

        for (int i = 0; i < n; i++) {
            // Buyer index is (i / k), as each buyer buys every k-th flower
            totalCost += (i / k + 1) * c[n - 1 - i]; // buy expensive first
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt(); // ← make sure this exists
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

        int result = getMinimumCost(k, c);
        System.out.println(result);
    }
}
