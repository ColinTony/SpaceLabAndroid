package com.spacelab.dessco.spacelab.Vistas;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spacelab.dessco.spacelab.Modelos.Alumno;
import com.spacelab.dessco.spacelab.R;

/**
 * Created by LuisAntonio on 23/04/2016.
 */
public class DatosFragment extends Fragment {
    private View myView;
    private Alumno alum;
    TextView nombre,apPat,apMat,boleta,email;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_datos_alumno,container,false);
        alum = getArguments().getParcelable("AlumnoKey");

        nombre = (TextView) myView.findViewById(R.id.consultaNombre);
        boleta = (TextView) myView.findViewById(R.id.consultaBoletaAlumno);
        email = (TextView) myView.findViewById(R.id.consultaEmail);

        nombre.setText(alum.getNombre() +" "+ alum.getApPat() +" "+ alum.getApMat());
        boleta.setText(Integer.toString(alum.getBoleta()));
        email.setText(alum.getEmail());
        return myView;
    }
}
