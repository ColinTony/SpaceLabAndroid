package com.spacelab.dessco.spacelab.Vistas;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.spacelab.dessco.spacelab.R;

public class Main extends AppCompatActivity {
    private TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titulo = (TextView) findViewById(R.id.titulo);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/gloriahallelujah.ttf");
        titulo.setTypeface(font);
    }
    public void signIn(View v) {
        Intent i = new Intent(this, SignIn.class);
        startActivity(i);
        overridePendingTransition(R.transition.fade_entrada, R.transition.zoom_back_out);
    }
    public void signUp(View v){
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
    }
}
