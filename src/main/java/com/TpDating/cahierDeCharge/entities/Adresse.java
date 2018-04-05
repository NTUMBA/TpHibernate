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
import javax.validation.constraints.Pattern;

import com.TpDating.cahierDeCharge.enumerations.AdressTypeStreet;
import com.TpDating.cahierDeCharge.enumerations.AdressePrefixe;

@Entity
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 5, name = "codePostal", nullable = false)
    @Pattern(regexp = "[0-9]{5}", message = "Problem")
    private String postalCode;
    @Column(length = 50, name = "ville", nullable = false)
    @Pattern(regexp = "(?i)[a-z -_]{1,50}")
    private String town;
    @Column(length = 5, name = "numero", nullable = false)
    @Pattern(regexp = "[0-9]{1,5}", message = "problem")
    private String number;
    @Enumerated(EnumType.STRING)
    private AdressTypeStreet typeStreet;
    @Column(name = "nomRue", nullable = false)
    @Pattern(regexp = "(?i)[a-z -_']{1,100}")
    private String nameStreet;

    private String complement;
    @Enumerated(EnumType.STRING)
    @Column(length = 5, name = "prefixe")
    private AdressePrefixe prefix;

    @OneToMany(mappedBy = "adresse")
    private Collection<Utilisateur> utilisateurs;

    public Adresse() {
    }

    public Adresse(String postalCode, String town, String number, AdressTypeStreet typeStreet, String nameStreet, String complement, AdressePrefixe prefix) {
        this.postalCode = postalCode;
        this.town = town;
        this.number = number;
        this.typeStreet = typeStreet;
        this.nameStreet = nameStreet;
        this.complement = complement;
        this.prefix = prefix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public AdressTypeStreet getTypeStreet() {
        return typeStreet;
    }

    public void setTypeStreet(AdressTypeStreet typeStreet) {
        this.typeStreet = typeStreet;
    }

    public String getNameStreet() {
        return nameStreet;
    }

    public void setNameStreet(String nameStreet) {
        this.nameStreet = nameStreet;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public AdressePrefixe getPrefix() {
        return prefix;
    }

    public void setPrefix(AdressePrefixe prefix) {
        this.prefix = prefix;
    }

    public Collection<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", postalCode=" + postalCode +
                ", town='" + town + '\'' +
                ", number=" + number +
                ", typeStreet=" + typeStreet +
                ", nameStreet='" + nameStreet + '\'' +
                ", complement='" + complement + '\'' +
                ", prefix=" + prefix +
                ", utilisateurs=" + utilisateurs +
                '}';
    }

}

