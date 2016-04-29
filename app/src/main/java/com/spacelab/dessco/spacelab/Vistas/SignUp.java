package com.spacelab.dessco.spacelab.Vistas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.spacelab.dessco.spacelab.Modelos.Alumno;
import com.spacelab.dessco.spacelab.R;
import com.spacelab.dessco.spacelab.Servicio.ServiceInterface;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUp extends AppCompatActivity {

    private EditText apeP,apeM,nombres,pw;
    private EditText email,boleta,grupo;
    private TextView respError;
    private AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        apeP = (EditText) findViewById(R.id.apPat);
        apeM = (EditText) findViewById(R.id.apMat);
        nombres = (EditText) findViewById(R.id.nombre);
        pw = (EditText) findViewById(R.id.pass);
        email = (EditText) findViewById(R.id.emailSignUp);

        boleta = (EditText) findViewById(R.id.boleta);
        grupo = (EditText) findViewById(R.id.grupo);

        respError = (TextView) findViewById(R.id.registroTitle);
        alert = new AlertDialog.Builder(this);
    }
    public void registrarAlumno(View v){//Modificar con retrofit
            //Retrofit
        int boletaa =Integer.parseInt(boleta.getText().toString().trim());
        String password = (pw.getText().toString()).toUpperCase();
            Alumno alumno = new Alumno();
            alumno.setNombre(nombres.getText().toString());
            alumno.setApPat(apeP.getText().toString());
            alumno.setApMat(apeM.getText().toString());
            alumno.setEmail(email.getText().toString());
            alumno.setGrupo(grupo.getText().toString().trim());
            alumno.setBoleta(boletaa);
            alumno.setPass(password);
            alumno.setEstado("en proceso");

            //Aqui viene Retrofit con su magia de sirena y su cola de una sola aleta
           Retrofit retrofit = new Retrofit.Builder()
                   .baseUrl(ServiceInterface.baseUrl)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();

        ServiceInterface service = retrofit.create(ServiceInterface.class);
        //Llamada

        Call <Alumno> call = service.registAlum(alumno.getNombre(),alumno.getApPat(),alumno.getApMat(),
                alumno.getEmail(),alumno.getGrupo(),alumno.getBoleta(),alumno.getPass());

        //ejecutamos llamada
        call.enqueue(new Callback<Alumno>() {
            @Override
            public void onResponse(Call<Alumno> call, Response<Alumno> response) {
                if(response.isSuccessful()){
                    String respuesta = response.body().getEstado().toString();
                    if(respuesta.equals("Registro realizado correctamante")){
                        alert.create();
                        alert.setTitle("Bienvenido");
                        alert.setMessage(respuesta + "\n Gracias por registrarte , se ha enviado un correo para la activacion de tu cuenta \n porfavor activala");
                        alert.setCancelable(false);
                        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                aceptar();
                            }
                        });
                        alert.show();
                    }else{
                        alert.create();
                        alert.setTitle("Error");
                        alert.setMessage(respuesta);
                        alert.setCancelable(false);
                        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                error();
                            }
                        });
                        alert.show();
                    }

                }else{
                    alert.create();
                    alert.setTitle("Error");
                    alert.setMessage("Algo salio mal :(");
                    alert.setCancelable(false);
                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            error();
                        }
                    });
                    alert.show();
                }
            }

            @Override
            public void onFailure(Call<Alumno> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void aceptar (){
        Intent i = new Intent(this,Main.class);
        finish();
        startActivity(i);
        overridePendingTransition(R.transition.fade_entrada, R.transition.zoom_back_out);
    }
    public void error (){
        finish();
        startActivity(getIntent());
        overridePendingTransition(R.transition.fade_entrada, R.transition.zoom_back_out);
    }
}

