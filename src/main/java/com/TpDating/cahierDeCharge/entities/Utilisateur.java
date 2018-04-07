package com.TpDating.cahierDeCharge.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.TpDating.cahierDeCharge.enumerations.Sexe;

@Entity
public class Utilisateur {
	
    @Id
    @Column(length = 100)
    @Pattern(message = "Email lack or invalid format ", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    private String email;
    
    @Column(length = 70, name = "nom", nullable = false)
    @Pattern(message = "Lastname lack or invalid format", regexp = "(?i)[a-z -_]{1,70}")
    private String lastName;
    
    @Column(length = 100, name = "prenom", nullable = false)
    @Pattern(message = "Name lack or invalid format,must not exceed 15 characters ", regexp = "(?i)[a-z -_]{1,100}" )
    private String firstName;
    
    @Column(columnDefinition = "date", name = "dateDeNaissance", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date birthday;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexe sexe;
    
    @Column(length = 50, name = "motDePasse", nullable = false)
    private String password;

    @Column(length = 450, columnDefinition = "text")
    @Pattern(message = "Character number cant exceed 450", regexp = "(?i)[a-z. -!,;:_()]{0,1000}")
    private String description;
    
    @Column(length = 50, nullable = false)
    @Pattern(message = "Pseudo lack or invalid format", regexp = "(?i)[a-z0-9-_]{4,50}")
    private String pseudo;
    
    @Column(name = "numeroTel", length = 10)
    @Pattern(message = "Phone number lack or invalid format", regexp = "^0[0-9]{9}$")
    private String phone;
    
    @Column(name = "type", length = 1)
    private Integer admin;

    @ManyToMany
    @JoinTable(
            name = "favoris",
            joinColumns = { @JoinColumn(name = "user_email") },
            inverseJoinColumns = { @JoinColumn(name = "favoris_email") }
    )
    private Collection<Utilisateur> utilisateurs;

    @ManyToMany
    @JoinTable(
            name = "user_centre_interet",
            joinColumns = { @JoinColumn(name = "user_email") },
            inverseJoinColumns = { @JoinColumn(name = "ci_id") }
    )
    private Collection<CentreInteret> centreInterets;

    @OneToMany(mappedBy = "utilisateur")
    private Collection<Photo> photos;

    @ManyToOne(optional = true)
    private Situation situation;

    @ManyToOne(optional = false)
    private Adresse adresse;

    @ManyToOne(optional = true)
    private Apparence apparence;

    public Utilisateur() {
    }

    public Utilisateur(String email, String lastName, String firstName, Date birthday, Sexe sexe, String password, String description, String pseudo, String phone, Integer admin) {
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.sexe = sexe;
        this.password = password;
        this.description = description;
        this.pseudo = pseudo;
        this.phone = phone;
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public Collection<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public Collection<CentreInteret> getCentreInterets() {
        return centreInterets;
    }

    public void setCentreInterets(Collection<CentreInteret> centreInterets) {
        this.centreInterets = centreInterets;
    }

    public Collection<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Collection<Photo> photos) {
        this.photos = photos;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Apparence getApparence() {
        return apparence;
    }

    public void setApparence(Apparence apparence) {
        this.apparence = apparence;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday=" + birthday +
                ", sexe=" + sexe +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", phone='" + phone + '\'' +
                ", admin=" + admin +
                ", utilisateurs=" + utilisateurs +
                ", centreInterets=" + centreInterets +
                ", photos=" + photos +
                ", situation=" + situation +
                ", adresse=" + adresse +
                ", apparence=" + apparence +
                '}';
    }

}