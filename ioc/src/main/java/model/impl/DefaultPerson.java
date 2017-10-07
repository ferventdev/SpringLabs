package model.impl;

import lombok.Value;
import model.Country;
import model.Person;

import java.util.List;

@Value
public class DefaultPerson {
    private int id;
    private String name;
    private Country country;
    private int age;
    private float height;
    private boolean isProgrammer;
    private List<String> contacts;

    public void sayHello(Person person) {
        System.out.printf("Hello %s, my name is %s", person.getName(), getName());
    }
}