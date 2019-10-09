package com.checkpoint4.wildcircus.repositories;

import com.checkpoint4.wildcircus.entities.Artist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long>{

}