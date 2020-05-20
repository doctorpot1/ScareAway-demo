package com.example.boon.scareaway;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import static android.content.Context.LOCATION_SERVICE;

public class GMapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMarkerClickListener, LocationListener {
    private GoogleMap map;
    private MapView mapView;
    private boolean mapsSupported = true;
    private boolean hotspotPlotted = false;
    private boolean firstTimeZoom = true;

    private static final LatLng SINGAPORE = new LatLng(1.3458, 103.7959);
    CameraPosition initView = new CameraPosition.Builder().target(SINGAPORE).zoom(12).build();
    public GMapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
        initializeMap();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        hotspotPlotted = false;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FrameLayout parent = (FrameLayout) inflater.inflate(R.layout.fragment_gmap, container, false);
        mapView = (MapView) parent.findViewById(R.id.mapView);
        // Inflate the layout for this fragment
        return parent;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {  MapsInitializer.initialize(getActivity()); }
        catch (Exception e) { mapsSupported = false;}

        if (mapView != null) { mapView.onCreate(savedInstanceState); }
        initializeMap();
    }

    private void initializeMap() {
        if (map == null && mapsSupported) mapView.getMapAsync(this);
    }

    private void addHotspot(double lat, double lon, String title, String snippet, int rad, int color) {
        LatLng loc = new LatLng(lat, lon);
        MarkerOptions marker = new MarkerOptions().position(loc);
        if(title != "") marker.title(title);
        if(snippet != "") marker.snippet(snippet);
        map.addMarker(marker);
        //Instantiates a new CircleOptions object +  center/radius
        CircleOptions circleOptions = new CircleOptions().center(loc).radius(rad).fillColor(color).strokeColor(Color.TRANSPARENT).strokeWidth(2);
        map.addCircle(circleOptions);
        zoomMapToLocation(loc,15);
    }

    private void zoomMapToLocation(double lat, double lon, int zoom) { map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lon), zoom));}

    private void zoomMapToLocation(LatLng latLng, int zoom) { map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));}

    // Get last known location
    private void getLastKnownLocation() {

    }

    private void enableUserLocationSettings() {
        map.setMyLocationEnabled(true);
        map.getUiSettings().setMyLocationButtonEnabled(true);
    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    // Callback called when Map is ready
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.moveCamera(CameraUpdateFactory.newCameraPosition(initView));
        map.setOnMapClickListener(this);
        map.setOnMarkerClickListener(this);
        if(!hotspotPlotted) {
            TestHotSpots initList = new TestHotSpots();
            ArrayList<HotSpot> hotSpots = initList.getHotSpots();
            for(int i=0; i < hotSpots.size(); i++) {
                HotSpot spot = hotSpots.get(i);
                addHotspot(spot.getLat(),spot.getLon(),spot.getTitle(),spot.getSnippet(),spot.getRad(),spot.getColor());
            }
            hotspotPlotted = true;
        }
        if (ContextCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            enableUserLocationSettings();
            LocationManager mLocationManager = (LocationManager) this.getContext().getSystemService(LOCATION_SERVICE);
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1,1, this);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        if(firstTimeZoom) {
            LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
            zoomMapToLocation(loc,17);
            firstTimeZoom = false;
        }
    }

    @Override
    public void onProviderDisabled(String var1) {

    }

    @Override
    public void onProviderEnabled(String var1) {

    }

    @Override
    public void onStatusChanged(String var1, int var2, Bundle var3) {

    }
    // Callback called when Map is touched
    @Override
    public void onMapClick(LatLng latLng) {
        Log.d("Map", "onMapClick("+latLng +")");
    }

    // Callback called when Marker is touched
    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.d("Map", "onMarkerClickListener: " + marker.getPosition() );
        if(marker.isInfoWindowShown()) marker.hideInfoWindow();
        else marker.showInfoWindow();
        return true;
    }
}
