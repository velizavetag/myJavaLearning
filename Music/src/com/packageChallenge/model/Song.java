package com.packageChallenge.model;

public class Song {
    private int id;
    private int song;
    private String name;
    private int albumId;

    public Song(int id, int song, String name, int albumId) {
        this.id = id;
        this.song = song;
        this.name = name;
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
}
