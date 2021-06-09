package com.omercankoc.dynamicbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

// Uygulamada kullanabilmek icin sistemin yaydigi bir yayini kullanmak.
open class DynamicBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // Yayin alininca kullaniciya mesaji goster.
        Toast.makeText(context,"Airplane Mode Changed!",Toast.LENGTH_LONG).show()
    }
}