package edu.logos.formatter;

import edu.logos.entity.Country;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CountryFormatter implements Formatter<Country> {
    @Override
    public Country parse(String s, Locale locale) throws ParseException {
        System.out.println("Parse" + s);
        int countryID = Integer.valueOf(s);
        Country country = new Country();
        country.setId(countryID);
        return country;
    }

    @Override
    public String print(Country object, Locale locale) {
        System.out.println("Print:" + object.getId());
        return String.valueOf(object.getId());
    }
}
