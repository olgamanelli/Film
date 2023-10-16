package com.group_film.film.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_film.film.dto.ActorDTO;
import com.group_film.film.dto.FilmDTO;
import com.group_film.film.repository.ActorRepository;
import com.group_film.film.entity.Actor;

@Service
public class ActorService {


	@Autowired
	private ActorRepository actorRepository;

	//prende tutti i film
	public List<ActorDTO> getAllActors(){
		return actorRepository.findAll().stream().map(
				actorEntity -> {
					ActorDTO actorDTO = ActorDTO.convertEntityToDTO(actorEntity);
					return actorDTO;
				}).collect(Collectors.toList());
	}

	//trova un film con un tale identificatore
	public ActorDTO getActor(Integer id) {
		ActorDTO actorDTO = ActorDTO.convertEntityToDTO(actorRepository.findById(id).get());
		 return actorDTO;
	}

	//aggiunge un film
	public void addActor(ActorDTO actorDTO) {
		Actor actorEntity = ActorDTO.convertActorDTOToEntity(actorDTO);
		actorRepository.save(actorEntity);
	}

	//aggiorna il film con codice id
	public void updateFilm(Integer id, ActorDTO actorDTO) {
		Actor actorEntity = ActorDTO.convertActorDTOToEntity(actorDTO);
		actorRepository.save(actorEntity);
	}

	//cancella il film con codice id
	public void deleteActor(Integer id) {
		actorRepository.deleteById(id);
	}
	
	//prende la lista dei film di un attore
	public List<FilmDTO> getListaFilm(Integer id){
		ActorDTO actorDTO = ActorDTO.convertEntityToDTO(actorRepository.findById(id).get());
		return actorDTO.getListaFilm();
	}

}
