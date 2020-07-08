package hackerrank.projecteuler;

import java.util.Scanner;

public class LargestPalindromProduct {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            for (long i = n - 1; i > 100000; i--) {
                String num = String.valueOf(i);
                StringBuffer sb = new StringBuffer(num);
                sb = sb.reverse();
                if (sb.toString().equals(num)) {
                    if (checkDividends(i)) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        }
    }

    static boolean checkDividends(long num) {
        for (long n = 100; n < 999; n++) {
            if (num % n == 0) {
                if (num / n >= 100 && num / n <= 999)
                    return true;
            }
        }
        return false;
    }
}
