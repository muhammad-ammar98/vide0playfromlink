package com.islamicinternationalincims.videoplayfromlink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class splashActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        int secondsDelayed = 1;
        try {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(splashActivity2.this, MainActivity.class));
                    finish();
                }
            }, secondsDelayed * 2000);
        }catch (Exception e){
            Toast.makeText(this, "Error "+e, Toast.LENGTH_SHORT).show();
        }
    }
}