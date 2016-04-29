package com.spacelab.dessco.spacelab.Modelos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Respuestas {
	@Expose
	private String id;
	@Expose
	private List<Integer> respuestas;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Integer> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(List<Integer> respuestas) {
		this.respuestas = respuestas;
	}

}
