package edu.logos.entity;

import edu.logos.validator.CheckConfirmPassword;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name ="user", indexes = {
        @Index(columnList = "user_name", name = "INDX_UserName"),
        @Index(columnList = "first_name, last_name", name = "INDX_FN_LN")}
        )
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

    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private UserImages userImages;
}
