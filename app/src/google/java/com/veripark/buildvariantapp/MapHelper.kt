package com.veripark.buildvariantapp

import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapHelper(activity: AppCompatActivity) {

    private lateinit var map: GoogleMap
    private var mActivity: AppCompatActivity = activity

    init {
        initMap()
    }

    private fun initMap() {
        val mapFragment =
            (mActivity.supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment)
        mapFragment.getMapAsync {
            map = it
            map.addMarker(
                MarkerOptions().position(LatLng(LATITUDE, LONGITUDE)).title(SNIPPET)
            )?.snippet = TITLE
        }
    }

    companion object {
        private const val TITLE = "Welcome to Heaven"
        private const val SNIPPET = "Google Map"
        private const val LATITUDE = 40.9808142
        private const val LONGITUDE = 28.7119718
    }
}