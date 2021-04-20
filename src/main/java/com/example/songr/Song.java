package com.example.songr;


import javax.persistence.*;

@Entity
public class Song {

    String title;
    int length;
    int trackNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    Album album;

    public Song() {
    }

    public Song(String title, int length, int trackNumber,Album album) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Integer getId() {
        return id;
    }

    public Album  getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
