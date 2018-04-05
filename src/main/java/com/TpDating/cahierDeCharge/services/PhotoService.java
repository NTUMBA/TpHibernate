package com.TpDating.cahierDeCharge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TpDating.cahierDeCharge.entities.Photo;
import com.TpDating.cahierDeCharge.repositories.PhotoRepository;



@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Photo save(Photo photo){
    	return photoRepository.save(photo);
    	}
}
