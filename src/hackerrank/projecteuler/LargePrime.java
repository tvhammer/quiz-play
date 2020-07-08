package hackerrank.projecteuler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LargePrime {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 2);

        int found = 1;
        int num = 3;
        int prime = 2;

        while (found < 10001) {

            if (BigInteger.valueOf(num).isProbablePrime(90)) {
                found++;
                prime = num;
                map.put(found, prime);
            }
            num += 2;
        }

        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(map.get(n));
        }
    }
}
