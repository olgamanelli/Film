package com.group_film.film.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.group_film.film.entity.Film;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FilmDTO {

	private Integer codiceFilm;
	
	private String titolo;

	private Integer annoProduzione;

	private List<ActorDTO> attori;
	
	private RegistaDTO regista;
	
	
	//costruttori
	public FilmDTO() {
		
	}

	
	public static FilmDTO convertEntityToDTO(Film filmEntity) {
		FilmDTO filmDTO = new FilmDTO();
		filmDTO.setCodiceFilm(filmEntity.getCodiceFilm());
		filmDTO.setAnnoProduzione(filmEntity.getAnnoProduzione());
		filmDTO.setTitolo(filmEntity.getTitolo());
		filmDTO.setAttori(
				filmEntity.getListaActor().stream().map( actorEntity -> {
					return ActorDTO.convertEntityToDTO(actorEntity);
				}).collect(Collectors.toList()));
		filmDTO.setRegista( RegistaDTO.convertEntityToDTO( filmEntity.getRegista()));
		return filmDTO;
	}
	
	public static Film convertDTOToEntity(FilmDTO filmDTO) {
		Film filmEntity = new Film();
		filmEntity.setCodiceFilm(filmDTO.getCodiceFilm());
		filmEntity.setAnnoProduzione(filmDTO.getAnnoProduzione());
		filmEntity.setTitolo(filmDTO.getTitolo());
		filmEntity.setListaActor(
				filmDTO.getAttori().stream().map( actorDTO -> {
					return ActorDTO.convertActorDTOToEntity(actorDTO);
				}).collect(Collectors.toList())
				);
	
		filmEntity.setRegista(RegistaDTO.convertRegistaDTOToEntity(filmDTO.getRegista()));
		return filmEntity;
	}
	
	
}
