package com.group_film.film.dto;

import java.util.List;

import com.group_film.film.entity.Actor;
import com.group_film.film.entity.Regista;


public class RegistaDTO {


	private Integer idRegista;

	private String nome;

	private Integer annoNascita;
	
	private String nazionalita;

	public RegistaDTO() {

	}

	public RegistaDTO(Integer idRegista, String nome, int annoNascita, String nazionalita) {
		this.idRegista = idRegista;
		this.nome = nome;
		this.annoNascita = annoNascita;
		this.nazionalita = nazionalita;
	}

	public Integer getIdRegista() {
		return idRegista;
	}

	public void setIdRegista(Integer idRegista) {
		this.idRegista = idRegista;
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

	private List<FilmDTO> listaFilm;

	public List<FilmDTO> getListaFilm(){
		return this.listaFilm;
	}
	
	public static RegistaDTO convertEntityToDTO(Regista registaEntity) {
		RegistaDTO registaDTO = new RegistaDTO();
		registaDTO.setAnnoNascita(registaEntity.getAnnoNascita());
		registaDTO.setIdRegista(registaEntity.getIdRegista());
		registaDTO.setNazionalita(registaEntity.getNazionalita());
		registaDTO.setNome(registaEntity.getNome());
		return registaDTO;
	}
	
	public static Regista convertRegistaDTOToEntity(RegistaDTO registaDTO) {
		Regista registaEntity = new Regista();
		registaEntity.setAnnoNascita(registaDTO.getAnnoNascita());
		registaEntity.setIdRegista(registaDTO.getIdRegista());
		registaEntity.setNazionalita(registaDTO.getNazionalita());
		registaEntity.setNome(registaDTO.getNome());
		return registaEntity;
	}

}
