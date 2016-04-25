package com.spacelab.dessco.spacelab.Vistas;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spacelab.dessco.spacelab.Modelos.Alumno;
import com.spacelab.dessco.spacelab.R;

/**
 * Created by LuisAntonio on 25/04/2016.
 */
public class navBarFragment extends Fragment  {
    private Alumno alum;
    private TextView nomb,email;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        alum = getArguments().getParcelable("AlumnoKey");
        View v = inflater.inflate(R.layout.nav_header_inicio_alumno,container,false);
        nomb = (TextView) v.findViewById(R.id.nombreAlumNavBar);
        email = (TextView) v.findViewById(R.id.emailAlumnoNavBar);
        nomb.setText(alum.getNombre() + " " + alum.getApPat());
        email.setText(alum.getEmail());
        return v;
    }
}
