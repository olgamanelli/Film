package com.group_film.film.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.group_film.film.dto.ActorDTO;

import javax.persistence.*;


@Entity
@Table(name = "attori")
public class Actor {

	
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attore")
   	private Integer idAttore;
    
    
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "anno_nascita")
	private Integer annoNascita;
	
	@Column(name = "nazionalita")
	private String nazionalita;
	
	
	
	public Actor() {
		
	}
	
	public Actor(Integer id, String nome, Integer annoNascita, String nazionalita) {
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

	@ManyToMany(fetch = FetchType.LAZY ,cascade = { CascadeType.ALL })
	@JoinTable(name="film_attori",
		joinColumns= {@JoinColumn(name="id_attori")},
		inverseJoinColumns= {@JoinColumn(name = "id_film")})
	private List<Film> film;
	
	public List<Film> getListaFilm(){
		return this.film;
	}
	
	
	
}
