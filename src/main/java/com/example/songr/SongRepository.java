package com.example.songr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Integer> {

    @Query(value = "SELECT * From song WHERE album_id =?1", nativeQuery = true)
    List<Song> findSongByAlbumId(int id);
}
