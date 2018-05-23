package edu.logos.service;

import edu.logos.entity.UploadFile;

public interface UploadFileService {

    void save(UploadFile uploadFile);

    UploadFile findByID(int id);

}
