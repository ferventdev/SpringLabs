package aop;

import model.Bar;
import model.impl.ApuBar;
import model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
public class AopAspectJTest {

    @Autowired
    private Bar bar;

    @Autowired
    private Customer customer;

    @BeforeEach
    public void setUp() throws Exception {

        bar.sellSquishee(customer);
    }

    @Test
    public void testBeforeAdvice() {
        assertTrue("Before advice is not good enough...", AopLog.getStringValue().contains("Hello"));
        assertTrue("Before advice is not good enough...", AopLog.getStringValue().contains("How are you doing?"));
        System.out.println(AopLog.getStringValue());
    }

    @Test
    public void testAfterAdvice() {
        System.out.println(AopLog.getStringValue());
        assertTrue("After advice is not good enough...", AopLog.getStringValue().contains("Good Bye!"));
    }

    @Test
    public void testAfterReturningAdvice() {
        assertTrue("Customer is broken", AopLog.getStringValue().contains("Good Enough?"));
        System.out.println(AopLog.getStringValue());
    }

    @Test
    public void testAroundAdvice() {
        assertTrue("Around advice is not good enough...", AopLog.getStringValue().contains("Hi!"));
        assertTrue("Around advice is not good enough...", AopLog.getStringValue().contains("See you!"));
        System.out.println(AopLog.getStringValue());
    }

    @Test
    public void testAllAdvices() {
        assertFalse(bar instanceof ApuBar, "barObject instanceof ApuBar");
    }
}