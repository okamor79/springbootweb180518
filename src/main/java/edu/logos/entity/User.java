package edu.logos.entity;

import edu.logos.validator.CheckConfirmPassword;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="user")
@CheckConfirmPassword(message = "snjvsdjjvsd")
@Getter @Setter @NoArgsConstructor @ToString(callSuper = true)
public class User extends BaseEntity {

    @NotEmpty
    @Column(name = "user_name")
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @Size(min = 4, max = 10)
    private String password;

    @Transient
    private String confirmPassword;

    @Email
    private String email;
}
