package hackerrank.projecteuler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SmallestMultipl {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            long num = 0;
            int counter = 0;
            long increment = primes(n);
            while (counter < n) {
                num += increment;
                for (int i = 1; i <= n; i++) {
                    if (num % i != 0) {
                        break;
                    } else {
                        counter++;
                    }
                }
                if (counter < n) {
                    counter = 0;
                }
            }
            System.out.println(num);
        }
    }

    static long primes(long n) {
        Set<Long> set = new HashSet<>();
        for (long j = 1; j <= n; j++) {
            if (BigInteger.valueOf(j).isProbablePrime(90)) {
                set.add(j);
            } else {
                for (long i = 1; i <= j / 2; i++) {
                    if (n % i == 0 && BigInteger.valueOf(i).isProbablePrime(90)) {
                        set.add(i);
                    }
                }
            }
        }
        long result = 1;
        for (long l : set) {
            result *= l;
        }
        return result;
    }
}
