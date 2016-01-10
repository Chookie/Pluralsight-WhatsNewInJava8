package com.company.chapter2;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;


public class AggregationOptional {

    @Test
    public void maxValue(){
        Stream<Integer> stream = Stream.of(10,12,16,14);
        java.util.Optional<Integer> sum = stream.max(Comparator.naturalOrder());

        assertEquals((Integer)16,sum.get());
    }

    @Test
    public void maxValueEmpty(){
        Stream<Integer> stream = Stream.empty();
        java.util.Optional<Integer> sum = stream.max(Comparator.naturalOrder());

        assertEquals(Integer.valueOf(-1),sum.orElse(-1));
    }

    @Test
    public void count(){
        Stream<Integer> stream = Stream.of(10,12,16,14);
        long count = stream.count();

        assertEquals(4L,count);
    }

    @Test
    public void allMatch(){
        Stream<Integer> stream = Stream.of(10,12,16,14);
        boolean result = stream.allMatch( i->i>=12);

        assertEquals(false,result);
    }

    @Test
    public void anyMatch(){
        Stream<Integer> stream = Stream.of(10,12,16,14);
        boolean result = stream.anyMatch( i->i>=12);

        assertEquals(true,result);
    }

    @Test
    public void noneMatch(){
        Stream<Integer> stream = Stream.of(10,12,16,14);
        boolean result = stream.noneMatch( i-> i>=12);

        assertEquals(false,result);
    }

    @Test
    public void findAny(){
        Stream<Integer> stream = Stream.of(10,12,16,14);
        java.util.Optional<Integer> result = stream.findAny();

        assertEquals(true,result.isPresent());
    }

    @Test
    public void findFirst(){
        Stream<Integer> stream = Stream.of(10,12,16,14);
        java.util.Optional<Integer> result = stream.findFirst();

        assertEquals((Integer)10,result.get());
    }
}
