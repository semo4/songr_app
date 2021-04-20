package com.example.songr;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Query(value = "SELECT * From album WHERE id =?1", nativeQuery = true)
    Album findAlbumById(int id);

    @Query(value = "SELECT * From album WHERE title =?1", nativeQuery = true)
    Album findAlbumByTitle(String title);
}
