package com.company.chapter1;

import java.io.File;
import java.util.Arrays;

public class FileFilterLambda {

    public static void main(String[] args) {
        fileFilterAnonymous();
        fileFilterLambda1();
        fileFilterLambda2();
        fileFilterLambda3();
    }

    private static void fileFilterAnonymous() {
        java.io.FileFilter filter = new java.io.FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        File dir = new File("/Users/Alison/Development/PluralSight/WhatsNewInJava8/src/com/company");
        File[] files = dir.listFiles(filter);
        printFiles("Anonymous",files);
    }

    private static void fileFilterLambda1() {

        java.io.FileFilter filter = (File file) -> file.getName().endsWith(".java");

        File dir = new File("/Users/Alison/Development/PluralSight/WhatsNewInJava8/src/com/company");
        File[] files = dir.listFiles(filter);
        printFiles("Lambda1",files);
    }

    private static void fileFilterLambda2() {

        java.io.FileFilter filter = file -> file.getName().endsWith(".java");

        File dir = new File("/Users/Alison/Development/PluralSight/WhatsNewInJava8/src/com/company");
        File[] files = dir.listFiles(filter);
        printFiles("Lambda2",files);
    }

    private static void fileFilterLambda3() {

        File dir = new File("/Users/Alison/Development/PluralSight/WhatsNewInJava8/src/com/company");
        File[] files = dir.listFiles(file -> file.getName().endsWith(".java"));
        printFiles("Lambda3",files);
    }

    private static void printFiles(String name, File[] files){
        System.out.println(name);
        Arrays.stream(files).forEach(System.out::println);
    }
}
