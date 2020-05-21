package com.example.boon.scareaway;

import android.app.PendingIntent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
/*
* Manager to manage geofences, in this demo, it doesn't really handle much but with the 100 geofence limit we should rotate the geofences to only have those near the user
* as well as handling in the background
* */
public class HotFenceManager {
    private GeofencingClient geofencingClient;
    private PendingIntent geofencePendingIntent;
    private ArrayList<HotSpot> hotSpots;
    private ArrayList<HotSpot> fencingHotSpots = new ArrayList<>();
    private ArrayList<HotSpot> fencedHotSpots = new ArrayList<>();
    private ArrayList<Geofence> geofences = new ArrayList<>();
    static private int LOITERING_DURATION_MS = 60000;

    public HotFenceManager(GeofencingClient geofencingClient, PendingIntent geofencePendingIntent) {
        this.geofencingClient = geofencingClient;
        this.geofencePendingIntent = geofencePendingIntent;
        hotSpots = new ArrayList<>();
    }

    public HotFenceManager(GeofencingClient geofencingClient, PendingIntent geofencePendingIntent, ArrayList<HotSpot> hotSpots) {
        this.geofencingClient = geofencingClient;
        this.geofencePendingIntent = geofencePendingIntent;
        this.hotSpots = hotSpots;
    }

    public void CreateAllGeofence() {
        for (int i = 0; i < hotSpots.size(); i++) {
            CreateGeofence(hotSpots.get(i));
        }
        try {
            geofencingClient.addGeofences(getGeofencingRequest(), geofencePendingIntent)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            for (int i = 0; i < fencingHotSpots.size(); i++) {
                                fencedHotSpots.add(fencingHotSpots.get(i));
                            }
                            fencingHotSpots = new ArrayList<>();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            DestroyAllGeofence();
                            fencingHotSpots = new ArrayList<>();
                        }
                    });
        } catch (Exception e) {
            Log.e("CreateAllGeofence Err", "CreateAllGeofence: " + e.getMessage());
        }
    }

    private GeofencingRequest getGeofencingRequest() {
        return new GeofencingRequest.Builder()
                .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER | GeofencingRequest.INITIAL_TRIGGER_DWELL | GeofencingRequest.INITIAL_TRIGGER_EXIT)
                .addGeofences(geofences).build();
    }

    public void CreateGeofence(HotSpot hotSpot) {
        try {
            geofences.add(new Geofence.Builder()
                    // Set the request ID of the geofence. This is a string to identify this geofence.
                    .setRequestId(hotSpot.getTitle())
                    .setCircularRegion(hotSpot.getLat(), hotSpot.getLon(), hotSpot.getRad())
                    .setExpirationDuration(Geofence.NEVER_EXPIRE).setLoiteringDelay(LOITERING_DURATION_MS)
                    .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT | Geofence.GEOFENCE_TRANSITION_DWELL)
                    .build());
            fencingHotSpots.add(hotSpot);
        } catch (Exception e) {
        }
    }

    public void DestroyAllGeofence() {
        geofencingClient.removeGeofences(geofencePendingIntent)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        geofences = new ArrayList<Geofence>();
                        fencedHotSpots = new ArrayList<HotSpot>();
                        Toast.makeText(geofencingClient.getApplicationContext(), "Removed all Geofence!!!", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("DestroyAllGeofence fail", "Nothing Removed");
                    }
                });
    }
}
