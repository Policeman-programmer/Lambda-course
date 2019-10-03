package com.company.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

/*
Create:
1. Person class with name and age fields
2. A collection of Persons;
3. Two instances of Comparator&lt;Person&gt; interface using lambda expressions: first one for
comparing by name, second one – by age
Then sort them using these comparators.
Use forEach method for printing information about all the persons.
Try to use method reference if it is possible.
 */
public class Task2 {

    public void showResult() {
        Collection<Person> persons = new TreeSet<>(Comparator.comparing(Person::getName));
        fillCollection(persons);
        persons.forEach(person -> System.out.println(person.toString()));
        System.out.println("--------------------------------------------");
        persons = new TreeSet<>(Comparator.comparingInt(Person::getAge));
        fillCollection(persons);
        persons.forEach(person -> System.out.println(person.toString()));
        System.out.println("--------------------------------------------");
        System.out.println("Another way of sorting");
        persons = new ArrayList<>();
        fillCollection(persons);
        persons.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
    }

    private static void fillCollection(Collection<Person> persons) {
        persons.add(new Person("Bred", 23));
        persons.add(new Person("Mike", 21));
        persons.add(new Person("Jack", 34));
        persons.add(new Person("Petro", 20));
        persons.add(new Person("Eugen", 13));
        persons.add(new Person("Roger", 25));
    }
}
