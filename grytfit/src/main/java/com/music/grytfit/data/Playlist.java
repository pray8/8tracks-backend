package com.music.grytfit.data;

import java.util.List;

public class Playlist implements Comparable<Playlist> {

    private int playlistId;
    private String playlistName;
    private String authorName;
    private int numberOfTracks;
    private int playCount;
    private int likeCount;
    private List<String> tags;

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(int numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Playlist() {
    }

    public Playlist(int playlistId, String playlistName, String authorName, int numberOfTracks, int playCount,
            int likeCount, List<String> tags) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.authorName = authorName;
        this.numberOfTracks = numberOfTracks;
        this.playCount = playCount;
        this.likeCount = likeCount;
        this.tags = tags;
    }

    @Override
    public int compareTo(Playlist o) {

        if (this.playCount == o.playCount) {
            return this.likeCount < o.likeCount ? 1 : -1;
        }
        return this.playCount < o.playCount ? 1 : -1;
    }
}
