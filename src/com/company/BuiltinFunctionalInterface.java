package com.company;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltinFunctionalInterface {
    public static void main(String[] args) {
        //Predicate integer-> boolean
        Predicate<Integer> isPositive = i-> i>0;
        System.out.println(isPositive.test(-7));

        Predicate<Integer> isZero = i-> i==0;

        Predicate<Integer> isNegative= isPositive.or(isZero).negate();
        System.out.println(isNegative.test(-7));

        //Function  Person-> String
        Function<Person, String> getName = Person::getName;
        System.out.println(getName.apply(new Person("Ivan ", "Ivanov")));

        //Supplier поставщик ()-> Person
        Supplier<Person> createPerson= Person::new;
        Person person = createPerson.get();
        System.out.println(person.toString());

        //Consumer
        Consumer<Person> hello = p-> System.out.printf("Hello %s!%n", p.getName());
        hello.accept(new Person("Ivan ", "Ivanov"));

        //Comparator (o1, o20->)
        Comparator<Person> comparator = (p1,p2)-> p1.getName().compareTo(p2.getName());
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Alice", "Krige");

        System.out.println(comparator.compare(person1,person2));

        //Optional контейнер
        Optional<String> empty = Optional.empty();
        if(!empty.isEmpty())
        System.out.println(empty.get());

        Optional<String> noEmpty= Optional.of("");
        System.out.println(noEmpty.isPresent());

        Optional<String>  nullable = Optional.ofNullable(null);
        System.out.println(nullable.isPresent());








    }
}

