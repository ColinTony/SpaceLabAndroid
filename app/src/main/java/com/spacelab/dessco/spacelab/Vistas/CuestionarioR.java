package com.spacelab.dessco.spacelab.Vistas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.spacelab.dessco.spacelab.Adapters.AdaptadorPreguntas;
import com.spacelab.dessco.spacelab.Modelos.Alumno;
import com.spacelab.dessco.spacelab.Modelos.Cuestionario;
import com.spacelab.dessco.spacelab.Modelos.Respuestas;
import com.spacelab.dessco.spacelab.R;
import com.spacelab.dessco.spacelab.Servicio.ServiceInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CuestionarioR extends AppCompatActivity {
    private Alumno alumno = new Alumno();
    private Respuestas resp;
    private ListView listaP;
    private AlertDialog.Builder alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alumno = getIntent().getParcelableExtra("AlumnoKey");
        Bundle bundle = getIntent().getExtras();
        setContentView(R.layout.activity_cuestionario_r);
        listaP = (ListView) findViewById(R.id.listViewPreguntas);
        alert = new AlertDialog.Builder(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceInterface.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServiceInterface serviceInterface = retrofit.create(ServiceInterface.class);
        Call<List<Cuestionario>> call = serviceInterface.getCuest(bundle.getString("idKey"));
        call.enqueue(new Callback<List<Cuestionario>>() {
            @Override
            public void onResponse(Call<List<Cuestionario>> call, Response<List<Cuestionario>> response) {
                if(response.isSuccessful()){
                    List<Cuestionario> preguntasResponse = response.body();
                    AdaptadorPreguntas adapter = new AdaptadorPreguntas(CuestionarioR.this,preguntasResponse);
                    listaP.setAdapter(adapter);
                }else{
                    alert.create();
                    alert.setTitle("Oups");
                    alert.setMessage("Ocurrio un error");
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
            public void onFailure(Call<List<Cuestionario>> call, Throwable t) {

            }
        });

    }
}
