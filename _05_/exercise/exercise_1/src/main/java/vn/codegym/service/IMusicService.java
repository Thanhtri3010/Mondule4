package vn.codegym.service;

import vn.codegym.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void create(Music music);

    Music findById(int id);

    void update(int id, Music product);

    void remove(int id);


}
