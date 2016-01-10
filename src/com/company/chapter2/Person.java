package com.company.chapter2;

import java.util.ArrayList;
import java.util.List;

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
}
