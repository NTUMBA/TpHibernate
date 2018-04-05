package com.TpDating.cahierDeCharge.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@Entity
public class CentreInteret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "text")
    @Pattern(regexp = "(?i)[a-z -_,]{0,1000}")
    private String sport;
    @Column(name = "loisir", columnDefinition = "text")
    @Pattern(regexp = "(?i)[a-z -_,]{0,1000}")
    private String hobby;

    @ManyToMany(mappedBy = "centreInterets")
    private Collection<Utilisateur> utilisateurs;

    @ManyToMany
    private Collection<Multimedia> multimedias;

    public CentreInteret() {
    }

    public CentreInteret(String sport, String hobby) {
        this.sport = sport;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Collection<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public Collection<Multimedia> getMultimedias() {
        return multimedias;
    }

    public void setMultimedias(Collection<Multimedia> multimedias) {
        this.multimedias = multimedias;
    }

    @Override
    public String toString() {
        return "CentreInteret{" +
                "id=" + id +
                ", sport=" + sport +
                ", hobby='" + hobby + '\'' +
                ", utilisateurs=" + utilisateurs +
                ", multimedias=" + multimedias +
                '}';
    }
    
}

