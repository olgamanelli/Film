package com.group_film.film.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_film.film.dto.ActorDTO;
import com.group_film.film.dto.FilmDTO;
import com.group_film.film.dto.RegistaDTO;
import com.group_film.film.entity.Actor;
import com.group_film.film.entity.Film;
import com.group_film.film.entity.Regista;
import com.group_film.film.repository.RegistaRepository;

@Service
public class RegistaService {

	@Autowired
	private RegistaRepository registaRepository;
	
	//prende tutti i film
		public List<RegistaDTO> getAllRegisti(){
			return registaRepository.findAll().stream().map(
					registaEntity -> {
						RegistaDTO registaDTO = RegistaDTO.convertEntityToDTO(registaEntity);
						return registaDTO;
					}).collect(Collectors.toList());
		}
		
		//trova un film con un tale identificatore
		public RegistaDTO getRegista(Integer id) {
			RegistaDTO registaDTO = RegistaDTO.convertEntityToDTO(registaRepository.findById(id).get());
			 return registaDTO;
		}
		
		//aggiunge un film
		public void addRegista(RegistaDTO registaDTO) {
			Regista registaEntity = RegistaDTO.convertRegistaDTOToEntity(registaDTO);
			registaRepository.save(registaEntity);
	    }
		
		//aggiorna il film con codice id
		 public void updateFilm(Integer id, RegistaDTO registaDTO) {
			 Regista registaEntity = RegistaDTO.convertRegistaDTOToEntity(registaDTO);
				registaRepository.save(registaEntity);
		    }

		 //cancella il film con codice id
		public void deleteRegista(Integer id) {
		       registaRepository.deleteById(id);
		}

		//prende la lista dei film di un regista
		public List<FilmDTO> getListaFilm(Integer id){
			RegistaDTO registaDTO = RegistaDTO.convertEntityToDTO( registaRepository.findById(id).get());    
			return registaDTO.getListaFilm();
		}
}
