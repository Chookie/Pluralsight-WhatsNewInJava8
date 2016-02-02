package com.company.chapter1;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {
    public static void main(String[] args) {
        annonymousComparator();
        lambdaComparator1();
        lambdaComparator2();
        lambdaComparator3();
    }

    private static void annonymousComparator(){
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(),s2.length());
            }
        };

        List<String> strings = Arrays.asList("**","****","***","*");
        Collections.sort(strings, comparator);
        printStrings("Annonymous",strings);
    }

    private static void lambdaComparator1(){
        Comparator<String> comparator = (String s1, String s2) -> Integer.compare(s1.length(),s2.length());

        List<String> strings = Arrays.asList("****","**","***","*");
        Collections.sort(strings, comparator);
        printStrings("Lambda1",strings);
    }

    private static void lambdaComparator2(){
        Comparator<String> comparator = (String s1, String s2) -> Integer.compare(s1.length(),s2.length());

        List<String> strings = Arrays.asList("****","**","***","*");
        Collections.sort(strings, comparator);
        printStrings("Lambda2",strings);
    }

    private static void lambdaComparator3(){
        //Comparator<String> comparator = (String s1, String s2) -> Integer.compare(s1.length(),s2.length());

        List<String> strings = Arrays.asList("****","**","***","*");
        Collections.sort(strings, (s1, s2) -> Integer.compare(s1.length(),s2.length()));
        printStrings("Lambda3",strings);
    }

    private static void printStrings(String name, List<String> strings){
        System.out.println(name);
        strings.forEach(System.out::println);
    }
}
