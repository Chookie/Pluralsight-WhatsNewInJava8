package com.company.chapter4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    private static class Builder {
        private String firstName;
        private String lastName;
        private int age;

        public Person.Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Person.Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Person.Builder age(int age){
            this.age = age;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

    private Person(){super();}

    private Person(Person.Builder builder){
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
    }

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getAge(){
        return this.age;
    }

    public void print(){
        System.out.println(
                "\nName: " + firstName + " " + lastName +
                "\nAge: " + age
        );
    }

    @Override
    public String toString(){
        return firstName + " " + lastName +  ", " + age;
    }

    public static List<Person> createShortList(){
        List<Person> people = new ArrayList<>();

        people.add(
                new Builder()
                    .firstName("Bob")
                    .lastName("Smith")
                    .age(44)
                    .build()
        );

        people.add(
                new Builder()
                        .firstName("Jane")
                        .lastName("Doe")
                        .age(12)
                        .build()
        );

        people.add(
                new Builder()
                        .firstName("Jimmy")
                        .lastName("Hendrix")
                        .age(27)
                        .build()
        );

        people.add(
                new Builder()
                        .firstName("Jim")
                        .lastName("Morrison")
                        .age(27)
                        .build()
        );

        return people;
    }

    public static List<Person> createFromFile(){

        //Path path = Paths.get("c://lines.txt");
        Path path = null;
        try {
            path = Paths.get(ClassLoader.getSystemResource("com/company/chapter2/people.txt").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try(final Stream<String> lines = Files.lines(path)){
            return lines
                    .map( l -> l.split("\\s+"))
                    .map( w -> new Person(w[0], w[1], Integer.valueOf(w[2])))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
