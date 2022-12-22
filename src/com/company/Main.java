package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(genNatural(1, 10)));
        System.out.println(Arrays.toString(genEven(1, 10)));
        int[] arr= genNatural(1,10);
        System.out.println(Arrays.stream(arr).sum());
        System.out.println(Arrays.stream(arr).count());

        System.out.println(Arrays.toString(genDigits(1,10)));


    }

    static int[] genNatural(int min, int max) {
        return IntStream
                .range(min, max + 1)
                .toArray();
    }

    static int[] genEven(int min, int max) {
        return IntStream
                .range(min, max + 1)
                .filter(i -> i % 2 == 0)
                .toArray();
    }


    static int[] genDigits(int min, int max) {


        return IntStream
               .range(min,max+1)
                .map(i->i*i)
                .toArray();
    }
}
