package com.company.chapter3;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person {
    private final String name;
    private final LocalDate dateOfBirth;

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.dateOfBirth = birthday;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString(){
        return name + ", " + dateOfBirth;
    }

    public static List<Person> loadFromFile(){
        Path path = null;
        try {
            path = Paths.get(ClassLoader.getSystemResource("com/company/chapter3/PeopleBirthdays.txt").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try(Stream<String> lines = Files.lines(path)){
            return lines
                    .map( l -> l.split("\\s+"))
                    .map( w -> new Person(w[0],
                            LocalDate.of(
                                    Integer.valueOf(w[1]),
                                    Integer.valueOf(w[2]),
                                    Integer.valueOf(w[3])
                                         )
                            ))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
