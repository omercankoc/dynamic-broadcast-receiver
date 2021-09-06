# Dynamic Broadcast Receiver

Notify when user switches to airplane mode.

### To use a broadcast from the system to use it in the application. An instance of an inherited class.
```kotlin
open class DynamicBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // Show the message to the user when you receive a broadcast.
        Toast.makeText(context,"Airplane Mode Changed!",Toast.LENGTH_LONG).show()
    }
}
```

### The Broadcast Receiver needs to be added to the Manifest file.
```xml
<application ... >
    <activity ... >
        ...
    </activity>
    <receiver android:name=".DynamicBroadcast" />
</application>
```

### Definition Dynamic Broadcast.
```kotlin
private lateinit var dynamicBroadcast : DynamicBroadcast
```

### Initialize Dynamic Broadcast.
```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
     setContentView(R.layout.activity_main)

     dynamicBroadcast = DynamicBroadcast()
}
```

### Start the broadcast when you switch to airplane mode while in use.
```kotlin
override fun onResume() {
    super.onResume()

    // Create Broadcast
    val intentFilter : IntentFilter = IntentFilter()
    intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)

    // Register Receiver
    registerReceiver(dynamicBroadcast,intentFilter)
}
```

### End stream if use is interrupted.
```kotlin
override fun onPause() {
    unregisterReceiver(dynamicBroadcast)

    super.onPause()
}
```
