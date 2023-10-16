package com.group_film.film.entity;

import java.util.List;

import javax.persistence.*;

import com.group_film.film.dto.RegistaDTO;

@Entity
@Table(name = "registi")
public class Regista {

	@Id
	//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_regista")
	private Integer idRegista;

	@Column(name = "nome")
	private String nome;

	@Column(name = "anno_nascita")
	private Integer annoNascita;

	@Column(name = "nazionalita")
	private String nazionalita;

	public Regista() {

	}

	public Regista(Integer idRegista, String nome, int annoNascita, String nazionalita) {
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

	@OneToMany(mappedBy="regista")
	private List<Film> listaFilm;

	public List<Film> getListaFilm(){
		return this.listaFilm;
	}
	
	


}
