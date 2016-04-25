package com.spacelab.dessco.spacelab.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.spacelab.dessco.spacelab.Modelos.ContenedorGrupo;
import com.spacelab.dessco.spacelab.Modelos.Practica;
import com.spacelab.dessco.spacelab.R;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by Dessco on 31/03/2016.
 */
public class AdaptadorCalif extends ArrayAdapter<ContenedorGrupo> {
    List<ContenedorGrupo> listContent;

    public AdaptadorCalif(Context context, List<ContenedorGrupo> content) {
        super(context, R.layout.list_item_calificaciones ,content);
        listContent = content;
    }

    public View getView(int pos,View convertView , ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_item_calificaciones, null);

        TextView nombrePractica = (TextView)item.findViewById(R.id.practicaName);
        nombrePractica.setText("'"+listContent.get(pos).getNombre()+"'");

        TextView califAlumno = (TextView) item.findViewById(R.id.calificaionAlumnoView);
        califAlumno.setText("Calificacion : " + listContent.get(pos).getPracticas().get(0).getCalificacion());

        return item;
    }
}
