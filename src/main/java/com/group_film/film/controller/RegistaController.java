package com.group_film.film.controller;

import java.util.List;
import com.group_film.film.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group_film.film.dto.FilmDTO;
import com.group_film.film.dto.RegistaDTO;
import com.group_film.film.entity.Film;
import com.group_film.film.entity.Regista;
import com.group_film.film.service.RegistaService;


@RestController
public class RegistaController {

	
	@Autowired
	private RegistaService registaService;
	
	
	@GetMapping("/regista")
	public List<RegistaDTO> getAllRegisti(){
		return registaService.getAllRegisti();
	}
	
	@GetMapping("/regista/{id}")
	public RegistaDTO getRegista(@PathVariable Integer id) {
		return registaService.getRegista(id);
	}
	
	@GetMapping("/regista/listafilm/{id}")
	public List<FilmDTO> getListaFilm(@PathVariable Integer id){
		return registaService.getListaFilm(id);
	}
	
	@PostMapping("/regista")
	public void addRegista(@RequestBody RegistaDTO regista) {
		registaService.addRegista(regista);
	}
	
	@PutMapping("/regista/{id}")
	public void updateRegista(@PathVariable Integer id, @RequestBody RegistaDTO regista) {
		registaService.updateFilm(id, regista);
	}
	
	@DeleteMapping("/regista/{id}")
	public void deleteRegista(@PathVariable Integer id) {
		registaService.deleteRegista(id);
	}
}
