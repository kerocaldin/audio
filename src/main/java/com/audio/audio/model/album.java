package com.audio.audio.model;

public abstract class album {
    private Long AlbumId;
    private String Title;
    private Long ArtistId;

    public album(Long albumId, String title, Long artistId) {
        AlbumId = albumId;
        Title = title;
        ArtistId = artistId;
    }

    public Long getAlbumId() {
        return AlbumId;
    }

    public void setAlbumId(Long albumId) {
        AlbumId = albumId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Long getArtistId() {
        return ArtistId;
    }

    public void setArtistId(Long artistId) {
        ArtistId = artistId;
    }
}
