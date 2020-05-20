package com.example.boon.scareaway;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class GeofenceBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Toast.makeText(arg0,"Geofenced!!!",Toast.LENGTH_LONG).show();
    }
}
