package vn.codegym.repository;

import vn.codegym.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    void create(Music music);

    Music findById(int id);

    void update(int id, Music music);

    void remove(int id);
}
