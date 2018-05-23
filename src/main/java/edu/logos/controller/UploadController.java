package edu.logos.controller;

import edu.logos.entity.UploadFile;
import edu.logos.service.UploadFileService;
import edu.logos.service.utils.CustomFileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired private UploadFileService uploadFileService;

    @GetMapping("/db")
    public String showUploadDb() {
        return "upload-db";
    }

    @PostMapping("/db")
    public String saveUploadDb(@RequestParam("imageFile") MultipartFile file) throws Exception {

        UploadFile uploadFile = new UploadFile();

        uploadFile.setFileName(file.getOriginalFilename());
        uploadFile.setFileData(file.getBytes());
        uploadFileService.save(uploadFile);

        return "redirect:/";
    }

    @GetMapping("/db/{imageID}")
    public String showFromDB(@PathVariable("imageID") int id,  Model model) {
        UploadFile file = uploadFileService.findByID(id);

        String encodeFile = new String(Base64.encodeBase64(file.getFileData()));

        model.addAttribute("imageSrc", encodeFile);

        return "preview-db";
    }

    @GetMapping("/fs")
    public String showUploadFS() {
        return "upload-fs";
    }

    @PostMapping("/fs")
    public String writeToFS(@RequestParam("imageFile") MultipartFile file) throws Exception {

        CustomFileUtils.createImage("test", file);
        return "redirect:/";
    }

    @GetMapping("/fs/show")
    public String readImageFS(Model model) throws Exception {
        model.addAttribute("imageSrc", CustomFileUtils.getImage("test", "fsfnafbn.jpg"));
        return "preview-db";
    }

}
