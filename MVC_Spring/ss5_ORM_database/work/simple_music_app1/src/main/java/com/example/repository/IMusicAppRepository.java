package com.example.repository;

import com.example.model.MusicApp;

import java.util.List;

public interface IMusicAppRepository {
    void create(MusicApp musicApp);

    void update(MusicApp musicApp);

    void delete( int id);

    List<MusicApp> findAll();
    MusicApp findById(int id);
}
