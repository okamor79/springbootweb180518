package edu.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "upload_file")
@Getter @Setter @NoArgsConstructor
public class UploadFile extends BaseEntity{

    private String fileName;

    //BLOB - 64k
    //MEDIUMBLOB - 16Mb
    //LONGBLOB - 64Gb

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] fileData;

}
