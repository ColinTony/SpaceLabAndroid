package com.spacelab.dessco.spacelab.Vistas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.spacelab.dessco.spacelab.Adapters.AdaptadorPreguntas;
import com.spacelab.dessco.spacelab.Modelos.Alumno;
import com.spacelab.dessco.spacelab.Modelos.Cuestionario;
import com.spacelab.dessco.spacelab.Modelos.Respuestas;
import com.spacelab.dessco.spacelab.R;
import com.spacelab.dessco.spacelab.Servicio.ServiceInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CuestionarioR extends AppCompatActivity {
    private Alumno alumno = new Alumno();
    private Respuestas resp;
    private ListView listaP;
    private Cuestionario cuestionario = new Cuestionario();
    private AlertDialog.Builder alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cuestionario_r);
        cuestionario = getIntent().getParcelableExtra("CuestKey");
        alumno = getIntent().getParcelableExtra("AlumnoKey");
        listaP = (ListView) findViewById(R.id.listViewPreguntas);
        alert = new AlertDialog.Builder(this);

        alert.create();
        alert.setTitle(cuestionario.getTitulo());
        alert.setMessage("Bienvenido al cuestionario " + cuestionario.getTitulo() + " Deberas elegir la opcion correcta en todas las preguntas \n " + "Suerte !!");
        alert.setCancelable(false);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();

            }
        });
        alert.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceInterface.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceInterface serviceInterface = retrofit.create(ServiceInterface.class);

        Call<Cuestionario> call = serviceInterface.getCues(cuestionario.getId());
        call.enqueue(new Callback<Cuestionario>() {
            @Override
            public void onResponse(Call<Cuestionario> call, Response<Cuestionario> response) {
                if(response.isSuccessful()){
                    cuestionario.setTitulo(response.body().getTitulo());
                    cuestionario.setAutor(response.body().getAutor());
                    cuestionario.setPreguntas(response.body().getPreguntas());
                    AdaptadorPreguntas adapterP = new AdaptadorPreguntas(CuestionarioR.this,cuestionario.getPreguntas());
                    listaP.setAdapter(adapterP);
                }else{
                    alert.create();
                    alert.setTitle("Error");
                    alert.setMessage("ocurrio un error");
                    alert.setCancelable(false);
                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.cancel();

                        }
                    });
                    alert.show();
                }
            }

            @Override
            public void onFailure(Call<Cuestionario> call, Throwable t) {
                alert.create();
                alert.setTitle("Error");
                alert.setMessage(t.getMessage().toString());
                alert.setCancelable(false);
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();

                    }
                });
                alert.show();
            }
        });

    }
}
