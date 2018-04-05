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

import com.TpDating.cahierDeCharge.enumerations.ColorEyes;
import com.TpDating.cahierDeCharge.enumerations.ColorHair;
import com.TpDating.cahierDeCharge.enumerations.Origine;
import com.TpDating.cahierDeCharge.enumerations.TypeHair;


@Entity
public class Apparence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 3, name = "taille", nullable = false)
    private Integer size;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "couleurYeux", nullable = false)
    private ColorEyes eyes;
    
    @Enumerated(EnumType.STRING)
    private Origine origine;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "couleurCheveux")
    private ColorHair hair;
    
    @Enumerated(EnumType.STRING)
    private TypeHair typeHair;
    
    @Column(length = 3)
    private Integer masse;

    @OneToMany(mappedBy = "apparence")
    private Collection<Utilisateur> utilisateurs;

    public Apparence() {
    }

    public Apparence(Integer size, ColorEyes eyes, Origine origine, ColorHair hair, TypeHair typeHair, Integer masse) {
        this.size = size;
        this.eyes = eyes;
        this.origine = origine;
        this.hair = hair;
        this.typeHair = typeHair;
        this.masse = masse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public ColorEyes getEyes() {
        return eyes;
    }

    public void setEyes(ColorEyes eyes) {
        this.eyes = eyes;
    }

    public Origine getOrigine() {
        return origine;
    }

    public void setOrigine(Origine origine) {
        this.origine = origine;
    }

    public ColorHair getHair() {
        return hair;
    }

    public void setHair(ColorHair hair) {
        this.hair = hair;
    }

    public TypeHair getTypeHair() {
        return typeHair;
    }

    public void setTypeHair(TypeHair typeHair) {
        this.typeHair = typeHair;
    }

    public Integer getMasse() {
        return masse;
    }

    public void setMasse(Integer masse) {
        this.masse = masse;
    }

    public Collection<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    @Override
    public String toString() {
        return "Apparence{" +
                "id=" + id +
                ", size=" + size +
                ", eyes=" + eyes +
                ", origine=" + origine +
                ", hair=" + hair +
                ", typeHair=" + typeHair +
                ", masse=" + masse +
                ", utilisateurs=" + utilisateurs +
                '}';
    }

    
}
