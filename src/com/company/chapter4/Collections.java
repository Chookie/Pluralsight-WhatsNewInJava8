package com.company.chapter4;

import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.joining;

public class Collections {

    @Test
    public void forEachOnList(){
        List<String> list = Arrays.asList("one","two","three");
        list.forEach(System.out::println);
    }

    @Test
    public void removeIfOnCollection(){
        // Arrays.asList() only provides a List view of the underlying array
        // and is immutable
        Collection<String> immutable = Arrays.asList("one","two","three");
        // This create a mutable array
        Collection<String> mutable = new ArrayList<>(immutable);

        boolean result = mutable.removeIf( s->s.length()>4);

        System.out.println(result);
        System.out.println(
                mutable.stream().collect(joining(","))
        );
    }

    @Test
    public void replaceAllOnList(){
        // This create a mutable array
        List<String> mutable = new ArrayList<>(Arrays.asList("one","two","three"));

        mutable.replaceAll(String::toUpperCase);

        System.out.println(
                mutable.stream().collect(joining(", "))
        );
    }

    @Test
    public void sortAlphabetically(){
        List<String> list = Arrays.asList("one","two","three","four");
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }
}
