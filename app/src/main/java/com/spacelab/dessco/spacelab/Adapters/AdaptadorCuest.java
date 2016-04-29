package com.spacelab.dessco.spacelab.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.spacelab.dessco.spacelab.Modelos.Cuestionario;
import com.spacelab.dessco.spacelab.R;

import java.util.List;

/**
 * Created by LuisAntonio on 29/04/2016.
 */
public class AdaptadorCuest extends ArrayAdapter<Cuestionario> {
    private List <Cuestionario> cuestList;
    public AdaptadorCuest(Context context, List<Cuestionario> cuestionarioList) {
        super(context, R.layout.list_item_cuestionarios , cuestionarioList);
        cuestList = cuestionarioList;
    }

    public View getView(int pos,View convertView , ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_item_cuestionarios, null);

        TextView nameCuest = (TextView) item.findViewById(R.id.nameCuestionario);
        nameCuest.setText(cuestList.get(pos).getTitulo());
        return item;
    }
}
