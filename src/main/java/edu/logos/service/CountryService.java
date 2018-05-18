package edu.logos.service;

import edu.logos.entity.Country;

import java.util.List;

public interface CountryService {

    void saveCountry(Country country);

    Country findCountryByID(int id);

    List<Country> findAllCountrys();
}
