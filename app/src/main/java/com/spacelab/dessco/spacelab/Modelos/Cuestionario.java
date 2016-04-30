package com.spacelab.dessco.spacelab.Modelos;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Cuestionario implements Parcelable {
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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.titulo);
		dest.writeString(this.id);
		dest.writeString(this.autor);
		dest.writeList(this.preguntas);
	}

	public Cuestionario() {
	}

	protected Cuestionario(Parcel in) {
		this.titulo = in.readString();
		this.id = in.readString();
		this.autor = in.readString();
		this.preguntas = new ArrayList<Pregunta>();
		in.readList(this.preguntas, Pregunta.class.getClassLoader());
	}

	public static final Creator<Cuestionario> CREATOR = new Creator<Cuestionario>() {
		@Override
		public Cuestionario createFromParcel(Parcel source) {
			return new Cuestionario(source);
		}

		@Override
		public Cuestionario[] newArray(int size) {
			return new Cuestionario[size];
		}
	};
}
