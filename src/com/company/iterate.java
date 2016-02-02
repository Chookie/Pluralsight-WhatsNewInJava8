package com.company;


import org.junit.Test;

import java.util.stream.Stream;

public class iterate {

    @Test
    public void testIterate(){
        Stream.iterate(1L, n->n*2).limit(5).forEach(System.out::println);
    }
}
