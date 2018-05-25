package edu.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "student", indexes = @Index(columnList = "first_name, last_name"))
@Getter @Setter @NoArgsConstructor @ToString(callSuper = true)
public class Student extends BaseEntity {

    @NotEmpty
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(min = 1, max = 20)
    @Column(name = "last_name")
    private String lastName;

    @Min(value = 10)
    @Max(value = 90)
    private int age;

    @NotNull(message = "Select country please")
    @ManyToOne
    @JoinColumn
    private Country country;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private StudentDetails studentDetails;
}
