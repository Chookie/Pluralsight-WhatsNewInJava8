package com.company.chapter4;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ioTests {

    @Test
    public void readFile(){
        // Does not work on osx, only convenience
        Path path = Paths.get("D:","com/company/chapter4","people.txt");
        try(Stream<String> lines = Files.lines(path)){
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readDir(){
        String file = ClassLoader.getSystemResource("com/company/chapter4/people.txt").getPath();
        Path path = Paths.get(file).getParent().getParent();
        try(Stream<Path> paths = Files.list(path)){
            paths.forEach(System.out::println);
//            /Users/Alison/Development/PluralSight/WhatsNewInJava8/out/production/WhatsNewInJava8/com/company/chapter1
//            /Users/Alison/Development/PluralSight/WhatsNewInJava8/out/production/WhatsNewInJava8/com/company/chapter2
//            /Users/Alison/Development/PluralSight/WhatsNewInJava8/out/production/WhatsNewInJava8/com/company/chapter3
//            /Users/Alison/Development/PluralSight/WhatsNewInJava8/out/production/WhatsNewInJava8/com/company/chapter4
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void walkDir(){
        String file = ClassLoader.getSystemResource("com/company/chapter4/people.txt").getPath();
        Path path = Paths.get(file).getParent().getParent();
        try(Stream<Path> paths = Files.walk(path)){
            paths.forEach(System.out::println);
//            /Users/Alison/Development/PluralSight/WhatsNewInJava8/out/production/WhatsNewInJava8/com/company
//            /Users/Alison/Development/PluralSight/WhatsNewInJava8/out/production/WhatsNewInJava8/com/company/chapter1
//            /Users/Alison/Development/PluralSight/WhatsNewInJava8/out/production/WhatsNewInJava8/com/company/chapter1/ChainConsumers.class
//            /Users/Alison/Development/PluralSight/WhatsNewInJava8/out/production/WhatsNewInJava8/com/company/chapter1/ComparatorLambda$1.class
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
