package com.company.chapter4;

import org.junit.Test;

import java.util.StringJoiner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringSamples {

    @Test
    public void stringToCharacterStream(){
        String  s = "Hello World";
        IntStream stream = s.chars();
        stream.mapToObj(i -> (char)i).forEach(System.out::println);
    }

    @Test
    public void stringJoiner(){
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("one").add("two").add("three");
        System.out.println(joiner.toString());
        // [one, two, three]
    }

    @Test
    public void stringJoin(){
        String s = String.join(",","one","two","three");
        System.out.println(s);
        // one, two, three
    }
}
