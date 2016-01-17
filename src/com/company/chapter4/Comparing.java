package com.company.chapter4;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.String.format;

public class Comparing {

    @Test
    public void compareMultipleFields(){
        List<Person> people = Person.createFromFile();
        people.sort(
                Comparator.comparing(Person::getLastName)
                    .thenComparing(Person::getFirstName));

        people.stream()
                .map( p-> format("%s, %s",p.getLastName(),p.getFirstName()))
                .forEach(System.out::println);
    }

    @Test
    public void compareNullsFirstFields() {
        List<String> mutable = new ArrayList<>();
        mutable.add(null);
        mutable.addAll(Arrays.asList("one", "two", "three"));
        mutable.add(null);
        mutable.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println(mutable);
    }
}
