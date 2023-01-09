package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class IntStreams2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(gen33(10)));
        System.out.println(Arrays.toString(genFibonacci(100)));
        System.out.println(Arrays.toString(gen10_1()));
        System.out.println(Arrays.toString(genPlus()));
        System.out.println(sum20());
        System.out.println(isPrime(10));
        System.out.println(Arrays.toString(genPrimes(10)));
        System.out.println(MaxPrimeFactor(438));
    }

    public static int[] gen33(int count) {
        return IntStream.iterate(3, n -> n * 10 + 3)
                .limit(count)
                .toArray();
    }

    public static long[] genFibonacci(long max) {

        return Stream.iterate(new long[]{0, 1}, a -> a[0] < max, a -> new long[]{a[1], a[0] + a[1]})
                .mapToLong(a -> a[0])
                //.limit(10)
                .toArray();
    }

    public static int[] gen10_1() {
        return Stream.iterate(new int[]{10,1},a-> a[0]>0 , a-> new int[]{a[0]-1, a[1]+1})
                .flatMapToInt(IntStream::of)
                .toArray();
    }

    public static int[] genPlus() {
        return Stream.iterate(new int[]{1,1},a-> a[0]<100 , a-> new int[]{a[0]+a[1], a[1]+1})
                .mapToInt(a->a[0])
                .toArray();
    }


    public static int sum20() {
        return Stream.iterate(new int[]{1,1}, a-> new int[]{++a[0], sum(Integer.toString(a[0]).toCharArray())})
                .filter(a->a[1]==20)
                .mapToInt(a -> a[0])
                .limit(1)
                .findFirst()
                .orElse(0);
                //.forEach(a-> System.out.println(a[0]));

    }

    static int sum(char[] arr){
        int result= 0;
        int [] arr2 = new int[arr.length];
        for (int i =0; i<arr.length; i++) {
            arr2[i] = Integer.parseInt(arr[i] + "");
            result+=arr2[i];
        }

    return result;}


    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }

    public static int[] genPrimes(int count){
        return IntStream.iterate(1, n->n+1)
                .filter(n->isPrime(n))
                .limit(count)
                .toArray();
    }

    private static int  MaxPrimeFactor(int number) {
        return IntStream.rangeClosed(2, number/2)
               .filter(n-> number%n==0)
                .filter(n->isPrime(n))
                .max().getAsInt();
    }
}
