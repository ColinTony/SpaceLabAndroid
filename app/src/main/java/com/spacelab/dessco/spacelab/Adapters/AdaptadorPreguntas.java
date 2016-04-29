package com.spacelab.dessco.spacelab.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.spacelab.dessco.spacelab.Modelos.ContenedorGrupo;
import com.spacelab.dessco.spacelab.Modelos.Cuestionario;
import com.spacelab.dessco.spacelab.R;

import java.util.List;

/**
 * Created by LuisAntonio on 29/04/2016.
 */
public class AdaptadorPreguntas extends ArrayAdapter<Cuestionario>{
    List<Cuestionario> listPreguntas;
    private TextView pregunta;
    public AdaptadorPreguntas(Context context, List<Cuestionario> content) {
        super(context, R.layout.list_item_preguntas ,content);
        listPreguntas = content;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View v = inflater.inflate(R.layout.list_item_preguntas , null);
        pregunta =(TextView) v.findViewById(R.id.pregunta);
        pregunta.setText(listPreguntas.get(position).getTitulo());
        return v;
    }
}
