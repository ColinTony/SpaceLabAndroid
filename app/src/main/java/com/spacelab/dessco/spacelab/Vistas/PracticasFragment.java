package com.spacelab.dessco.spacelab.Vistas;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.spacelab.dessco.spacelab.Adapters.AdaptadorPracticas;
import com.spacelab.dessco.spacelab.Modelos.Practica;
import com.spacelab.dessco.spacelab.R;
import com.spacelab.dessco.spacelab.Servicio.ServiceInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LuisAntonio on 24/04/2016.
 */
public class PracticasFragment extends Fragment {
    private ListView practicas;
    private String baseUrl ="http://spacelab-dessco.rhcloud.com";
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_practicas,container,false);
        practicas = (ListView) view.findViewById(R.id.listViewPracticas);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceInterface serviceInterface = retrofit.create(ServiceInterface.class);
        Call<List<Practica>> call = serviceInterface.getPracticas();
        call.enqueue(new Callback<List<Practica>>() {
            @Override
            public void onResponse(Call<List<Practica>> call, Response<List<Practica>> response) {
                List<Practica> practicaListResponse = response.body();
                AdaptadorPracticas adapter = new AdaptadorPracticas(inflater.getContext(), practicaListResponse);
                practicas.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Practica>> call, Throwable t) {
                Toast.makeText(inflater.getContext(), "Ocurrio un error , revisa que estes conectadoa internet", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
