package com.marcel.nutrilife;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.marcel.nutrilife.fragments.DicasFragment;
import com.marcel.nutrilife.fragments.DietaFragment;
import com.marcel.nutrilife.fragments.ImcFragment;
import com.marcel.nutrilife.fragments.MainFragment;
import com.marcel.nutrilife.fragments.NutricionistaFragment;
import com.marcel.nutrilife.fragments.SobreFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //Criando as visualizações do navigation drawer
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Acessando a Fragment Principal
        android.app.FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame,new MainFragment()).commit();
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

    //Menu Superior Direito
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Programação das opções no Navigation Drawer
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        android.app.FragmentManager fm = getFragmentManager();
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            //Fazendo a ligação entre o fragmento e a opção selecionada
            fm.beginTransaction().replace(R.id.content_frame, new MainFragment()).commit();
        } else if (id == R.id.nav_dieta) {
            fm.beginTransaction().replace(R.id.content_frame, new DietaFragment()).commit();
        } else if (id == R.id.nav_dicas) {
            fm.beginTransaction().replace(R.id.content_frame, new DicasFragment()).commit();
        } else if (id == R.id.nav_imc) {
            fm.beginTransaction().replace(R.id.content_frame, new ImcFragment()).commit();
        } else if (id == R.id.nav_nutricionista) {
            fm.beginTransaction().replace(R.id.content_frame, new NutricionistaFragment()).commit();
        } else if (id == R.id.nav_sobre) {
            fm.beginTransaction().replace(R.id.content_frame, new SobreFragment()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
