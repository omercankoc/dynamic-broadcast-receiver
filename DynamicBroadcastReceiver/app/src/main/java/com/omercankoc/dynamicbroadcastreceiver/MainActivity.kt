package com.omercankoc.dynamicbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    // Definition Dynamic Broadcast
    private lateinit var dynamicBroadcast : DynamicBroadcast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Dynamic Broadcast
        dynamicBroadcast = DynamicBroadcast()
    }

    // Kullanim halindeyken ucak moduna gecince yayini baslat.
    override fun onResume() {
        super.onResume()

        // Broadcast tanimla.
        val intentFilter : IntentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        // Broadcast ve Receiver'i bagla.
        registerReceiver(dynamicBroadcast,intentFilter)
    }

    // Kullanima ara verilirse yayini sonlandir.
    override fun onPause() {

        // Yayini sonlandir.
        unregisterReceiver(dynamicBroadcast)

        super.onPause()
    }
}