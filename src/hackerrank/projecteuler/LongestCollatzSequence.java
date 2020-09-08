package hackerrank.projecteuler;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LongestCollatzSequence {
    public static void main(String[] args) {
//        List<Long> nums = Arrays.asList(10l, 15l, 20l, 1000l, 1000000l, 4596415l);

        List<Long> nums = LongStream.iterate(5000000, s -> s >= 100000, s -> s - 250).boxed().collect(Collectors.toList());


        long max = Collections.max(nums);
        Map<Long, Long> lengthMap = buildCollatz(max);

        for (long n : nums) {
            System.out.println(lengthMap.get(n));
        }
    }

    static Map<Long, Long> buildCollatz(long num) {
        Map<Long, Integer> cache = new HashMap<>();
        Map<Long, Long> lengthMap = new HashMap<>();
        cache.put(1L, 0);
        int longestVal = 0;
        long longestItem = 0;
        for (long i = 1; i <=num; i++) {
            if(!cache.containsKey(i)) {
                List<Long> collList = new ArrayList<>();
                long res = i;
                int middle = 0;
                while (res != 1) {
                    if (cache.containsKey(res)) {
                        middle = cache.get(res);
                        break;
                    } else {
                        collList.add(res);
                        res = nextCollatz(res);
                    }
                }
                for (int ii = collList.size() - 1; ii >= 0; ii--) {
                    cache.put(collList.get(ii), collList.size() - ii + middle);
                }
            }

            int current = cache.get(i);
            if (current >= longestVal) {
                lengthMap.put(i, i);
                longestVal = current;
                longestItem = i;
            } else {
                lengthMap.put(i, longestItem);
            }
        }
        return lengthMap;
    }

    static long nextCollatz(long num) {
        if (num % 2 == 0) return num / 2;
        else return 3 * num + 1;
    }
}
