package hackerrank.projecteuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LargestPrimeFactor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            if ((BigInteger.valueOf(n)).isProbablePrime(80)) {
                System.out.println(n);
            } else {

                List<Long> divider = new ArrayList<>();

                long currentLargest = n;
                long currentDivider = 3;
                long by2 = divideAll(n, 2);
                if (by2 != currentLargest) {
                    divider.add(2L);
                    currentLargest = by2;
                    if (BigInteger.valueOf(currentLargest).isProbablePrime(80)) {
                        divider.add(currentLargest);
                        currentLargest = 1;
                    }
                }

                while (currentDivider <= currentLargest) {
                    long d = divideAll(currentLargest, currentDivider);
                    if (d != currentLargest) {
                        divider.add(currentDivider);
                        currentLargest = d;
                        if (BigInteger.valueOf(currentLargest).isProbablePrime(80)) {
                            divider.add(currentLargest);
                            currentLargest = 1;
                        }

                    }
                    currentDivider += 2;
                }

                Collections.reverse(divider);
                for (long i : divider) {
                    if (BigInteger.valueOf(i).isProbablePrime(80)) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        }
    }

    static long divideAll(long n, long divider) {
        long current = n;
        while (current % divider == 0) {
            current /= divider;
        }
        return current;
    }
}
