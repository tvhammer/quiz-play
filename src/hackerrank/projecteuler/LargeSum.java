package hackerrank.projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LargeSum {
    public static void main(String[] args) {
        String[] num = {"37107287533902102798797998220837590246510135740250",
                "46376937677490009712648124896970078050417018260538",
                "74324986199524741059474233309513058123726617309629",
                "91942213363574161572522430563301811072406154908250",
                "23067588207539346171171980310421047513778063246676"};


        int[] res = Arrays.stream(num).map(s ->
                Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray()
        ).reduce((a, b) -> sum(a, b)).get();
        for(int i=0; i<10; i++){
            System.out.print(res[i]);
        }
    }

    static int[] sum(int[] first, int[] second) {
        int len = Math.max(first.length, second.length);
        int[] temp = new int[len];
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int f = first.length <= i ? 0 : first[first.length - i - 1];
            int s = second.length <= i ? 0 : second[second.length - i - 1];
            int sum = f + s + carry;

            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            int digit = sum % 10;
            temp[i] = digit;
        }
        int[] result;
        if (carry != 0) {
            result = new int[len + 1];
            result[0] = carry;
        } else {
            result = new int[len];
        }
        for (int s = 0; s < len; s++) {
            result[s+carry] = temp[len - s - 1];
        }

        return result;
    }
}
