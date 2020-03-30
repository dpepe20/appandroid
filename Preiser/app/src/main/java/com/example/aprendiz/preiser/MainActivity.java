package com.example.aprendiz.preiser;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.aprendiz.preiser.fragments.AcercaDeFragment;
import com.example.aprendiz.preiser.fragments.Consultar_ElementoFragment;
import com.example.aprendiz.preiser.fragments.Consultar_PrestamoFragment;
import com.example.aprendiz.preiser.fragments.ContactenosFragment;
import com.example.aprendiz.preiser.fragments.InicioFragment;
import com.example.aprendiz.preiser.fragments.ReportesFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new InicioFragment()).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
     //navigationView.setItemTextColor(ColorStateList.valueOf(getColor(R.color.colerBlanco)));
     //navigationView.setItemIconTintList(ColorStateList.valueOf(getColor(R.color.colerBlanco)));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_reporte) {
            setTitle("Reportes");
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new ReportesFragment()).commit();
        } else if (id == R.id.nav_consultar_reportes) {
            setTitle("Consultas Prestamos");
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new Consultar_PrestamoFragment()).commit();
        }else if (id == R.id.nav_consultar_elementos){
            setTitle("Consultar Elementos");
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new Consultar_ElementoFragment()).commit();
        } else if (id == R.id.nav_contactenos) {
            setTitle("Contactenos");
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new ContactenosFragment()).commit();
        } else if (id == R.id.nav_acercade) {
            setTitle("Acerca de");
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new AcercaDeFragment()).commit();
        }else if(id == R.id.nav_inicio){
            setTitle("Inicio");
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new InicioFragment()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
