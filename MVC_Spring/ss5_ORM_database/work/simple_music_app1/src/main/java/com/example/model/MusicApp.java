package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "music_app")
public class MusicApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String artist;
    @Column (name = "type_of_music")
    private String typeOfMusic;
    @Column
    private String link;

    public MusicApp() {
    }

    public MusicApp(String name, String artist, String typeOfMusic, String link) {
        this.name = name;
        this.artist = artist;
        this.typeOfMusic = typeOfMusic;
        this.link = link;
    }

    public MusicApp(Integer id, String name, String artist, String typeOfMusic, String link) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.typeOfMusic = typeOfMusic;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
