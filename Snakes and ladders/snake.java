import java.io.*;
import java.util.*;

public class snake {

    static class GameNode {
        int square;
        int moves;

        GameNode(int square, int moves) {
            this.square = square;
            this.moves = moves;
        }
    }

    public static int quickestWayUp(int[][] ladders, int[][] snakes) {
        int[] board = new int[101];

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int[] ladder : ladders) {
            board[ladder[0]] = ladder[1];
        }

        for (int[] snake : snakes) {
            board[snake[0]] = snake[1];
        }

        boolean[] visited = new boolean[101];
        Queue<GameNode> queue = new LinkedList<>();
        queue.add(new GameNode(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            GameNode current = queue.poll();

            if (current.square == 100) {
                return current.moves;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = current.square + dice;
                if (next <= 100 && !visited[board[next]]) {
                    visited[board[next]] = true;
                    queue.add(new GameNode(board[next], current.moves + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int test = 0; test < t; test++) {
            int l = scanner.nextInt();
            int[][] ladders = new int[l][2];
            for (int i = 0; i < l; i++) {
                ladders[i][0] = scanner.nextInt();
                ladders[i][1] = scanner.nextInt();
            }

            int s = scanner.nextInt();
            int[][] snakes = new int[s][2];
            for (int i = 0; i < s; i++) {
                snakes[i][0] = scanner.nextInt();
                snakes[i][1] = scanner.nextInt();
            }

            int result = quickestWayUp(ladders, snakes);
            System.out.println(result);
        }

        scanner.close();
    }
}
