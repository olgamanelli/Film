package com.group_film.film.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group_film.film.dto.ActorDTO;
import com.group_film.film.dto.FilmDTO;
import com.group_film.film.entity.Actor;
import com.group_film.film.entity.Film;
import com.group_film.film.service.FilmService;

@RestController
public class FilmController {

	@Autowired
	private FilmService filmService;
	
	
	@GetMapping("/film")
	public List<FilmDTO> getAllFilms(){
		return filmService.getAllFilms();
	}
	
	@GetMapping("/film/{id}")
	public FilmDTO getFilm(@PathVariable Integer id) {
		return filmService.getFilm(id);
	}
	
	@GetMapping("/film/listaactor/{id}")
	public List<ActorDTO> getListaActor(@PathVariable Integer id) throws Exception{
		return filmService.getListaActor(id);
	}

	@PostMapping("/film")
	public void addFilm(@RequestBody FilmDTO film) {
		filmService.addFilm(film);
	}
	
	@PutMapping("/film/{id}")
	public void updateFilm(@PathVariable Integer id, @RequestBody FilmDTO film) {
		filmService.updateFilm(id, film);
	}
	
	@PutMapping("/filmprova/{id}/{titolo}/{anno}")
	public void updateTitoloAnno(@PathVariable Integer id, @PathVariable String titolo, @PathVariable Integer anno) throws Exception {
		filmService.updateTitoloAnno(id, titolo, anno);
	}
	
	@DeleteMapping("/film/{id}")
	public void deleteFilm(@PathVariable Integer id) {
		filmService.deleteFilm(id);
	}
	
	

}
