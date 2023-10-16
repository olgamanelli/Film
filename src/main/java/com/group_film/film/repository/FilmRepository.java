package com.group_film.film.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.group_film.film.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>{
	
}
