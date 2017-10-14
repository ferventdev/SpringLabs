package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.Person;
import model.impl.UsualPerson;

@AllArgsConstructor
@Data
public class Customer implements Person {
    private Person person;
    private boolean broke;

    @Override
    public Person setName(String name) {
        return person.setName(name);
    }

    @Override
    public String getName() {
        return person.getName();
    }

    public void sayHello(Person person) {
    }
}
