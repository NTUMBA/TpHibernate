package com.TpDating.cahierDeCharge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TpDating.cahierDeCharge.entities.Apparence;
import com.TpDating.cahierDeCharge.repositories.ApparenceRepository;



@Service
public class ApparenceService {
    private final ApparenceRepository apparenceRepository;

    @Autowired
    public ApparenceService(ApparenceRepository apparenceRepository) {
        this.apparenceRepository = apparenceRepository;
    }

    public Apparence save(Apparence apparence){return apparenceRepository.save(apparence);}
}
