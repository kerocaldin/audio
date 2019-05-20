package com.audio.audio.controller;

import com.audio.audio.service.ArtistService;
import com.audio.audio.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    ArtistService artistService;

    @RequestMapping("/{id}")
    public Artist artist(@PathVariable(value="id") Long id)throws Exception {
        return artistService.findById(id);
    }

    @RequestMapping(params = "name")
    public List<Artist> artists(@RequestParam(value="name") String name)throws Exception {
        return artistService.findByName(name);
    }

    @RequestMapping("")
    public Page<Artist> listeArtists(
            @RequestParam(value="page")Integer page, @RequestParam(value = "size")Integer size,
            @RequestParam(value="sortDirection") String sortDirection,
            @RequestParam(value="sortProperty") String sortProperty){

        return artistService.findAll(page,size,sortDirection,sortProperty);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json",
            value = ""
    )
    public Artist employe( @RequestBody Artist a){
        return artistService.saveArtist(a);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{id}"
    )
    public Artist employe(@PathVariable(value = "id")Long id,@RequestBody Artist a) throws Exception
    {
        return artistService.updateEmploye(id, a);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void artistDelete(@PathVariable(value = "id")Long id) throws Exception {
        artistService.deleteArtist(id);
    }


}
