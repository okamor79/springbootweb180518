package edu.logos.service.impl;

import edu.logos.entity.Country;
import edu.logos.repository.CountryRepository;
import edu.logos.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired private CountryRepository countryRepository;

    @Override
    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    public Country findCountryByID(int id) {
        return countryRepository.getOne(id);
    }

    @Override
    public List<Country> findAllCountrys() {
        return countryRepository.findAll();
    }
}
