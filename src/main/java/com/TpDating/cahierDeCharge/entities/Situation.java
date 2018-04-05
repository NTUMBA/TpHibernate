package com.TpDating.cahierDeCharge.entities;



import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.TpDating.cahierDeCharge.enumerations.Alcool;
import com.TpDating.cahierDeCharge.enumerations.Fumeur;
import com.TpDating.cahierDeCharge.enumerations.Orientation;
import com.TpDating.cahierDeCharge.enumerations.StatusPerso;
import com.TpDating.cahierDeCharge.enumerations.StatusPro;

@Entity
public class Situation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPro statusPro;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPerso statusPerso;
    
    @Column(name = "nbrEnfant", length = 2, nullable = false)
    private Integer numChild;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Orientation orientation;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Fumeur fumeur;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Alcool alcool;

    @OneToMany(mappedBy = "situation")
    private Collection<Utilisateur> utilisateurs;

    public Situation() {
    }

    public Situation(StatusPro statusPro, StatusPerso statusPerso, Integer numChild, Orientation orientation, Fumeur fumeur, Alcool alcool) {
        this.statusPro = statusPro;
        this.statusPerso = statusPerso;
        this.numChild = numChild;
        this.orientation = orientation;
        this.fumeur = fumeur;
        this.alcool = alcool;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusPro getStatusPro() {
        return statusPro;
    }

    public void setStatusPro(StatusPro statusPro) {
        this.statusPro = statusPro;
    }

    public StatusPerso getStatusPerso() {
        return statusPerso;
    }

    public void setStatusPerso(StatusPerso statusPerso) {
        this.statusPerso = statusPerso;
    }

    public Integer getNumChild() {
        return numChild;
    }

    public void setNumChild(Integer numChild) {
        this.numChild = numChild;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Fumeur getFumeur() {
        return fumeur;
    }

    public void setFumeur(Fumeur fumeur) {
        this.fumeur = fumeur;
    }

    public Alcool getAlcool() {
        return alcool;
    }

    public void setAlcool(Alcool alcool) {
        this.alcool = alcool;
    }

    public Collection<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    @Override
    public String toString() {
        return "Situation{" +
                "id=" + id +
                ", statusPro='" + statusPro + '\'' +
                ", statusPerso=" + statusPerso +
                ", numChild=" + numChild +
                ", orientation=" + orientation +
                ", fumeur=" + fumeur +
                ", alcool=" + alcool +
                ", utilisateurs=" + utilisateurs +
                '}';
    }
}
