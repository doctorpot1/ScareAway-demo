package com.example.boon.scareaway;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {
    private GeofencingClient geofencingClient;
    private HotFenceManager hotFenceManager;
    private PendingIntent geofencePendingIntent;
    public static final String ACTION_ALERT = "alert";
    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            createPopupAlert(intent.getExtras().getString(ACTION_ALERT));
        }
    };

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
                case R.id.navigation_check_in:
                    SafeEntryFragment uploadFragment = new SafeEntryFragment();
                    transaction.replace(R.id.fragmentContainer, uploadFragment);
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
        geofencingClient = LocationServices.getGeofencingClient(this);
        hotFenceManager = new HotFenceManager(geofencingClient, getGeofencePendingIntent(), new TestHotSpots().getHotSpots());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            hotFenceManager.CreateAllGeofence();
            navigation.setSelectedItemId(R.id.navigation_home);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, GMapFragment.MY_PERMISSIONS_REQUEST_LOCATION);
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter(ACTION_ALERT));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode != GMapFragment.MY_PERMISSIONS_REQUEST_LOCATION) {
            return;
        }
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
    }

    private PendingIntent getGeofencePendingIntent() {
        // Reuse the PendingIntent if we already have it.
        if (geofencePendingIntent != null) {
            return geofencePendingIntent;
        }
        Intent intent = new Intent(this, GeofenceBroadcastReceiver.class);
        // We use FLAG_UPDATE_CURRENT so that we get the same pending intent back when
        // calling addGeofences() and removeGeofences().
        geofencePendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return geofencePendingIntent;
    }

    private void createPopupAlert(String msg) {
        Alert alert = Alert.newInstance(msg);
        alert.show(getSupportFragmentManager(),"alert");
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
