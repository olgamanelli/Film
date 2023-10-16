package com.group_film.film.dto;

import java.util.List;

import com.group_film.film.entity.Actor;

public class ActorDTO {


   	private Integer idAttore;
    
	private String nome;
	
	private Integer annoNascita;
	
	private String nazionalita;
	
	
	
	public ActorDTO() {
		
	}
	
	public ActorDTO(Integer id, String nome, Integer annoNascita, String nazionalita) {
		this.idAttore = id;
		this.nome = nome;
		this.annoNascita = annoNascita;
		this.nazionalita = nazionalita;
	}


	public Integer getId() {
		return idAttore;
	}


	public void setId(Integer id) {
		this.idAttore = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getAnnoNascita() {
		return annoNascita;
	}


	public void setAnnoNascita(Integer annoNascita) {
		this.annoNascita = annoNascita;
	}


	public String getNazionalita() {
		return nazionalita;
	}


	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	private List<FilmDTO> film;
	
	public List<FilmDTO> getListaFilm(){
		return this.film;
	}
	
	public void setListaFilm(List<FilmDTO> listaFilmDTO) {
		this.film = listaFilmDTO;
	}
	
	public static ActorDTO convertEntityToDTO(Actor actorEntity) {
		ActorDTO actorDTO = new ActorDTO();
		actorDTO.setAnnoNascita(actorEntity.getAnnoNascita());
		actorDTO.setId(actorEntity.getId());
		actorDTO.setNazionalita(actorEntity.getNazionalita());
		actorDTO.setNome(actorEntity.getNome());
		
		return actorDTO;
	}
	
	public static Actor convertActorDTOToEntity(ActorDTO actorDTO) {
		Actor actorEntity = new Actor();
		actorEntity.setAnnoNascita(actorDTO.getAnnoNascita());
		actorEntity.setId(actorDTO.getId());
		actorEntity.setNazionalita(actorDTO.getNazionalita());
		actorEntity.setNome(actorDTO.getNome());

		return actorEntity;
	}
	
	
}
