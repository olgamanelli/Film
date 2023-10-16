package com.group_film.film.entity;

import java.util.List;
import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.group_film.film.dto.FilmDTO;

@Entity
@Table(name = "film")
public class Film {

	@Id
	@Column(name="id_film")
	private Integer codiceFilm;
	
	@Column(name = "titolo")
	private String titolo;
	@Column(name = "anno_produzione")
	private Integer annoProduzione;
//	@Column(name = "id_regista")
//	private Integer idRegista;
	
	//costruttori
	public Film() {
		
	}

//	public Film(Integer codiceFilm, String titolo, Integer annoProduzione, Integer idRegista) {
//		this.codiceFilm = codiceFilm;
//		this.titolo = titolo;
//		this.annoProduzione = annoProduzione;
////		this.idRegista = idRegista;
//	}



	public Integer getCodiceFilm() {
		return codiceFilm;
	}

	public void setCodiceFilm(Integer codiceFilm) {
		this.codiceFilm = codiceFilm;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnnoProduzione() {
		return annoProduzione;
	}

	public void setAnnoProduzione(Integer annoProduzione) {
		this.annoProduzione = annoProduzione;
	}

//	public Integer getIdRegista() {
//		return idRegista;
//	}
//
//	public void setIdRegista(Integer idRegista) {
//		this.idRegista = idRegista;
//	}

	@ManyToMany(mappedBy = "film")
	private List<Actor> attori;
	
	public List<Actor> getListaActor(){
		return this.attori;
	}
	
	public void setListaActor(List<Actor> listaattori) {
		this.attori = listaattori;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_regista", insertable = false, updatable = false )
	private Regista regista;
	
	public Regista getRegista() {
		return this.regista;
	}
	
	public void setRegista(Regista regista) {
		this.regista=regista;
	}
	
	
	
}
