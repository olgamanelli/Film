package com.group_film.film.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;



import com.group_film.film.dto.ActorDTO;
import com.group_film.film.dto.FilmDTO;
import com.group_film.film.entity.Film;
import com.group_film.film.repository.FilmRepository;

@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;

	//prende tutti i film
	public List<FilmDTO> getAllFilms(){
		return filmRepository.findAll().stream().map(
				filmEntity -> {
					FilmDTO filmDTO = FilmDTO.convertEntityToDTO(filmEntity);
					return filmDTO;
				}).collect(Collectors.toList());
	}

	//trova un film con un tale identificatore
	public FilmDTO getFilm(Integer id) {
		FilmDTO filmDTO = FilmDTO.convertEntityToDTO(filmRepository.findById(id).get());
		return filmDTO;
	}

	//aggiunge un film
	public void addFilm(FilmDTO film) {
		Film filmEntity = FilmDTO.convertDTOToEntity(film);
		filmRepository.save(filmEntity);
	}

	//aggiorna il film con codice id
	public void updateFilm(Integer id, FilmDTO film) {
		Film filmEntity = FilmDTO.convertDTOToEntity(film);
		filmRepository.save(filmEntity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateTitolo(Integer id, String titolo) {
		Film filmEntity = filmRepository.findById(id).get();
		filmEntity.setTitolo(titolo);
		filmRepository.save(filmEntity);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updateAnno(Integer id, int anno) {
		Film filmEntity = filmRepository.findById(18).get();
		filmEntity.setAnnoProduzione(anno);
		filmRepository.save(filmEntity);
	}

	public void updateTitoloAnno(Integer id, String titolo, Integer anno) {
		updateTitolo(id, titolo);
		updateAnno(id, anno);
	}


	//cancella il film con codice id
	public void deleteFilm(Integer id) {
		filmRepository.deleteById(id);
	}

	//prende la lista degli attori di un film
	public List<ActorDTO> getListaActor(Integer id) throws Exception{
		FilmDTO filmDTO = FilmDTO.convertEntityToDTO(
				filmRepository.findById(id).orElseThrow(
						() -> new Exception("Not found film by id : " + id))
				);
		return filmDTO.getAttori();
	}


}
