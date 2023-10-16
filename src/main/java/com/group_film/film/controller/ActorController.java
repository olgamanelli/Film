package com.group_film.film.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group_film.film.dto.ActorDTO;
import com.group_film.film.dto.FilmDTO;
import com.group_film.film.service.ActorService;



@RestController
public class ActorController {


	@Autowired
	private ActorService actorService;
	
	
	@GetMapping("/actor")
	public List<ActorDTO> getAllActor(){
		return actorService.getAllActors();
	}
	
	@GetMapping("/actor/{id}")
	public ActorDTO getActor(@PathVariable Integer id) {
		return actorService.getActor(id);
	}
	
	@GetMapping("/actor/listafilm/{id}")
	public List<FilmDTO> getListaFilm(@PathVariable Integer id){
		return actorService.getListaFilm(id);
	}
	
	
	@PostMapping("/actor")
	public void addActor(@RequestBody ActorDTO actor) {
		actorService.addActor(actor);
	}
	
	@PutMapping("/actor/{id}")
	public void updateActor(@PathVariable Integer id, @RequestBody ActorDTO actor) {
		actorService.updateFilm(id, actor);
	}
	
	@DeleteMapping("/actor/{id}")
	public void deleteActor(@PathVariable Integer id) {
		actorService.deleteActor(id);
	}
	
	
}
