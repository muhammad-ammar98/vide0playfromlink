package com.islamicinternationalincims.videoplayfromlink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.islamicinternationalincims.videoplayfromlink.databinding.ActivityAppDetail2Binding;

public class AppDetailActivity2 extends AppCompatActivity {
    ActivityAppDetail2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAppDetail2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textView18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://doc-hosting.flycricket.io/unityummah/db99eb54-dcba-4515-9ca7-7c782f27bcfa/privacy"));
                startActivity(intent2);
            }
        });

        binding.textView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://doc-hosting.flycricket.io/unityummah-term/81ae08b9-daba-454a-b711-3109b4798755/terms"));
                startActivity(intent1);
            }
        });
    }
}