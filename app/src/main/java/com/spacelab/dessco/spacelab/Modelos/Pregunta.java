package com.spacelab.dessco.spacelab.Modelos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Pregunta {
	
	public Pregunta(){
		
	}
	@Expose
	private String pregunta;
	@Expose
	private int correcta;
	@Expose
	private List<String> respuestas;

	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public List<String> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(List<String> respuestas) {
		this.respuestas = respuestas;
	}
	public int getCorrecta() {
		return correcta;
	}
	public void setCorrecta(int correcta) {
		this.correcta = correcta;
	}


}
