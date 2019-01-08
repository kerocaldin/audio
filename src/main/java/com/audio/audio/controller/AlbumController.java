package com.audio.audio.controller;

import com.audio.audio.model.Album;
import com.audio.audio.model.Artist;
import com.audio.audio.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    AlbumService albumService;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json",
            value = ""
    )
    public Album employe(@RequestBody Album a){
        return albumService.saveAlbum(a);
    }
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void albumDelete(@PathVariable(value = "id")Long id) throws Exception {
        albumService.deleteAlbum(id);
    }

}
