package com.spacelab.dessco.spacelab.Modelos;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by LuisAntonio on 24/03/2016.
 */
public class Alumno implements Parcelable {
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


    public Alumno() {
    }
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.apPat);
        dest.writeString(this.apMat);
        dest.writeString(this.email);
        dest.writeString(this.grupo);
        dest.writeInt(this.boleta);
        dest.writeString(this.pass);
        dest.writeString(this.estado);
        dest.writeInt(this.id_est);
        dest.writeInt(this.id_Usr);
    }


    public Alumno(Parcel in) {
        this.nombre = in.readString();
        this.apPat = in.readString();
        this.apMat = in.readString();
        this.email = in.readString();
        this.grupo = in.readString();
        this.boleta = in.readInt();
        this.pass = in.readString();
        this.estado = in.readString();
        this.id_est = in.readInt();
        this.id_Usr = in.readInt();
    }

    public static final Parcelable.Creator<Alumno> CREATOR = new Parcelable.Creator<Alumno>() {
        @Override
        public Alumno createFromParcel(Parcel source) {
            return new Alumno(source);
        }

        @Override
        public Alumno[] newArray(int size) {
            return new Alumno[size];
        }
    };
}
