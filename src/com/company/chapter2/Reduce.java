package com.company.chapter2;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;

public class Reduce {

    @Test
    public void reduceWhenStreamHasMoreThan1Value(){
        List<Integer> ages = Arrays.asList(10,12,14,16);
        Stream<Integer> stream = ages.stream();
        Integer sum = stream.reduce(0, (age1,age2) -> age1 + age2);

        assertEquals((Integer)52,sum);
    }

    @Test
    public void reduceWhenStreamHasOnly1Value(){
        Stream<Integer> stream = Stream.of(10);
        Integer sum = stream.reduce(0, (age1,age2) -> age1 + age2);

        assertEquals((Integer)10,sum);
    }

    @Test
    public void reduceWhenStreamIsEmpty(){
        //ist<Integer> ages = Arrays.asList();
        Stream<Integer> stream = Stream.empty();
        Integer sum = stream.reduce(0, (age1,age2) -> age1 + age2);

        assertEquals((Integer)0,sum);
    }
}
