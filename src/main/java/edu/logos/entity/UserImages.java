package edu.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_image")
@Getter
@Setter
@NoArgsConstructor
public class UserImages extends BaseEntity {

    private String imageName;

}
