package com.music.grytfit.controller;

import java.util.ArrayList;
import java.util.List;

import com.music.grytfit.data.Playlist;
import com.music.grytfit.services.PlaylistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistController {

    @Autowired
    private PlaylistService instanceOfPlaylistService;

    @GetMapping("/playlist")
    public List<Playlist> getPlaylist() {
        return instanceOfPlaylistService.getPlaylist();
    }

    @GetMapping("/playlist/{allTags}")
    public List<Playlist> getSearchedPlaylist(@PathVariable String allTags) {
        List<String> tags = new ArrayList<>();

        String[] tagsArray = allTags.split("@");
        for (String tag : tagsArray) {
            tags.add(tag);
        }

        return instanceOfPlaylistService.getSearchedPlaylist(tags);
    }

    @PostMapping("/playlist")
    public ResponseEntity<HttpStatus> postPlaylist(@RequestBody Playlist playlist) {
        try {
            instanceOfPlaylistService.postPlaylist(playlist);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/playlist/{playlistId}")
    public ResponseEntity<HttpStatus> deletePlaylist(@PathVariable String playlistId) {
        try {
            instanceOfPlaylistService.deletePlaylist(Integer.parseInt(playlistId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
