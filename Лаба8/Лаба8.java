package Лаба8;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Лаба8 {
    static class Person {
        private String name;
        private int age;
        private int zp;
        public Person(String name, int age, int zp) {
            this.name = name;
            this.age = age;
            this.zp = zp;
        }
        public int getZp() {
            return zp;
        }
    };

    public static void main(String[] args) {
        System.out.println("Самое повторяющееся имя: " + Stream.of("Auto", "Better", "Cat", "Cat", "Auto", "Auto", "Bot", "Cat", "Auto", "Better", "Cat", "Cat",
                        "October", "Fish", "Bahs", "Lollipop", "Pop", "Better", "Yellow", "Lollipop", "Tab", "Auto", "Bot", "Cat", "Set")
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().
                max(Comparator.comparingLong(e -> e.getValue())).get().getKey());

        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Bob1", 35, 13_300),
                new Person("Bob2", 44, 13_400),
                new Person("Bob3", 25, 13_500),
                new Person("Bob", 42, 13_200),
                new Person("Bob555", 55, 13_600),
                new Person("Bob6", 19, 13_400),
                new Person("Bob7", 33, 13_900),
                new Person("Bob8", 37, 15_000)
        ));
        System.out.println("Средняя заработная плата: " + persons.stream()
                .collect(Collectors.averagingInt(Person::getZp)).doubleValue());

        int N = 3;
        System.out.println(persons.stream()
                .sorted((o1, o2) -> o2.age - o1.age)
                .map((Function<Person, String>) person -> person.name)
                .limit(N)
                .sorted(Comparator.comparingInt(o -> o.length()))
                .collect(Collectors.joining(",", "Имя самых старших сотрудников:", ".")));

    }

}
