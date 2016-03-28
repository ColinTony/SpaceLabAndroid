package com.spacelab.dessco.spacelab.Modelos;

import com.google.gson.annotations.Expose;

/**
 * Created by LuisAntonio on 24/03/2016.
 */
public class Alumno {
    //Tener todos los parametros que envia el Servicio REST
    @Expose
    private String nombre;
    @Expose
    private String apPat;
    @Expose
    private String apMat;
    @Expose
    private String email;
    @Expose
    private String grupo;
    @Expose
    private int boleta;
    @Expose
    private String pass;

    @Expose
    private String estado;

    @Expose
    private int id_est;
    @Expose
    private int id_Usr;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getBoleta() {
        return boleta;
    }

    public void setBoleta(int boleta) {
        this.boleta = boleta;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_est() {
        return id_est;
    }

    public void setId_est(int id_est) {
        this.id_est = id_est;
    }

    public int getId_Usr() {
        return id_Usr;
    }

    public void setId_Usr(int id_Usr) {
        this.id_Usr = id_Usr;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apPat='" + apPat + '\'' +
                ", apMat='" + apMat + '\'' +
                ", email='" + email + '\'' +
                ", grupo='" + grupo + '\'' +
                ", boleta=" + boleta +
                ", pass='" + pass + '\'' +
                ", estado='" + estado + '\'' +
                ", id_est=" + id_est +
                ", id_Usr=" + id_Usr +
                '}';
    }
}
