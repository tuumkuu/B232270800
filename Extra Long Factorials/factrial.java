import java.math.BigInteger;
import java.util.Scanner;

public class factrial {

    public static void extraLongFactorials(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        extraLongFactorials(n);
    }
}
