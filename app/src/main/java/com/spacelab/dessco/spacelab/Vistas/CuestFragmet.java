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

import com.google.gson.Gson;
import com.spacelab.dessco.spacelab.Adapters.AdaptadorCuest;
import com.spacelab.dessco.spacelab.Modelos.Cuestionario;
import com.spacelab.dessco.spacelab.R;
import com.spacelab.dessco.spacelab.Servicio.ServiceInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LuisAntonio on 29/04/2016.
 */
public class CuestFragmet extends Fragment {
    private ListView  listC;
    private View v;
    private AlertDialog.Builder alert;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_cuestionarios, container , false);
        listC = (ListView) v.findViewById(R.id.listViewCuestionarios);
        alert = new AlertDialog.Builder(inflater.getContext());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServiceInterface.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceInterface serviceInterface = retrofit.create(ServiceInterface.class);

        Call<List<Cuestionario>> call = serviceInterface.getAllCuest();
        call.enqueue(new Callback<List<Cuestionario>>() {
            @Override
            public void onResponse(Call<List<Cuestionario>> call, Response<List<Cuestionario>> response) {
                if(response.isSuccessful()){
                    List<Cuestionario> cuestResponse = response.body();
                    AdaptadorCuest cuestAdapter = new AdaptadorCuest(inflater.getContext(),cuestResponse);
                    listC.setAdapter(cuestAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<Cuestionario>> call, Throwable t) {
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
        });

        return v;
    }
}
