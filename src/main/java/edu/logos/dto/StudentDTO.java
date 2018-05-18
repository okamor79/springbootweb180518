package edu.logos.dto;

import edu.logos.validator.CheckPasswordMacth;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@CheckPasswordMacth
public class StudentDTO {

    @NotEmpty
    private String firstName;

    @Size(min = 1, max = 20)
    private String lastName;

    @Min(value = 10)
    @Max(value = 90)
    private int age;

    private String password;
    private String passwordConfirm;


}
