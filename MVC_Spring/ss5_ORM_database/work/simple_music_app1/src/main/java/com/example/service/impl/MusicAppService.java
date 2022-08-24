package com.example.service.impl;

import com.example.model.MusicApp;
import com.example.repository.IMusicAppRepository;
import com.example.service.IMusicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class MusicAppService implements IMusicAppService {
    @Autowired
    private IMusicAppRepository iMusicAppRepository;

    @Override
    public void create(MusicApp musicApp) {
        String fileName = musicApp.getImgFile().getOriginalFilename();
        try {
            FileCopyUtils.copy(musicApp.getImgFile().getBytes(), new File("D:/up/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        musicApp.setLink(fileName);
        iMusicAppRepository.create(musicApp);
    }

    @Override
    public void update(MusicApp musicApp) {
        String fileName;
        fileName = musicApp.getImgFile().getOriginalFilename();
        if (fileName != "") {
            try {
                FileCopyUtils.copy(musicApp.getImgFile().getBytes(), new File("D:/up/" + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            musicApp.setLink(fileName);
        }
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
