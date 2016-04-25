package com.spacelab.dessco.spacelab.Modelos;

import com.google.gson.annotations.Expose;

public class Practica {
	@Expose
	private int calificacion = 0;
    @Expose
	private String inicio ;
    @Expose
    private String fin;
    @Expose
    private String nombre;
    @Expose
    private String id;
    @Expose
    private int id_gpo;

	public String getInicio() {
		return inicio;
	}

    public void setInicio(String inicio) {
		this.inicio = inicio;
	}

    public String getFin() {
		return fin;
	}

    public void setFin(String fin) {
		this.fin = fin;
	}

	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getId_gpo() {
		return id_gpo;
	}
	public void setId_gpo(int id_gpo) {
		this.id_gpo = id_gpo;
	}

    @Override
    public String toString() {
        return "Practica{" +
                "calificacion=" + calificacion +
                ", inicio='" + inicio + '\'' +
                ", nombre='" + nombre + '\'' +
                ", id=" + id +
                ", id_gpo=" + id_gpo +
                ", fin='" + fin + '\'' +
                '}';
    }
}
