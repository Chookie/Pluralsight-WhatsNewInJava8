package com.company.chapter3;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class DateAndTime {

    @Test
    public void loadPeople(){
        List<Person> people = Person.loadFromFile();

        System.out.println(people);
    }

    @Test
    public void instantTest(){
        Instant now = Instant.now();
        Instant another = Instant.now();

        Duration diff = Duration.between(now, another);

        long milliseconds = diff.toMillis();
    }

    @Test
    public void periodSinceBirthdays(){

        LocalDate now = LocalDate.of(2014, Month.MARCH, 12);

        Person.loadFromFile().stream()
                .forEach( p-> {
                    Period period = Period.between(p.getDateOfBirth(), now);
                    System.out.println(p.getName() + " was born "
                            + period.get(ChronoUnit.YEARS) + " years and "
                            + period.get(ChronoUnit.MONTHS) + " months ago"
                            + " [" + p.getDateOfBirth().until(now, ChronoUnit.MONTHS) + " months ]");
                });
    }

    @Test
    public void dateOfNextSunday(){
        LocalDate now = LocalDate.now();
        LocalDate nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        LocalDate lastDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());
    }

    @Test
    public void allZonedTimes(){

        Set<String> allTimeZones = ZoneId.getAvailableZoneIds();
        System.out.println(allTimeZones);
    }

    @Test
    public void ukZonedTimes(){

        ZoneId uk = ZoneId.of("Europe/London");
        System.out.println(uk.getId() + " : " + uk.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
    }

    @Test
    public void zonedDateTime(){
        ZonedDateTime currentMeetingLondon = ZonedDateTime.of(
                LocalDate.of(2016,1,16),
                LocalTime.of(9,0,0),
                ZoneId.of("Europe/London")
                );
        System.out.println("Current Meeting London = " +
                DateTimeFormatter.ISO_INSTANT.format((currentMeetingLondon))
        );
        // Current Meeting London = 2016-01-16T09:00:00Z

        ZonedDateTime nextMeetingLondon = currentMeetingLondon.plusMonths(1);
        System.out.println("Next Meeting London = " +
                DateTimeFormatter.ISO_DATE_TIME.format((nextMeetingLondon))
        );
        // Next Meeting London = 2016-02-16T09:00:00Z[Europe/London]

        ZonedDateTime nextMeetingNy = nextMeetingLondon.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Next Meeting New York = " +
                DateTimeFormatter.ISO_INSTANT.format((nextMeetingNy))
        );
        // Next Meeting New York = 2016-02-16T09:00:00Z
    }
}
