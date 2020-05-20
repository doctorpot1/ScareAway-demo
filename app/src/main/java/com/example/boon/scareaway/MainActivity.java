package com.example.boon.scareaway;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    GMapFragment gMapFragment = new GMapFragment();
                    transaction.replace(R.id.fragmentContainer, gMapFragment);
                    break;
                case R.id.navigation_upload:
                    SafeEntryFragment uploadFragment = new SafeEntryFragment();
                    transaction.replace(R.id.fragmentContainer, uploadFragment);
                    break;
                case R.id.navigation_check_in:
                    SafeEntryFragment safeEntryFragment = new SafeEntryFragment();
                    transaction.replace(R.id.fragmentContainer, safeEntryFragment);
                    break;
                case R.id.navigation_help:
                    TraceFragment traceFragment = new TraceFragment();
                    transaction.replace(R.id.fragmentContainer, traceFragment);
                    break;
            }
            transaction.commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
    }
}
