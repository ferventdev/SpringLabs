package service;

import java.util.List;

import model.Country;

import org.springframework.transaction.annotation.Propagation;

public interface CountryService {

    @SuppressWarnings("unused")
    List<Country> getAllCountriesInsideTransaction(Propagation propagation);

    List<Country> getAllCountriesRequired();

    List<Country> getAllCountriesRequiresNew();

    List<Country> getAllCountriesSupports();

    List<Country> getAllCountriesNever();

    List<Country> getAllCountriesMandatory();

    List<Country> getAllCountriesNotSupported();

    List<Country> getAllCountries();
}
