package com.company.task3;

import com.company.task2.Person;

import java.util.Objects;
import java.util.Random;
import java.util.function.*;

/*
1. Implement each of main Java Standard Library functional interfaces (supplier, predicate
etc.) using lambda expressions.
2. Create your own functional interface and add several implementations using both
lambda expressions and inner anonymous classes.
3. Add few default methods to it and use them.
4. Add few static methods to it and use them.
 */
public class Task3 {

    public void showResult() {
        Function<Person, String> function = Person::toString;
        Predicate<Person> predicate = Objects::nonNull;
        UnaryOperator<Person> unaryOperator = person -> {
            person.setOccupation("Software Developer");
            //do something with person again
            return person;
        };
        BinaryOperator<Integer> binaryOperator = Integer::sum;
        Supplier<Person> supplier = () -> new Person(generatePersonName(), generatePersonAge());
        Consumer<Person> consumer = (person -> System.out.println(person.toString() + "was written to DB!"));

        PersonConstructor personConstructorAnonymousClass = new PersonConstructor() {
            @Override
            public Person create(String name, int age) {
                return new Person(name,age);
            }
        };

        PersonConstructor personConstructorLambda = Person::new;

        System.out.println(supplier.get().toString());
    }

    private int generatePersonAge() {
        return new Random().nextInt(45) + 18;
    }

    private String generatePersonName() {
        int lengthName = 10;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lengthName; i++) {
            char letter = (char) (new Random().nextInt(25) + 65);
            sb.append(letter);
        }
        return sb.toString();
    }


}
