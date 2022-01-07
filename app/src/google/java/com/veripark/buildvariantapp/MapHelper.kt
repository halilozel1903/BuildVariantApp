package com.veripark.buildvariantapp

import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapHelper(activity: AppCompatActivity) {

    private lateinit var map : GoogleMap
    private var mActivity : AppCompatActivity = activity

    init {
        initMap()
    }
    private fun initMap()
    {
        val mapFragment  = (mActivity.supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment)
        mapFragment.getMapAsync {
            map = it
            map.addMarker(MarkerOptions().position(LatLng(40.9808142, 28.7119718)).title("Google Map"))?.snippet = "Welcome to Heaven"
        }
    }
}