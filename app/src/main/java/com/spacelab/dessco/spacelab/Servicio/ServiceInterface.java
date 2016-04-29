package com.spacelab.dessco.spacelab.Servicio;

import com.spacelab.dessco.spacelab.Modelos.Alumno;
import com.spacelab.dessco.spacelab.Modelos.ContenedorGrupo;
import com.spacelab.dessco.spacelab.Modelos.Cuestionario;
import com.spacelab.dessco.spacelab.Modelos.Practica;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by LuisAntonio on 24/03/2016.
 */
public interface ServiceInterface {

    String  baseUrl="http://spacelab-dessco2.rhcloud.com";
    //La interfaz para Retrofit
    @FormUrlEncoded
    @POST("/api/registro")
    Call<Alumno> registAlum(@Field("nombre") String nombre, @Field("apPat") String apPat , @Field("apMat") String apMat ,
                               @Field("email") String email,@Field("grupo") String grupo,@Field("boleta") int boleta,
                               @Field("pass") String pass);
    @FormUrlEncoded
    @POST("/api/login")
    Call<Alumno> login(@Field("email") String email , @Field("pass") String pass);

    @GET("/alumnos/calificaciones/{id_est}")
    Call<List<ContenedorGrupo>> getCalif(@Path("id_est") String id);

    @GET("/practicas/disponibles")
    Call<List<Practica>> getPracticas();

    @GET("/api/cuestionarios")
    Call<List<Cuestionario>> getAllCuest();

    @GET("/api/cuestionarios/{idCuestionario}")
    Call<List<Cuestionario>> getCuest(@Path("idCuestionario") String idCuest);

}
