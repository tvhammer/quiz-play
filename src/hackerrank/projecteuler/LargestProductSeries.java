package hackerrank.projecteuler;

import java.util.Scanner;

public class LargestProductSeries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            String num = in.next();
            String[] numArray = num.split("");

            long max = 0;
            for(int i = 0; i< n-k+1; i++) {
                long prod = 1;
                for (int j = 0; j<k; j++) {
                    prod *= Integer.valueOf(numArray[i+j]);
                }
                if (prod > max) max = prod;
            }
            System.out.println(max);
        }
    }

}
