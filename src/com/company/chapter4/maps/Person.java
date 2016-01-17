package com.company.chapter4.maps;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Person {
    private String name;
    private int age;
    private String gender;

    private Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public static Person build(String name, int age, String gender) {
        return new Person(name,age,gender);
    }

    @Override
    public String toString() {
        return String.format("name=%s, age=%d, gender=%s", this.name, this.age, this.gender);
    }

    public static List<Person> readFromFile(){
        URI uri = null;
        try {
            uri = Person.class.getResource("people.txt").toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Path path = Paths.get(uri);
        try(Stream<String> lines = Files.lines(path)){
            return lines.map( l -> l.split("\\s+"))
                    .map( w -> Person.build(w[0] + " " + w[1],Integer.valueOf(w[2]),w[3]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
