package edu.logos.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    @NotEmpty
    private String firstName;

    @Size(min = 1, max = 20)
    private String lastName;

    private String email;

    private String userName;

    private int salary;

    private String imageName;
}
