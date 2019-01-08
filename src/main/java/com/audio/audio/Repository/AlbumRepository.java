package com.audio.audio.Repository;

import com.audio.audio.model.Album;
import com.audio.audio.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository  extends JpaRepository<Album,Long> {

}
