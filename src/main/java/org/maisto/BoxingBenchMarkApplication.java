package org.maisto;

import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.AverageTime) //It measures the average time of benchmarked methods
@OutputTimeUnit(java.util.concurrent.TimeUnit.MILLISECONDS)
@Fork(value = 2,jvmArgs = {"-Xms4G","-Xmx4G"})//It executes the benchmarck 2 times to improve the reliability of results and uses 4Gb of heap space to limit the influence of garbage collector
public class BoxingBenchMarkApplication {

    private static final int N = 1000_000 ;

    /*We want to measure the consequences of using Integer in place of int*/

    @Benchmark
    public int intSum(){
        int sum = 0;
        for(int i = 0; i <= N; i++){
            sum+=i;
        }
        return sum;
    }

    @Benchmark
    public Integer integerSum(){
        Integer sum = 0 ;
        for(int i = 0; i <= N; i++){
            sum+=i;
        }
        return sum;
    }

}
