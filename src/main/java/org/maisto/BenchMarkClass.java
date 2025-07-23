package org.maisto;

import java.util.stream.LongStream;
import java.util.stream.Stream;

//@BenchmarkMode(Mode.AverageTime) //It measures the average time of benchmarked methods
//@OutputTimeUnit(java.util.concurrent.TimeUnit.MILLISECONDS)
//@Fork(value = 2,jvmArgs = {"-Xms4G","-Xmx4G"})//It exetus the benchmarck 2 times to improve the reliability of results and uses 4Gb of heap space
public class BenchMarkClass {
    //BenchMark of several methods responsible of the sum of n numbers
    private final static long N = 10_000_000;

  //  @Benchmark
    public long imperativeSum(){
        long sum = 0;
        for(long i=1; i<=N; i++)
            sum+=i;
        return sum;
    }
  //  @Benchmark
    public long sequentialStreamSum(){
        return Stream.iterate(1L, i -> i+1)
                .limit(N)
                .reduce(0L,Long::sum);
    }

    //@Benchmark
    public long parallelStreamSum(){
        return Stream.iterate(1L,i -> i+1)
                .limit(N)
                .parallel()
                .reduce(0L,Long::sum);
    }

    //How costs Boxing and Unboxing operations
    //@Benchmark
    public long imperativeBoxingSum(){
        Long sum = 0L;
        for(Long i=1L; i<=N; i++)
            sum+=i;
        return sum;
    }

    //@Benchmark
    public long sequentialPrimitiveStreamSum(){
        return LongStream.iterate(1L, i -> i+1)
                .limit(N)
                .reduce(0L,Long::sum);
    }

}
