package edu.logos.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Constraint(validatedBy = CheckConfirmPasswordValidator.class)
public @interface CheckConfirmPassword {

    String message() default "Confirm password not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
