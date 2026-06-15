package org.example.music.service;

import org.example.music.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> findAll();

    Song findById(Integer id);

    void save(Song song);

    void delete(Integer id);
}