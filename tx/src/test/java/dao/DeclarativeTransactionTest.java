package dao;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.annotation.Propagation;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
public class DeclarativeTransactionTest extends JdbcTest {
    
	@Autowired
	private CountryService countryService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    @DirtiesContext
    public void testRequiredPropagationInsideTransaction() {
        assertNotNull(countryService.getAllCountriesInsideTransaction(Propagation.REQUIRED));
    }

    @Test
    @DirtiesContext
    public void testRequiredPropagationWithoutTransaction() {
        assertNotNull(countryService.getAllCountriesRequired());
    }

    @Test
    @DirtiesContext
    public void testMandatoryPropagationWithoutTransaction() {
        try {
            countryService.getAllCountriesMandatory();
        } catch (Exception e) {
            assertTrue(e instanceof IllegalTransactionStateException);
            e.printStackTrace();
        }
    }

    @Test
    @DirtiesContext
    public void testMandatoryPropagationInsideTransaction() {
        assertNotNull(countryService.getAllCountriesInsideTransaction(Propagation.MANDATORY));
    }
}