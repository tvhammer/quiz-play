package hackerrank.projecteuler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PythagoreanTriplet {

    public static void main(String[] args) throws IOException {

        // from the 2 equation
        // a^2 + b^2 = c^2
        // a + b + c=N
        // c = N/2 - ab/N
        // ab should be divisible with N
        // N should be even
        // c < N/2

        int[] N = {4, 12, 3000, 100, 200, 400, 500, 600, 2500};

        Map<Integer, Long> nMap = new HashMap<>();
        final int CMAX = 1500;
        for (int a = 1; a < CMAX; a++) {
            for (int b = a; b < CMAX; b++) {
                Double c = Math.sqrt(Double.valueOf(b * b + a * a));
                if (c < CMAX && c % 1 == 0) {
                    int newN = c.intValue() + a + b;
                    long newMax = c.intValue() * a * b;
                    if (nMap.containsKey(newN)) {
                        long oldMax = nMap.get(newN);
                        if (newMax > oldMax) nMap.put(newN, newMax);
                    } else {
                        nMap.put(newN, newMax);
                    }

                }
            }
        }

        for (int n : N) {
            if (n % 2 != 0) {
                System.out.println("-1");
            } else if (nMap.containsKey(n)) {
                System.out.println(nMap.get(n));
            } else {
                System.out.println("-1");

            }
        }
    }
}
