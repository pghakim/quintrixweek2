/* Java 8 lambdas, streams, functions (filter, map, findFirst, count)
Date/Time
    current time in different time zones
    Arithmetic: + 8 hrs to current date time*/

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    //Prints local time, local time + 8 hours, and Paris time
    static void getTime() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

        OffsetDateTime currentTime = OffsetDateTime.now();
        OffsetDateTime currentTimePlusEight = currentTime.plusHours(8);
        ZonedDateTime parisTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));


        System.out.println("Local Time: " + currentTime.getHour() + ":" + currentTime.getMinute());
        System.out.println("Local Time + 8 hrs: " + currentTimePlusEight.getHour() + ":" + currentTime.getMinute());
        System.out.println("Paris TIme: " + parisTime.getHour() + ":" + parisTime.getMinute());
        System.out.println();
    }


    //Filters names that start with A and prints the first name in alphabetical order
    static void streamFilterTest() {
        List<String> list = new ArrayList<String>(Arrays.asList("Patrick", "Grace", "Aaron", "Ashley", "Johnathon"));
        Stream<String> stream = list.stream();
        Optional<String> aNames = stream.filter(i -> i.startsWith("A"))

                .collect(Collectors.toList())
                .stream().findFirst();

        aNames.ifPresent(System.out::println);
        System.out.println();

    }


    //uses .map to double each element of the array
    static void streamMapTest() {
        Arrays.stream(new int[]{4, 5, 7, 2, 9, 12})
                .map(i -> i * 2)
                .forEach(System.out::println);
        System.out.println();
    }


    //counts elements in a list and prints the total amount
    static void streamCountTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long total = list.stream().count();
        System.out.println(total);
        System.out.println();
    }

    public static void main(String[] args) {
        getTime();
        streamFilterTest();
        streamMapTest();
        streamCountTest();
    }
}

