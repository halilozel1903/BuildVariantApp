package com.veripark.buildvariantapp

import androidx.appcompat.app.AppCompatActivity
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.SupportMapFragment
import com.huawei.hms.maps.model.LatLng
import com.huawei.hms.maps.model.MarkerOptions

class MapHelper(activity: AppCompatActivity) {

    private lateinit var map : HuaweiMap
    private var mActivity : AppCompatActivity = activity

    init {
        initMap()
    }

    private fun initMap(){
        val mapFragment  = (mActivity.supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment)
        mapFragment.getMapAsync {
            map = it
            map.addMarker(MarkerOptions().position(LatLng(40.9808142, 28.7119718)).title("Huawei Map Kit")).snippet = "Welcome to Hell"
        }
    }
}