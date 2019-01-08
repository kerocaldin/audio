package com.audio.audio.Repository;

import com.audio.audio.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist,Long> {
    List<Artist> findByNameLike(String name);

    Page<Artist> findAll(Pageable pageable);

}
