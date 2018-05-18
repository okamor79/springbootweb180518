package edu.logos.validator;

import edu.logos.entity.User;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CheckConfirmPasswordValidator implements ConstraintValidator<CheckConfirmPassword, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            System.out.println(user.getPassword());
            return true;
        }
        return false;
    }

}
