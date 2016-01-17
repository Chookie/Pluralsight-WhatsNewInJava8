package com.company.chapter2;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static junit.framework.TestCase.assertEquals;


public class TerminalOperation {

    @Test
    public void findYoungestPersonOver20(){
        List<Person> people = Person.createShortList();

        Optional<Integer> minAge =
        people.stream()
                .map( person -> person.getAge())        // Stream<Integer>
                .filter( age -> age > 20)               // Stream<Integer>
                .min(Comparator.naturalOrder());        // Terminal operation

        assertEquals(Integer.valueOf(27),minAge.get());
    }

    @Test
    public void findYoungestPersonOver20UsingComparing(){
        List<Person> people = Person.createShortList();

        Optional<Person> minPerson =
                people.stream()
                        .filter( p -> p.getAge() > 20)
                        //.sorted(Comparator.comparing(Person::getAge))
                        //.min( (p1,p2) -> Integer.compare(p1.getAge(),p2.getAge()));
                        .min(Comparator.comparing(Person::getAge));

        assertEquals(27,minPerson.get().getAge());
        assertEquals("Jimmy",minPerson.get().getFirstName());
    }
}
