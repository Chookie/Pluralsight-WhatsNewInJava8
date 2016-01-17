package com.company.chapter2;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
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

    @Test
    public void collectIntoList(){
        List<String> names = Person.createShortList().stream()
                .filter( (p -> p.getAge()>= 20))
                .map(Person::getLastName)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        System.out.println(names);
    }

    @Test
    public void collectIntoMap(){
        Map<Integer,List<Person>> people = Person.createShortList().stream()
                .filter( p->p.getAge() > 20)
                .collect(
                        Collectors.groupingBy(Person::getAge)
                );

        people.entrySet().stream()
                .map( e -> String.format("Age=%s, Names=%s",e.getKey(),
                        e.getValue().stream()
                                .map(Person::getLastName)
                                .collect(Collectors.joining(","))))
                .forEach(System.out::println);
    }

    @Test
    public void downstreamCollectorCounting(){
        Map<Integer,Long> people = Person.createShortList().stream()
                .filter( p->p.getAge() > 20)
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.counting()
                        )
                );

        people.entrySet().stream()
                .map( e -> String.format("Age=%s, Count=%s",e.getKey(),e.getValue()))
                .forEach(System.out::println);
    }


    @Test
    public void TestCreateFromFile(){
        List<Person> people = Person.createFromFile();

        System.out.println(people);
    }

    @Test
    public void youngestOlderThan20FromFile(){

        Optional<Person> person = Person.createFromFile().stream()
                .filter( p -> p.getAge() >= 20)
                .min(Comparator.comparing(Person::getAge));

        System.out.println(person);
    }

    @Test
    public void groupByAgeFromFile(){

        Map<Integer, List<Person>> map = Person.createFromFile().stream()
                .collect(
                        Collectors.groupingBy(Person::getAge)
                );

        System.out.println(map);
    }

    @Test
    public void downStreamCollectorCounting(){

        Map<Integer, Long> map = Person.createFromFile().stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.counting()
                        )
                );

        System.out.println(map);
    }


    @Test
    public void downStreamCollectorMultiLevel(){

        Map<Integer, List<String>> map = Person.createFromFile().stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getLastName,
                                        Collectors.toList()
                                )
                        )
                );

        System.out.println(map);
    }

    @Test
    public void downStreamCollectorToTreeSet(){
        // Trees are sorted

        Map<Integer, Set<String>> map = Person.createFromFile().stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getLastName,
                                        Collectors.toCollection(TreeSet::new)
                                )
                        )
                );

        System.out.println(map);
    }

    @Test
    public void downStreamCollectorToString(){
        // Trees are sorted

        Map<Integer, String> map = Person.createFromFile().stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getLastName,
                                        Collectors.joining(", ")
                                )
                        )
                );

        System.out.println(map);
    }
}
