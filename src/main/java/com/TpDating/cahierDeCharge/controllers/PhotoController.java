package com.TpDating.cahierDeCharge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.TpDating.cahierDeCharge.entities.Photo;
import com.TpDating.cahierDeCharge.services.PhotoService;


@Controller
public class PhotoController {

    private String str;
    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    public void save(Photo photo){
        for (String p :photo.getLink().split(",")) {
            Photo ph = new Photo();
            ph.setUtilisateur(photo.getUtilisateur());
            ph.setLink(p);
            photoService.save(ph);
        }
    }

    public PhotoService getPhotoService() {
        return photoService;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }


}

