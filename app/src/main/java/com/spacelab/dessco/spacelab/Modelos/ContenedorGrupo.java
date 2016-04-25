package com.spacelab.dessco.spacelab.Modelos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ContenedorGrupo {
	@Expose
	private String nombre;
	@Expose
	private String grupo;
	@Expose
	private String boleta;
	@Expose
	private int id_est;
	@Expose
	private List<Practica> practicas;
	@Expose
	private List<Integer> cuestionarios;

	public int getId_est() {
		return id_est;
	}

	public void setId_est(int id_est) {
		this.id_est = id_est;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getBoleta() {
		return boleta;
	}

	public void setBoleta(String boleta) {
		this.boleta = boleta;
	}

	public List<Practica> getPracticas() {
		return practicas;
	}

	public void setPracticas(List<Practica> practicas) {
		this.practicas = practicas;
	}

	public List<Integer> getCuestionarios() {
		return cuestionarios;
	}

	public void setCuestionarios(List<Integer> cuestionarios) {
		this.cuestionarios = cuestionarios;
	}

	@Override
	public String toString() {
		return "ContenedorGrupo{" +
				"nombre='" + nombre + '\'' +
				", grupo='" + grupo + '\'' +
				", boleta='" + boleta + '\'' +
				", id_est=" + id_est +
				", practicas=" + practicas +
				", cuestionarios=" + cuestionarios +
				'}';
	}
}
