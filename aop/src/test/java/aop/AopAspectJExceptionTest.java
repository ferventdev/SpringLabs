package aop;

import model.Bar;
import model.CustomerBrokenException;
import model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
class AopAspectJExceptionTest {

    @Autowired
    private Bar bar;

    @Autowired
    private Customer customer;

    @BeforeEach
    void setUp() throws Exception {
        customer.setBroke(true);
    }

    @Test
    void testAfterThrowingAdvice() {
        assertThrows(CustomerBrokenException.class, () -> bar.sellSquishee(customer));
        assertTrue("Customer is not broken", AopLog.getStringValue().contains("Hmmm..."));
    }

    @AfterEach
    void tearDown() {
        customer.setBroke(false);
    }
}