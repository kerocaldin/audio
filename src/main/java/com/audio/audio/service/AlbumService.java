package com.audio.audio.service;

import com.audio.audio.Repository.AlbumRepository;
import com.audio.audio.model.Album;
import com.audio.audio.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;

    public Album saveAlbum(Album a) {
        return albumRepository.save(a);
    }

    public void deleteAlbum(Long id) {
        albumRepository.delete(id);
    }
}
