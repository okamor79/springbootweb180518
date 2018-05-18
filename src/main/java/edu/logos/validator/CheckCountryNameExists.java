package edu.logos.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = CheckCountryNameExistsValidator.class)
public @interface CheckCountryNameExists {

    String message() default "Country already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
