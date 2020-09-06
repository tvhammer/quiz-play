package hackerrank.projecteuler;

import java.util.*;

public class HighlyDevisableTriangularNumber {
    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 3, 4,7,1000,1000,1000);
        int max = integers.stream().max(Integer::compareTo).get();

        int[] factors = createFactors(max);
        for(int i: integers){
            System.out.println(factors[i]);
        }
    }

    static int[] createFactors(int max) {
        int[] factors = new int[max+1];


        int num = 0;
        int fact = 0;
        int tri = 0;
        for(int i = 1; i<=max; i++){
            while(fact <= i) {
                num++;
                tri = (num * (num + 1)) / 2;
                fact = numOfFactors(tri);
            }
            factors[i] = tri;
        }
        return factors;
    }

    static int numOfFactors(int num) {
        int counter = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i == i) counter++;
                else counter += 2;
            }
        }
        return counter;
    }
}
