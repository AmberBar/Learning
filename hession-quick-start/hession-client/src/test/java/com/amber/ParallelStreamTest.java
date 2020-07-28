package com.amber;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamTest {

    @Test
    public void hello() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream().forEach(num->System.out.println(num));
    }

}
