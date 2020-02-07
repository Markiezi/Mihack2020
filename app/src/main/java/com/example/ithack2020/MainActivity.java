package com.example.ithack2020;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.botnavview);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,
                new Dashfragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.mainmenu:
                            selectedFragment = new Homefragment();
                            break;
                        case R.id.dash:
                            selectedFragment = new Dashfragment();
                            break;
                        case R.id.chat:
                            selectedFragment = new Chatfragment();
                            break;
                        case R.id.plan:
                            selectedFragment = new Planfragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,
                            selectedFragment).commit();
                    return true;

                }
            };
}
