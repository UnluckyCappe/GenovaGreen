package com.example.genovagreen;

import android.app.ActionBar;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);


        dl=(DrawerLayout)findViewById(R.id.dl) ;
        abdt=new ActionBarDrawerToggle(this,dl, R.string.Open, R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();

        getActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id= menuItem.getItemId();
                        if(id== R.id.nav_home)
                        {
                            Toast.makeText(MainActivity.this,"Home", Toast.LENGTH_SHORT).show();
                        }
                else if(id== R.id.nav_butto)
                {
                    Toast.makeText(MainActivity.this,"Dove lo butto?", Toast.LENGTH_SHORT).show();
                }
                else if(id== R.id.nav_pericolosi)
                {
                    Toast.makeText(MainActivity.this,"Rifiuti pericolosi", Toast.LENGTH_SHORT).show();
                }
                else if(id== R.id.nav_spedizioni)
                {
                    Toast.makeText(MainActivity.this,"Spedizioni", Toast.LENGTH_SHORT).show();
                }
                else if(id== R.id.nav_impostazioni)
                {
                    Toast.makeText(MainActivity.this,"Impostazioni", Toast.LENGTH_SHORT).show();
                }
                else if(id== R.id.nav_contatti)
                {
                    Toast.makeText(MainActivity.this,"Contatti", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return abdt.onOptionsItemSelected(item)||super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
