package com.spacelab.dessco.spacelab.Adapters;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.spacelab.dessco.spacelab.Modelos.Practica;
import com.spacelab.dessco.spacelab.R;

import java.util.List;

/**
 * Created by LuisAntonio on 30/03/2016.
 */
public class AdaptadorPracticas extends ArrayAdapter<Practica>{
    private List<Practica> listaPracticas;

    public AdaptadorPracticas(Context context, List<Practica> practicas) {
        super(context, R.layout.list_item_practicas ,practicas);
        listaPracticas = practicas;
    }

    public View getView(int pos,View convertView , ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_item_practicas, null);

        TextView nombrePractica = (TextView)item.findViewById(R.id.nombrePractica);
        nombrePractica.setText("'" + listaPracticas.get(pos).getNombre()+"'");

        TextView idPractica = (TextView)item.findViewById(R.id.idPractica);
        idPractica.setText("Practica : "+listaPracticas.get(pos).getId());

        return item;
    }
}
