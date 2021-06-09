package com.omercankoc.dynamicbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    // Definition dynamic broadcast
    private lateinit var dynamicBroadcast : DynamicBroadcast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize dynamic broadcast
        dynamicBroadcast = DynamicBroadcast()
    }

    // Kullanim halindeyken batarya seviyesi duserse uyar.
    override fun onResume() {
        super.onResume()

        // Yayin tanimla.
        val intentFilter : IntentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        // Broadcast ve Receiver'i bagla.
        registerReceiver(dynamicBroadcast,intentFilter)
    }

    // Kullanima ara  verilirse aliciyi sonlandir.
    override fun onPause() {
        // Aliciyi sonlandir.
        unregisterReceiver(dynamicBroadcast)

        super.onPause()
    }
}