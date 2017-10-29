package dao;

import model.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
public class CountryDaoImplTest {

	private Country exampleCountry = new Country(1,"Australia", "AU");

	@Autowired
	private CountryDao countryDao;

	@Test
	public void testSaveCountry() {
		countryDao.save(exampleCountry);

		List<Country> countryList = countryDao.getAllCountries();
        assertTrue(countryList.size() < 3);
		assertEquals(exampleCountry, countryList.get(0));
	}

	@Test
	public void testGtAllCountries() {
        countryDao.save(exampleCountry);
        countryDao.save(new Country(2,"Canada", "CA"));

		List<Country> countryList = countryDao.getAllCountries();
		assertEquals(2, countryList.size());
	}

	@Test
	public void testGetCountryByName() {
        countryDao.save(exampleCountry);

        Country country = countryDao.getCountryByName("Australia");
		assertEquals(exampleCountry, country);
	}

}
