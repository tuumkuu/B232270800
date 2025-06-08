import java.util.*;

public class Main {

    static String[] num = {
            "", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen", "twenty", "twenty one", "twenty two", "twenty three",
            "twenty four", "twenty five", "twenty six", "twenty seven",
            "twenty eight", "twenty nine"
    };

    public static String time(int h, int m) {
        if (m == 0) {
            return num[h] + " o' clock";
        } else if (m == 15) {
            return "quarter past " + num[h];
        } else if (m == 30) {
            return "half past " + num[h];
        } else if (m == 45) {
            return "quarter to " + num[(h % 12) + 1];
        } else if (m < 30) {
            return num[m] + (m == 1 ? " minute" : " minutes") + " past " + num[h];
        } else {
            int rem = 60 - m;
            return num[rem] + (rem == 1 ? " minute" : " minutes") + " to " + num[(h % 12) + 1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(time(h, m));
    }
}
