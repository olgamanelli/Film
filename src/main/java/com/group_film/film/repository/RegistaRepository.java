package com.group_film.film.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group_film.film.entity.Regista;

@Repository
public interface RegistaRepository extends JpaRepository<Regista, Integer> {

}
