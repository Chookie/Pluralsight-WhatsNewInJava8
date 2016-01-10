package com.company.chapter1;

import javafx.collections.transformation.SortedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumers {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("one", "two","three","four","five");

        List<String> results = new LinkedList<>();

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = results::add;

        strings.forEach(c1.andThen(c2));
        System.out.println("Size of results is " + results.size());
    }
}
