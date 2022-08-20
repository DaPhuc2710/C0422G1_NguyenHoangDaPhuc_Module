package com.example.service.impl;

import com.example.model.MusicApp;
import com.example.repository.IMusicAppRepository;
import com.example.service.IMusicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicAppService implements IMusicAppService {
    @Autowired
    IMusicAppRepository iMusicAppRepository;
    @Override
    public void create(MusicApp musicApp) {
        iMusicAppRepository.create(musicApp);

    }

    @Override
    public void update(MusicApp musicApp) {
        iMusicAppRepository.update(musicApp);

    }

    @Override
    public void delete(int id) {
        iMusicAppRepository.delete(id);

    }

    @Override
    public List<MusicApp> findAll() {
        return iMusicAppRepository.findAll();
    }

    @Override
    public MusicApp findById(int id) {
        return iMusicAppRepository.findById(id);
    }
}
