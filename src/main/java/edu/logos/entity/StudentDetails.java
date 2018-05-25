package edu.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
@Getter @Setter @NoArgsConstructor
public class StudentDetails extends BaseEntity {

    private String email;

}
