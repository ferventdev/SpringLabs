package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import dao.CountryDao;
import model.Country;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

	@Override
	public void save(Country country) {
		EntityManager em = getEmf().createEntityManager();

		em.getTransaction().begin();
		em.persist(country);
		em.getTransaction().commit();

		if (em != null) em.close();
	}

	@Override
	public List<Country> getAllCountries() {

		List<Country> countryList = null;
		EntityManager em = getEmf().createEntityManager();

		countryList = em.createQuery("SELECT c FROM Country c", Country.class).getResultList();

		if (em != null) em.close();

		return countryList;
	}

	@Override
	public Country getCountryByName(String name) {

		EntityManager em = getEmf().createEntityManager();
		em.createQuery("SELECT c FROM Country c", Country.class).getResultList();

		Country country = em
				.createQuery("SELECT c FROM Country c WHERE c.name LIKE :name",
						Country.class).setParameter("name", name)
				.getSingleResult();

		if (em != null) em.close();

		return country;
	}
}
