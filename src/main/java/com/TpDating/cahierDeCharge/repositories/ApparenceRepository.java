package com.TpDating.cahierDeCharge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TpDating.cahierDeCharge.entities.Apparence;







@Repository // On indique a Spring qu il s agit d un repository
public interface ApparenceRepository extends JpaRepository<Apparence, Long> {

}