package com.spacelab.dessco.spacelab.Vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.spacelab.dessco.spacelab.R;

public class InicioAlumno extends AppCompatActivity {
    private TextView nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_alumno);
        Bundle bolsa = getIntent().getExtras();

        nombre = (TextView) findViewById(R.id.bienvenidoAlumno);
        nombre.setText("Bienvenido " + bolsa.getString("nombreKey"));
    }

}
