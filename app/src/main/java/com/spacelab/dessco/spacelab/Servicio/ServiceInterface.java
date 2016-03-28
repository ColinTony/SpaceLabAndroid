package com.spacelab.dessco.spacelab.Servicio;

import com.spacelab.dessco.spacelab.Modelos.Alumno;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by LuisAntonio on 24/03/2016.
 */
public interface ServiceInterface {
    //La interfaz para Retrofit
    @FormUrlEncoded
    @POST("/api/registro")
    Call<Alumno> registAlum(@Field("nombre") String nombre, @Field("apPat") String apPat , @Field("apMat") String apMat ,
                               @Field("email") String email,@Field("grupo") String grupo,@Field("boleta") int boleta,
                               @Field("pass") String pass);
    @FormUrlEncoded
    @POST("/api/login")
    Call<Alumno> login(@Field("email") String email , @Field("pass") String pass);
}
