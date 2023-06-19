package org.bnmit.foodplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an intent to start the next activity
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);

                // Finish the current activity
                finish();
            }
        }, 3000);
    }
}