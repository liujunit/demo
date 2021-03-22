package jdk8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.stream.LongStream;

public class TestStreamAPI3 {
    /**
     * 并行流
     */
    @Test
    public void test01() {
        Instant start = Instant.now();
        long reduce = LongStream.rangeClosed(0, 100000000000L)
                .parallel()
                .reduce(0, Long::sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
    }

}
