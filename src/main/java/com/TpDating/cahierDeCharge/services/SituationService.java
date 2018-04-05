package com.TpDating.cahierDeCharge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TpDating.cahierDeCharge.entities.Situation;
import com.TpDating.cahierDeCharge.repositories.SituationRepository;


@Service
public class SituationService {
    private final SituationRepository situationRepository;

    @Autowired
    public SituationService(SituationRepository situationRepository) {
        this.situationRepository = situationRepository;
    }

    public Situation save(Situation situation){
    	return situationRepository.save(situation);
    	}
}
