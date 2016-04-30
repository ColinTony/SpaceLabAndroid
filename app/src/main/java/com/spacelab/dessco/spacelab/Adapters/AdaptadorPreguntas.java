package com.spacelab.dessco.spacelab.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.spacelab.dessco.spacelab.Modelos.ContenedorGrupo;
import com.spacelab.dessco.spacelab.Modelos.Cuestionario;
import com.spacelab.dessco.spacelab.Modelos.Pregunta;
import com.spacelab.dessco.spacelab.R;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by LuisAntonio on 29/04/2016.
 */
public class AdaptadorPreguntas extends ArrayAdapter<Pregunta>{
    List<Pregunta> listPreguntas;

    private TextView pregunta;

    public AdaptadorPreguntas(Context context, List<Pregunta> preguntasList) {
        super(context, R.layout.list_item_preguntas ,preguntasList);
        listPreguntas = preguntasList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View v = inflater.inflate(R.layout.list_item_preguntas , null);
        pregunta =(TextView) v.findViewById(R.id.pregunta);
        pregunta.setText(listPreguntas.get(position).getPregunta());
        return v;
    }
}
