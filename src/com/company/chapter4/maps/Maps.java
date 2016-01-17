package com.company.chapter4.maps;


import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Maps {

    @Test
    public void mergeMaps(){

        List<Person> people = Person.readFromFile();
        int halfPeople = people.size() / 2;

        // toIndex is exclusive hence no -1
        List<Person> list1 = people.subList(0,halfPeople);
        List<Person> list2 = people.subList(halfPeople, people.size());

        Map<Integer,List<Person>> map1 = list1
                .stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println("Map1");
        map1.forEach( (age,list) -> System.out.println(age + "->" + list));

        Map<Integer,List<Person>> map2 = list2
                .stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println("Map2");
        map2.forEach( (age,list) -> System.out.println(age + "->" + list));

        // Merge
        map2.entrySet().stream()
                .forEach( e ->
                        map1.merge(
                                e.getKey(),
                                e.getValue(),       // If not exist then use this list
                                (l1, l2) -> {       // If key exists then exec this function to all list 2 to list 1
                                    l2.addAll(l1);
                                    return l1;
                                }
                        )
                );

        System.out.println("Map1 merged");
        map2.forEach( (age,list) -> System.out.println(age + "->" + list));
    }
}
