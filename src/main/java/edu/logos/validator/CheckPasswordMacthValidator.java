package edu.logos.validator;

import edu.logos.dto.StudentDTO;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CheckPasswordMacthValidator implements ConstraintValidator<CheckPasswordMacth, StudentDTO> {

    @Override
    public boolean isValid(StudentDTO student, ConstraintValidatorContext constraintValidatorContext) {

        if (student.getPassword().equals("") && student.getPasswordConfirm().equals("")) {
            return false;
        }

        if (student.getPassword().equals(student.getPasswordConfirm())) {
            return true;
        }

        return false;
    }
}
