package com.example.wefish;

import android.app.Fragment;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import com.example.fishingapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class TourMapActivity  extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toursmap);

        Toolbar toolbar = findViewById(R.id.toolbar);
        String title = "Fishing Tours";
        toolbar.setTitle(title);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng place1 = new LatLng(38.364543, 26.467142);
        map.addMarker(new MarkerOptions().position(place1).title("Coşkun Kaptan"));
        map.moveCamera(CameraUpdateFactory.newLatLng(place1));

     }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
