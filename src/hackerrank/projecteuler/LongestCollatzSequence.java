package hackerrank.projecteuler;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LongestCollatzSequence {
    public static void main(String[] args) {
//        List<Integer> nums = Arrays.asList(10);
        List<Integer> nums = Arrays.asList(10, 15, 20, 1000, 1000000, 4596415);

//        List<Integer> nums = IntStream.iterate(5000000, s -> s >= 100000, s -> s - 250).boxed().collect(Collectors.toList());

        int[] lengthMap = buildCollatz(5000000);

        for (int n : nums) {
            System.out.println(lengthMap[n]);
        }
    }

    static int[] buildCollatz(int max) {
        int[] cache = new int[5000001];
        int[] lengthMap = new int[5000001];
        int longestVal = 0;
        int longestItem = 0;
        for (int i = 1; i <= max; i++) {
            long res = i;
            int middle = 0;
            int counter = 0;
            while (res != 1) {
                if (res <= 5000000 && cache[(int) res] != 0) {
                    middle = cache[(int) res];
                    break;
                } else {
                    counter++;
                    res = nextCollatz(res);
                }
            }
            cache[i] = counter + middle;

            int current = cache[i];
            if (current >= longestVal) {
                lengthMap[i] = i;
                longestVal = current;
                longestItem = i;
            } else {
                lengthMap[i] = longestItem;
            }
        }
        return lengthMap;
    }

    static long nextCollatz(long num) {
        if (num % 2 == 0) return num / 2;
        else return 3 * num + 1;
    }
}
