package com.TpDating.cahierDeCharge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TpDating.cahierDeCharge.entities.CentreInteret;
import com.TpDating.cahierDeCharge.repositories.Centre_interetRepository;



@Service
public class Centre_interetService {
	private final Centre_interetRepository centre_interetRepository;

	@Autowired
	public Centre_interetService(Centre_interetRepository centre_interetRepository) {
		this.centre_interetRepository = centre_interetRepository;
	}

	public CentreInteret save(CentreInteret centreInteret) {
		return centre_interetRepository.save(centreInteret);
	}
	

}
