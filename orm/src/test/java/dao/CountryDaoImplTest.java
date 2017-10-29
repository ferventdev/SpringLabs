package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import model.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
public class CountryDaoImplTest {

//	private static Log log = LogFactory.getLog(CountryDaoImplTest.class);

	private Country exampleCountry = new Country("Australia", "AU");

	@Autowired
	private CountryDao countryDao;

	@Test
    @DirtiesContext
	public void testSaveCountry() {
		countryDao.save(exampleCountry);

		List<Country> countryList = countryDao.getAllCountries();
		assertEquals(1, countryList.size());
		assertEquals(exampleCountry, countryList.get(0));
	}

	@Test
    @DirtiesContext
	public void testGtAllCountries() {
		countryDao.save(new Country("Canada", "CA"));

		List<Country> countryList = countryDao.getAllCountries();
		assertEquals(2, countryList.size());
	}

	@Test
    @DirtiesContext
	public void testGetCountryByName() {
		Country country = countryDao.getCountryByName("Australia");
		assertEquals(exampleCountry, country);
	}

}
