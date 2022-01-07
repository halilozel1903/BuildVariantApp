package com.veripark.buildvariantapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    companion object{
        private const val REQUEST_CODE = 1903
        private val PERMISSIONS = arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION)
    }
    private lateinit var mapHelper: MapHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!hasPermissions(this, *PERMISSIONS)){
            askForPermissions()
        } else {
            mapHelper = MapHelper(this)
        }
        
        /*FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->

            // Get new FCM registration token
            val token = task.result
            println("token $token")
        }*/
    }

    private fun askForPermissions(){
        ActivityCompat.requestPermissions(this, PERMISSIONS, REQUEST_CODE)
    }

    private fun hasPermissions(context: Context, vararg permissions: String): Boolean {
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == REQUEST_CODE) {
            this.recreate()
        }
    }

}