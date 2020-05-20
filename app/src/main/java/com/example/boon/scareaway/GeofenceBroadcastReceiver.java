package com.example.boon.scareaway;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.GeofencingEvent;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class GeofenceBroadcastReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        Log.e("Geofence onReceive","Geofenced!!!");
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        if (geofencingEvent.hasError()) {
            String errorMessage = GeofenceStatusCodes.getStatusCodeString(geofencingEvent.getErrorCode());
            Log.e("Geofence hasError", errorMessage);
            Toast.makeText(context,"Geofence Error!!!",Toast.LENGTH_LONG).show();
            return;
        }
        // Get the transition type.
        int geofenceTransition = geofencingEvent.getGeofenceTransition();
        // Get the geofences that were triggered. A single event can trigger multiple geofences.
        List<Geofence> triggeringGeofences = geofencingEvent.getTriggeringGeofences();
        // Get the transition details as a String.
        String geofenceTransitionDetails = getGeofenceTrasitionDetails(geofenceTransition, triggeringGeofences);

        // Test that the reported transition was of interest.
        if (geofenceTransition == Geofence.GEOFENCE_TRANSITION_ENTER) {
            // Send notification and log the transition details.
//            sendNotification(geofenceTransitionDetails);
            Log.e("Geofence enter", geofenceTransitionDetails);
            Toast.makeText(context,geofenceTransitionDetails,Toast.LENGTH_LONG).show();
        } else if (geofenceTransition == Geofence.GEOFENCE_TRANSITION_DWELL) {
            // Send notification and log the transition details.
//            sendNotification(geofenceTransitionDetails);
            Log.e("Geofence dwell", geofenceTransitionDetails);
            Toast.makeText(context,geofenceTransitionDetails,Toast.LENGTH_LONG).show();
        } else {
            // GEOFENCE_TRANSITION_EXIT
            Log.e("Geofence exit", geofenceTransitionDetails);
            Toast.makeText(context,geofenceTransitionDetails,Toast.LENGTH_LONG).show();
        }
    }

    // Create a detail message with Geofences received
    private String getGeofenceTrasitionDetails(int geoFenceTransition, List<Geofence> triggeringGeofences) {
        // get the ID of each geofence triggered
        ArrayList<String> triggeringGeofencesList = new ArrayList<>();
        for ( Geofence geofence : triggeringGeofences ) {
            triggeringGeofencesList.add( geofence.getRequestId() );
        }

        String status = null;
        if ( geoFenceTransition == Geofence.GEOFENCE_TRANSITION_ENTER )
            status = "Entering ";
        else if ( geoFenceTransition == Geofence.GEOFENCE_TRANSITION_EXIT )
            status = "Exiting ";
        else if ( geoFenceTransition == Geofence.GEOFENCE_TRANSITION_DWELL )
            status = "Staying too long at ";
        return status + TextUtils.join( ", ", triggeringGeofencesList);
    }
}
