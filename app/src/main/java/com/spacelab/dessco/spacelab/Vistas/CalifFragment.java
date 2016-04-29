package com.spacelab.dessco.spacelab.Vistas;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.spacelab.dessco.spacelab.Adapters.AdaptadorCalif;
import com.spacelab.dessco.spacelab.Modelos.Alumno;
import com.spacelab.dessco.spacelab.Modelos.ContenedorGrupo;
import com.spacelab.dessco.spacelab.Modelos.Practica;
import com.spacelab.dessco.spacelab.R;
import com.spacelab.dessco.spacelab.Servicio.ServiceInterface;

import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LuisAntonio on 23/04/2016.
 */
public class CalifFragment extends Fragment {
    private ListView califAlumno;
    private Alumno alumno;
    private View v;
    private AlertDialog.Builder alert;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_calificaciones, container, false);
        alumno = getArguments().getParcelable("AlumnoKey");
        califAlumno = (ListView) v.findViewById(R.id.listaCalificaciones);
        alert = new AlertDialog.Builder(inflater.getContext());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceInterface.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceInterface serviceInterface = retrofit.create(ServiceInterface.class);

        String id_est = Integer.toString(alumno.getId_est());

        Call<List<ContenedorGrupo>> call = serviceInterface.getCalif(id_est);
        call.enqueue(new Callback<List<ContenedorGrupo>>() {
            @Override
            public void onResponse(Call<List<ContenedorGrupo>> call, Response<List<ContenedorGrupo>> response) {
                if (response.isSuccessful()) {
                    List<ContenedorGrupo> califListResponse = response.body();
                    AdaptadorCalif adaptadorCalif = new AdaptadorCalif(inflater.getContext(),califListResponse);
                    califAlumno.setAdapter(adaptadorCalif);
                } else {
                    Toast.makeText(inflater.getContext(), "Ocurrio un error , revisa que estes conectadoa internet", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<ContenedorGrupo>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return v;
    }
}
