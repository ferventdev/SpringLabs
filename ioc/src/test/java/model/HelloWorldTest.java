package model;

import model.impl.DefaultCountry;
import model.impl.DefaultPerson;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest {

    private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";
    private ApplicationContext context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);

    @Test
    public void testInitPerson() {
        DefaultPerson person = context.getBean("person", DefaultPerson.class);
        assertEquals(getExpectedPerson(), person);
        System.out.println(person);
    }

    private static DefaultPerson getExpectedPerson() {
        return new DefaultPerson(1, "Billy Bones", new DefaultCountry(1, "England", "EN"),
                40, 1.68f, false, Arrays.asList("some_contact@epam.com", "+7-999-1234567") );
    }
}
