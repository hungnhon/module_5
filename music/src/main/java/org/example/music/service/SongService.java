package org.example.music.service;

import lombok.RequiredArgsConstructor;
import org.example.music.model.Song;
import org.example.music.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService implements ISongService {

    private final SongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Integer id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void delete(Integer id) {
        songRepository.deleteById(id);
    }
}