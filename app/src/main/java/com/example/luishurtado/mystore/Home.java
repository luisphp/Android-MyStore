package com.example.luishurtado.mystore;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.NavegadorPrincipal);

        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout1, new FragmentHome()).commit();




    }

        private BottomNavigationView.OnNavigationItemSelectedListener navListener =

                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        Fragment selectedFragment = null;

                        switch (item.getItemId()){
                            case R.id.Home:

                                    FragmentHome.timer.cancel();
                                    selectedFragment = new FragmentHome();


                                break;

                            case R.id.Favoritos:

                                FragmentHome.timer.cancel();
                                selectedFragment = new FragmentFavoritos();


                                break;

                            case R.id.Cart:
                                FragmentHome.timer.cancel();
                                selectedFragment = new FragmentCart();


                                break;

                            case R.id.MiCuenta:

                                FragmentHome.timer.cancel();
                                selectedFragment = new FragmentMiCuenta();



                                break;

                            case R.id.Search:

                                FragmentHome.timer.cancel();
                                selectedFragment = new FragmentSearch();

                                break;

                        }

                        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout1, selectedFragment).commit();

                        return true;
                    }
                };



}
