package model.impl;

import lombok.Data;
import model.Person;

@Data
public class Customer implements Person {
    private String name;
    private boolean broke;

    public Customer(String name) {
        this.name = name;
    }

    public void sayHello(Person person) {
    }
}
