package com.TpDating.cahierDeCharge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TpDating.cahierDeCharge.entities.Utilisateur;





@Repository // On indique a Spring qu il s agit d un repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, String> {

	public Utilisateur findUtilisateurByEmailAndPassword(String email, String password);
}
	