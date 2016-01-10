package com.company.chapter2;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CollectingReductions {

    @Test
    public void collectIntoCsv(){

        String result = Person.createShortList().stream()
                .filter( p-> p.getAge() > 20)
                .sorted(Comparator.comparing(Person::getLastName,Comparator.reverseOrder()))
                .map(Person::getLastName)
                .collect(Collectors.joining(","));

        System.out.println(result);
    }
}
