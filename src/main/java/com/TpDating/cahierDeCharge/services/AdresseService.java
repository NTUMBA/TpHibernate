package com.TpDating.cahierDeCharge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TpDating.cahierDeCharge.entities.Adresse;
import com.TpDating.cahierDeCharge.repositories.AdresseRepository;



@Service
public class AdresseService {
    private final AdresseRepository adresseRepository;

    @Autowired
    public AdresseService(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    public Adresse save(Adresse adresse){ 
    	return adresseRepository.save(adresse);
    	}
}
