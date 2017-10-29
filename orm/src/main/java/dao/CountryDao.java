package dao;

import java.util.List;

import model.Country;
import org.jetbrains.annotations.NotNull;

public interface CountryDao {

	void save(@NotNull Country country);

	List<Country> getAllCountries();

	Country getCountryByName(String name);

}