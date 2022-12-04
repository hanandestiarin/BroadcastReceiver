package com.example.broadcastsender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ExampleBroadcastReceiver2 exampleBroadcastReceiver2 = new ExampleBroadcastReceiver2();
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_View);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
    }

    private void sendBroadcast(View v) {
        Intent intent = new Intent("com.example.EXAMPLE_ACTION");

        localBroadcastManager.sendBroadcast(intent);
    }

    @Override
    protected void onStart(){
        super.onStart();
        IntentFilter filter = new IntentFilter("com.example.EXAMPLE_ACTION");
        localBroadcastManager.registerReceiver(exampleBroadcastReceiver2, filter);
    }

    @Override
    protected void onStop(){
        super.onStop();
        localBroadcastManager.unregisterReceiver(exampleBroadcastReceiver2);
    }
}