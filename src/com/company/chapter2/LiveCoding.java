package com.company.chapter2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class LiveCoding {

    @Test
    public void reductionExample3Values(){

        List<Integer> list = Arrays.asList(10,10,10);

        Integer result =
        list.stream()
                //.reduce(0, (i1,i2) -> i1 + i2)
                .reduce(100, Integer::sum);

        assertEquals((Integer)130,result);
    }

    @Test
    public void reductionExample1Value(){

        List<Integer> list = Arrays.asList(10);

        Integer result =
                list.stream()
                        //.reduce(0, (i1,i2) -> i1 + i2)
                        .reduce(100, Integer::sum);

        assertEquals((Integer)110,result);
    }

    @Test
    public void reductionExampleEmpty(){

        List<Integer> list = Arrays.asList();

        Integer result =
                list.stream()
                        //.reduce(0, (i1,i2) -> i1 + i2)
                        .reduce(100, Integer::sum);

        assertEquals((Integer)100,result);
    }
}
