package com.spacelab.dessco.spacelab.Modelos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Cuestionario {
	@Expose
	private String titulo;
	@Expose
	private String id;
	@Expose
	private String autor;
	@Expose
	private List<Pregunta> preguntas;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

}
