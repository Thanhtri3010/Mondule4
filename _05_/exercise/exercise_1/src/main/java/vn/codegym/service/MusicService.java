package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Music;
import vn.codegym.repository.IMusicRepository;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void create(Music music) {
        musicRepository.create(music);
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id);
    }

    @Override
    public void update(int id, Music product) {
        musicRepository.update(id, product);
    }

    @Override
    public void remove(int id) {
        musicRepository.remove(id);
    }
}
