package com.music.grytfit.services;

import java.util.List;

import com.music.grytfit.data.Playlist;

public interface PlaylistService {

    public List<Playlist> getPlaylist();

    public List<Playlist> getSearchedPlaylist(List<String> tags);

    public void postPlaylist(Playlist playlist);

    public void deletePlaylist(int playlistId);
}
