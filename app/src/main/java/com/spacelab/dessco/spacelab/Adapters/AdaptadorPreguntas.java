package com.spacelab.dessco.spacelab.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
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
    private RadioButton op1,op2,op3;

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
        op1 = (RadioButton) v.findViewById(R.id.opcion1);
        op2 = (RadioButton) v.findViewById(R.id.opcion2);
        op3 = (RadioButton) v.findViewById(R.id.opcion3);

        op1.setText(listPreguntas.get(position).getRespuestas().get(0).toString());
        op2.setText(listPreguntas.get(position).getRespuestas().get(1).toString());
        op3.setText(listPreguntas.get(position).getRespuestas().get(2).toString());
        return v;
    }
}
