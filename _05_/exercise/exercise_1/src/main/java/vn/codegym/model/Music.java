package vn.codegym.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    private Integer id;

    private String nameSong;
    private String nameSinger;
    private String musicGenre;
    private String linkSong;

    public Music() {
    }

    public Music(int id, String nameSong, String nameSinger, String musicGenre, String linkSong) {
        this.id = id;
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.musicGenre = musicGenre;
        this.linkSong = linkSong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    public String getLinkSong() {
        return linkSong;
    }

    public void setLinkSong(String linkSong) {
        this.linkSong = linkSong;
    }
}
