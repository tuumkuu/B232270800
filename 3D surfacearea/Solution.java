import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(); // row
        int w = sc.nextInt(); // column
        int[][] grid = new int[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int surfaceArea = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] > 0) {
                    surfaceArea += 6 * grid[i][j]; // All 6 sides for each cube
                    surfaceArea -= 2 * (grid[i][j] - 1); // Hidden surfaces inside stack
                }

                // check neighbor overlap
                if (i > 0)
                    surfaceArea -= 2 * Math.min(grid[i][j], grid[i - 1][j]);

                if (j > 0)
                    surfaceArea -= 2 * Math.min(grid[i][j], grid[i][j - 1]);
            }
        }

        System.out.println(surfaceArea);
    }
}
