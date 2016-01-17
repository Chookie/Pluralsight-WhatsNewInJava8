package com.company.chapter4.maps;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Bimaps {

    @Test
    public void mergeBimaps(){

        List<Person> people = Person.readFromFile();

        Map<Integer,List<Person>> map = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println("Map");
        map.forEach( (age,list) -> System.out.println(age + "->" + list));

        // Bimap
        Map<Integer, Map<String,List<Person>>> bimap = new HashMap<>();

        people.stream()
                .forEach( p ->
                        bimap.computeIfAbsent(  // Returns new hashmap if key exists, or already existing hashmap
                                p.getAge(),
                                HashMap::new    // only used if key does not exist
                            ).merge(
                                p.getGender(),
                                new ArrayList<>(Arrays.asList(p)), // Call if not exist. aslist is immutable.
                                (l1,l2) -> {                             // Call if does exist.
                                    l1.addAll(l2);
                                    return l2;
                                }
                            )
                );

        System.out.println("Bimap");
        bimap.forEach( (age,m) -> System.out.println(age + "->" + m));
    }
}
