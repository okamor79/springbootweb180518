package edu.logos.validator;

import edu.logos.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CheckCountryNameExistsValidator
        implements ConstraintValidator<CheckCountryNameExists, String> {

    @Autowired private CountryRepository countryRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (countryRepository.findCountryByName(s.toLowerCase()) == null) {
            return true;
        }
        return false;
    }
}
