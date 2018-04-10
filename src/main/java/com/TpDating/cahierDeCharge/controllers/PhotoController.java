package com.TpDating.cahierDeCharge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.TpDating.cahierDeCharge.entities.Photo;
import com.TpDating.cahierDeCharge.services.FileUploadService;


@Controller
public class PhotoController {

    private final FileUploadService fileUploadService;

    @Autowired
    public PhotoController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    
    @PostMapping(value = "/uploadFile")   
    public String save(@RequestParam("file") MultipartFile file ,Photo photo){
    	fileUploadService.uploadFileHandler(file);
          return "/welcome";
        }
    

    public FileUploadService getFileUploadService() {
        return fileUploadService;
    }


}



