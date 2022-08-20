package com.example.service;

import com.example.model.MusicApp;

import java.util.List;

public interface IMusicAppService {
    void create(MusicApp musicApp);

    void update(MusicApp musicApp);

    void delete( int id);

    List<MusicApp> findAll();
    MusicApp findById(int id);
}
