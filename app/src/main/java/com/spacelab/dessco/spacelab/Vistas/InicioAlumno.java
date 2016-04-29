package com.spacelab.dessco.spacelab.Vistas;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.spacelab.dessco.spacelab.Adapters.AdaptadorPracticas;
import com.spacelab.dessco.spacelab.Modelos.Alumno;
import com.spacelab.dessco.spacelab.Modelos.Practica;
import com.spacelab.dessco.spacelab.R;
import com.spacelab.dessco.spacelab.Servicio.ServiceInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InicioAlumno extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Alumno alumno;
    private Toolbar toolbar;
    private String baseUrl="http://spacelab-dessco.rhcloud.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_alumno);

        alumno = getIntent().getParcelableExtra("AlumnoKey");// obtenemos nuestro objeto parcelable
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            // no hagas nada osea no regreses plox
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.inicio_alumno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment;
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_practicas) {
            fragment = new PracticasFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.contentInicioAlumno,fragment)
                    .commit();
            toolbar.setTitle("Practicas Activas");
        } else if (id == R.id.nav_examenes) {

        } else if (id == R.id.nav_cuestionarios) {
            fragment = new CuestFragmet();
            fragmentManager.beginTransaction()
                    .replace(R.id.contentInicioAlumno, fragment)
                    .commit();
            toolbar.setTitle("Cuestionarios Activos");
        }else if (id == R.id.nav_calificaciones) {
                fragment = new CalifFragment();
                Bundle saveData = new Bundle();
                saveData.putParcelable("AlumnoKey",alumno);
                fragment.setArguments(saveData);
                fragmentManager.beginTransaction()
                        .replace(R.id.contentInicioAlumno,fragment)
                        .commit();
                toolbar.setTitle("Tus Calificaciones");
            }else if (id == R.id.nav_config) {
            fragment = new DatosFragment();
            Bundle saveData = new Bundle();
            saveData.putParcelable("AlumnoKey",alumno);
            fragment.setArguments(saveData);
            fragmentManager.beginTransaction()
                    .replace(R.id.contentInicioAlumno,fragment)
                    .commit();
            toolbar.setTitle("Tus Datos");
        } else if (id == R.id.nav_exit) {
            Intent i = new Intent(this,Main.class);
            finish();
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
