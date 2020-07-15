package hackerrank.projecteuler;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SumPrimes {
    public static void main(String[] args) {

        List<Integer> primes = collectPrimes(1000000);
        TreeMap<Integer,Long> sums = new TreeMap<Integer, Long>();
        long sum = 0;
        for(int p: primes) {
            sum +=p;
            sums.put(p,sum);
        }
        System.out.println("preloaded");
        for (int t=0; t<10000; t++){
            int n = 1000000;
            long res = sums.containsKey(n) ? sums.get(n) : sums.lowerEntry(n).getValue();
            System.out.println("sum " + res);
        }


//        primes.stream().limit(n / 2).forEach(System.out::println);
    }

    static List<Integer> collectPrimes(int n) {
        Stream<Integer> primeStream = IntStream.range(2, n).filter(i -> i == 2 || i % 2 != 0).limit(n / 2).boxed();
        int i = 3;
        List<Integer> previousPrimes = new ArrayList<>();
        while (i * i <= n) {
            boolean isPrime = true;
            for (int p : previousPrimes) {
                if (i % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                previousPrimes.add(i);
            i += 2;
        }
        for (int p: previousPrimes) {
            int theNum = p;
            primeStream = primeStream.filter(j -> j==theNum || j % theNum != 0);
        }
        return primeStream.collect(Collectors.toList());
    }
}
