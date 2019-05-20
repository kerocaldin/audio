package com.audio.audio.service;

import com.audio.audio.Repository.ArtistRepository;
import com.audio.audio.exception.AlreadyExistException;
import com.audio.audio.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ArtistService {
    @Autowired
    ArtistRepository artistRepository;

    public Artist findById(Long id) throws EntityNotFoundException {
        if(artistRepository.exists(id)){
            return artistRepository.findOne(id);
        }else{
            throw new EntityNotFoundException("L'artist d'identifiant : " +
                    id + " n'a pas été trouvé.");
        }
    }

    public List<Artist> findByName(String name) throws Exception{
        return artistRepository.findByNameContaining(name);
    }

    public Page<Artist> findAll(Integer page, Integer size, String sortDirection, String sortProperty){
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.fromString(sortDirection),sortProperty);
        return artistRepository.findAll(pageRequest);
    }

    public Artist saveArtist(Artist a) {
        if(artistRepository.findByNameLike(a.getName()).size()==0) {
            return artistRepository.save(a);
        }else{
            throw new AlreadyExistException("l'artist : " + a.getName() + " existe deja.");
        }
    }

    public Artist updateEmploye(Long id, Artist a) throws Exception {
        return artistRepository.save(a);

    }



    public void deleteArtist(Long id){
        artistRepository.delete(id);
    }
}
