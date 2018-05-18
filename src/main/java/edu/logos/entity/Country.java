package edu.logos.entity;

import edu.logos.validator.CheckCountryNameExists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "country")
@Getter @Setter @NoArgsConstructor
public class Country extends BaseEntity {

    @CheckCountryNameExists
    @NotEmpty(message = "Field NAME can't be empty")
    private String name;

    @Size(min = 1, max = 3, message = "Field SHORD_NAME length is invalid")
    @NotEmpty(message = "Field SHORT_NAME can't be empty")
    @Column(name = "short_name")
    private String shortName;

}
