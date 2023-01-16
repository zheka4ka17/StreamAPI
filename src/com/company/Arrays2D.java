package com.company;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Arrays2D {
    public static void main(String[] args) {
        fillOrder();
        fillOrderTriangle();
        fillOrder3();
        fillOrder4();
    }

    public static int[][] fillOrder() {



        int[][] arr = IntStream.range(0, 3)
                .mapToObj(i -> IntStream.range(0, 3)
                        .map(j -> j + 1 + 3 * i)
                        .toArray())
                .toArray(int[][]::new);


        for (int[] a : arr)
            System.out.println(Arrays.toString(a));
        return arr;
    }


    public static int[][] fillOrderTriangle() {
        AtomicInteger counter = new AtomicInteger(1);

        int[][] arr = IntStream.range(0, 5)
                .mapToObj(i -> IntStream.range(0, i + 1)
                        .map(j -> counter.getAndIncrement())
                        .toArray())
                .toArray(int[][]::new);

        for (int[] a : arr)
            System.out.println(Arrays.toString(a));
        return arr;

        //заполнить массив по порядку
    }

    public static int[][] fillOrder3() {

        int[][] arr = IntStream.range(0, 5)
                .mapToObj(i -> IntStream.range(0, 5-i)
                        .map(j -> 5-j)
                        .toArray())
                .toArray(int[][]::new);


        for (int[] a : arr)
            System.out.println(Arrays.toString(a));
        return arr;
    }

    public static int[][] fillOrder4() {

        int[][] arr = IntStream.range(0, 5)
                .mapToObj(i-> Stream.iterate(new int[]{1,1}, n->new int[]{n[0]+1,n[0]<i+1?n[1]+1:n[1]-1})
                        .limit(2*i+1)
                        .mapToInt(n->n[1])
                        .toArray())
                        .toArray(int[][]::new);

        for (int[] a : arr)
            System.out.println(Arrays.toString(a));
        return arr;
    }



}
