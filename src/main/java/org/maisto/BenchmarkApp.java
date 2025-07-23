package org.maisto;

import java.util.stream.Stream;

public class BenchmarkApp {

    public static long imperativeSum(long n){
        long sum = 0;
        for(long i=1; i<=n; i++)
            sum+=i;
        return sum;
    }

    public static long sequentialStreamSum(long n){
        return Stream.iterate(1L,i -> i+1)
                .limit(n)
                .reduce(0L,Long::sum);
    }

    public static long parallelStreamSum(long n){
        return Stream.iterate(1L,i -> i+1)
                .limit(n)
                .parallel()
                .reduce(0L,Long::sum);
    }



    public static void main(String[] args){

        System.out.println("Hello all !!\nWelcome to comparison show\nSumming first 20 integer numbers\n");
        System.out.println("Imperative one\nResult:"+imperativeSum(20)+"\n");
        System.out.println("Sequential one\nResult:"+sequentialStreamSum(20)+"\n");
        System.out.println("Parallel one\nResult:"+parallelStreamSum(20)+"\n");

    }
}

