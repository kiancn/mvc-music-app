package kcn.mvcmusicplayer.repository;

import kcn.mvcmusicplayer.model.Genre;
import kcn.mvcmusicplayer.model.Track;

import java.util.List;

public interface ITrackRepository
{
    List<Track> findTracksByName(String name);
    List<Track> findTracksByGenre(Genre genre);
    List<Track> findTracksByBandNameContaining(String bandName);

    void saveTrack(Track track);

    List<Track> currentTrackList();
}
