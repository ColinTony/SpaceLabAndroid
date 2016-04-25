package com.spacelab.dessco.spacelab.Vistas;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.gsm.GsmCellLocation;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.spacelab.dessco.spacelab.Modelos.Alumno;
import com.spacelab.dessco.spacelab.R;
import com.spacelab.dessco.spacelab.Servicio.ServiceInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignIn extends AppCompatActivity {
    private EditText email;
    private boolean failure = false;
    private String baseUrl="http://spacelab-dessco.rhcloud.com";
    private String error=null;
    private EditText pass;
    private AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        email = (EditText) findViewById(R.id.emailInicio);
        pass = (EditText) findViewById(R.id.passInicio);
        alert = new AlertDialog.Builder(this);

    }

    public void entrar(View v) {// Validar con Retrofit y el servicio montado

        final Alumno alumno = new Alumno();
        alumno.setEmail(email.getText().toString());
        alumno.setPass(pass.getText().toString());
        final ProgressDialog progreso = ProgressDialog.show(SignIn.this, "Iniciando sesion", "Por favor espere...", true);
        progreso.setCancelable(false);
        if(!isNetworkAvaliable(this)){
            alert.create();
            alert.setTitle("Error");
            alert.setMessage("Ocurrio un error, \n revise si esta conectado a internet");
            alert.setCancelable(false);
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    aceptar();
                }
            });
            alert.show();
        }else{
            new Thread (new Runnable() {
                @Override
                public void run() {
                    try {
                        //RetroFit
                        Retrofit retro = new Retrofit.Builder()
                                .baseUrl(baseUrl)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        ServiceInterface service = retro.create(ServiceInterface.class);
                        Call<Alumno> call = service.login(alumno.getEmail(), alumno.getPass());

                        call.enqueue(new Callback<Alumno>() {

                            @Override
                            public void onResponse(Call<Alumno> call, Response<Alumno> response) {
                                if (response.isSuccessful()) {
                                    if (response.body().getId_est() == 0) {
                                        alert.create();
                                        alert.setTitle("Bienvenido");
                                        alert.setMessage("Error al iniciar sesion revisa que el usuario y contraseña esten correctos, \n si aun no has activiado tu cuenta hazlo");
                                        alert.setCancelable(false);
                                        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                                aceptar();
                                            }
                                        });
                                        alert.show();

                                    } else {
                                        Alumno alumnoSignIn = new Alumno();
                                        alumnoSignIn.setNombre(response.body().getNombre().toString());
                                        alumnoSignIn.setApPat(response.body().getApPat().toString());
                                        alumnoSignIn.setApMat(response.body().getApMat().toString());
                                        alumnoSignIn.setEmail(response.body().getEmail().toString());
                                        alumnoSignIn.setBoleta(response.body().getBoleta());
                                        alumnoSignIn.setId_est(response.body().getId_est());
                                        alumnoSignIn.setId_Usr(response.body().getId_Usr());
                                        bienvenido(alumnoSignIn);
                                    }


                                } else {
                                    alert.create();
                                    alert.setTitle("Bienvenido");
                                    alert.setMessage("Ocurrio un error intentalo mas tarde , revisa que estes conectado a internet");
                                    alert.setCancelable(false);
                                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            aceptar();
                                        }
                                    });
                                    alert.show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Alumno> call, Throwable t) {
                                Thread.currentThread().interrupt();
                                error = "ocurrio un error , intentalo mas tarde , revisa que estes conectado a internet";
                                failure = true;
                            }

                        });
                        Thread.sleep(6000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    progreso.dismiss();
                }
            }).start();
        }

    }

    public void bienvenido (Alumno alumnoSigIn){
        Intent i = new Intent(this,InicioAlumno.class);
        i.putExtra("AlumnoKey", alumnoSigIn);
        startActivity(i);
        overridePendingTransition(R.transition.fade_entrada, R.transition.zoom_back_out);
    }
    public void aceptar(){
        finish();
        startActivity(getIntent());
        overridePendingTransition(R.transition.fade_entrada, R.transition.zoom_back_out);
    }
    public static boolean isNetworkAvaliable(Context ctx) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED)
                || (connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState() == NetworkInfo.State.CONNECTED)) {
            return true;
        } else {
            return false;
        }
    }
}
