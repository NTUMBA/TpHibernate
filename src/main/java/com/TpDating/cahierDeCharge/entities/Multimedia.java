package com.TpDating.cahierDeCharge.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Pattern;

import com.TpDating.cahierDeCharge.enumerations.MultimediaType;

import java.util.Collection;

@Entity
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "typeMultimedia", nullable = false)
    @Enumerated(EnumType.STRING)
    private MultimediaType type;
    private String genre;
    @Column(name = "titre")
    @Pattern(regexp = "(?i)[a-z -_]{1,50}")
    private String title;
    @Column(name = "artiste")
    @Pattern(message = "Artiste name  lack or invalid format, exceed 50 characters", regexp = "(?i)[a-z -_]{1,50}")
    private String artist;

    @ManyToMany(mappedBy = "multimedias")
    private Collection<CentreInteret> centreInterets;

    public Multimedia() {
    }

    public Multimedia(MultimediaType type, String genre, String title, String artist) {
        this.type = type;
        this.genre = genre;
        this.title = title;
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultimediaType getType() {
        return type;
    }

    public void setType(MultimediaType type) {
        this.type = type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Collection<CentreInteret> getCentreInterets() {
        return centreInterets;
    }

    public void setCentreInterets(Collection<CentreInteret> centreInterets) {
        this.centreInterets = centreInterets;
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "id=" + id +
                ", type=" + type +
                ", genre='" + genre + '\'' +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", centreInterets=" + centreInterets +
                '}';
    }


}