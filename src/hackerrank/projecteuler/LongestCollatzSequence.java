package hackerrank.projecteuler;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LongestCollatzSequence {
    public static void main(String[] args) {
//        List<Integer> nums = Arrays.asList(10);
//        List<Integer> nums = Arrays.asList(10, 15, 20, 1000, 1000000, 4596415);

        List<Integer> nums = IntStream.iterate(5000000, s -> s >= 100000, s -> s - 250).boxed().collect(Collectors.toList());

        List<Integer> lengthMap = buildCollatz(5000000);

        for (int n : nums) {
            System.out.println(lengthMap.get(n));
        }
    }

    static List<Integer> buildCollatz(int max) {
        List<Integer> cache = new ArrayList<>();
        List<Integer> lengthMap = new ArrayList<>();
        cache.add(0);  // to align the index with the array index
        lengthMap.add(0); // to align the index with the array index
        int longestVal = 0;
        int longestItem = 0;
        for (int i = 1; i <= max; i++) {
            long res = i;
            int middle = 0;
            int counter = 0;
            while (res != 1) {
                if (res <= Integer.MAX_VALUE && cache.size() > res) {
                    middle = cache.get((int) res);
                    break;
                } else {
                    counter++;
                    res = nextCollatz(res);
                }
            }
            cache.add(counter + middle);

            int current = cache.get(i);
            if (current >= longestVal) {
                lengthMap.add(i, i);
                longestVal = current;
                longestItem = i;
            } else {
                lengthMap.add(i, longestItem);
            }
        }
        return lengthMap;
    }

    static long nextCollatz(long num) {
        if (num % 2 == 0) return num / 2;
        else return 3 * num + 1;
    }
}
