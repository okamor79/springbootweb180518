package edu.logos.service.impl;

import edu.logos.entity.UploadFile;
import edu.logos.repository.UploadFileRepository;
import edu.logos.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadFileServiceImpl implements UploadFileService {

    @Autowired private UploadFileRepository uploadFileRepository;

    @Override
    public void save(UploadFile uploadFile) {
        uploadFileRepository.save(uploadFile);
    }

    @Override
    public UploadFile findByID(int id) {
        return uploadFileRepository.getOne(id);
    }
}
