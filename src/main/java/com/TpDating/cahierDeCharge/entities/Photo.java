package com.TpDating.cahierDeCharge.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "lien", nullable = false)
    private String link;
    @Column(length = 1)
    private Integer note;

    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public Photo() {
    }

    public Photo(String link, Integer note) {
        this.link = link;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", note=" + note +
                ", utilisateur=" + utilisateur +
                '}';
    }


}