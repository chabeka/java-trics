package com.kindia.solia.newsInJava8.listCollection;

import com.kindia.solia.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    public void comparePerson() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("tedi", "Riner"));
        personList.add(new Person("guillaume", "Blaster"));
        personList.add(new Person("Nicolas", "Cage"));
        personList.add(new Person("Spinof", "Ted"));

        personList.sort(Comparator.comparing(Person::getName).thenComparing(Person::getLastName));
    }
}
