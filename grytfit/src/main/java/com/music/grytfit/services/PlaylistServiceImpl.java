package com.music.grytfit.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.music.grytfit.data.Playlist;

import org.springframework.stereotype.Service;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    // @Autowired
    // private PlaylistRepository instanceOfPlaylistRepository;

    private static List<Playlist> allPlaylist = new ArrayList<>();

    static {
        Playlist instanceOfPlaylist1 = new Playlist(1, "Rock Collection", "hello", 10, 100, 55,
                Arrays.asList("Hello", "world"));
        Playlist instanceOfPlaylist2 = new Playlist(2, "Sufi Collection", "hello", 20, 70, 10,
                Arrays.asList("Hello", "world"));
        Playlist instanceOfPlaylist3 = new Playlist(3, "Romantic Collection", "hello", 12, 60, 5,
                Arrays.asList("Calm", "Love"));
        Playlist instanceOfPlaylist4 = new Playlist(4, "Motivation Collection", "hello", 2, 55, 50,
                Arrays.asList("Hello", "world"));
        Playlist instanceOfPlaylist5 = new Playlist(5, "Morning Collection", "hello", 10, 50, 15,
                Arrays.asList("Morning", "Calm"));
        Playlist instanceOfPlaylist6 = new Playlist(6, "Evening Collection", "hello", 5, 110, 50,
                Arrays.asList("Evening", "Energy"));
        Playlist instanceOfPlaylist7 = new Playlist(7, "Night Collection", "hello", 75, 100, 55,
                Arrays.asList("Night", "Lonely"));
        Playlist instanceOfPlaylist8 = new Playlist(8, "Band Music", "hello", 25, 35, 20,
                Arrays.asList("Band", "Rock"));
        Playlist instanceOfPlaylist9 = new Playlist(9, "Calm Collection", "hello", 95, 40, 2,
                Arrays.asList("Calm", "world"));
        Playlist instanceOfPlaylist10 = new Playlist(10, "Rock Collection", "hello", 20, 100, 50,
                Arrays.asList("Hello", "world"));

        allPlaylist.add(instanceOfPlaylist1);
        allPlaylist.add(instanceOfPlaylist2);
        allPlaylist.add(instanceOfPlaylist3);
        allPlaylist.add(instanceOfPlaylist4);
        allPlaylist.add(instanceOfPlaylist5);
        allPlaylist.add(instanceOfPlaylist6);
        allPlaylist.add(instanceOfPlaylist7);
        allPlaylist.add(instanceOfPlaylist8);
        allPlaylist.add(instanceOfPlaylist9);
        allPlaylist.add(instanceOfPlaylist10);
    }

    @Override
    public List<Playlist> getPlaylist() {
        Collections.sort(allPlaylist);
        return allPlaylist;
    }

    @Override
    public List<Playlist> getSearchedPlaylist(List<String> tags) {

        List<String> lowercaseTags = convertToLowercase(tags);

        List<Playlist> searchedPlaylist = new ArrayList<>();

        for (Playlist playlist : allPlaylist) {
            List<String> matchTags = playlist.getTags();
            List<String> lowercaseMatchTags = convertToLowercase(matchTags);
            if (lowercaseTags.stream().allMatch(element -> lowercaseMatchTags.contains(element))) {
                searchedPlaylist.add(playlist);
            }
        }
        Collections.sort(searchedPlaylist);
        return searchedPlaylist;
    }

    @Override
    public void postPlaylist(Playlist playlist) {
        allPlaylist.add(playlist);
    }

    @Override
    public void deletePlaylist(int playlistId) {
        List<Playlist> filteredPlaylist = new ArrayList<>();

        for (Playlist playlist : allPlaylist) {
            if (playlist.getPlaylistId() != playlistId) {
                filteredPlaylist.add(playlist);
            }
        }
        allPlaylist = filteredPlaylist;
    }

    public List<String> convertToLowercase(List<String> list) {
        List<String> lowercaseList = new ArrayList<>();
        for (String tag : list) {
            lowercaseList.add(tag.toLowerCase());
        }
        return lowercaseList;
    }

}
