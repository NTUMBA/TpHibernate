package com.TpDating.cahierDeCharge.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TpDating.cahierDeCharge.entities.Utilisateur;
import com.TpDating.cahierDeCharge.repositories.UtilisateurRepository;




@Service
public class UtilisateurService {
	
	 private final UtilisateurRepository utilisateurRepository;

	    @Autowired
	    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
	        this.utilisateurRepository = utilisateurRepository;
	    }

	    public Utilisateur save(Utilisateur utilisateur){
	    	return utilisateurRepository.save(utilisateur);
	    	}

	    public Utilisateur findUtilisateurByEmailAndPassword(String email, String password){
//	    	if(email == utilisateur.getEmail() && password ==utilisateur.getPassword())
//	    	return utilisateurRepository.findUtilisateurByEmailAndPassword(email, password);
	    	if(utilisateurRepository.getOne(email).getPassword().equals(password)){
	    		return utilisateurRepository.getOne(email);
	    	}
	    	return null;
	    	
	    }
	}
 	

