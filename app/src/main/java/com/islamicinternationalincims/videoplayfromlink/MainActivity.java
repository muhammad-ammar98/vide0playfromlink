package com.islamicinternationalincims.videoplayfromlink;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;

import com.islamicinternationalincims.videoplayfromlink.databinding.ActivityMainBinding;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
  //  SimpleExoPlayerView exoPlayerView;

    // creating a variable for exoplayer
    SimpleExoPlayer exoPlayer;

    // url of video which we are loading.
    String videoURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.idExoPlayerVIew.setVisibility(View.GONE);

        binding.textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.button.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                binding.button.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AppDetailActivity2.class);
                startActivity(intent);
            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoURL=binding.textView.getText().toString();
                int a=binding.textView.length();
                if(videoURL.substring(a-4,a).equals(".mp4") && videoURL.substring(a-4,a).equals(".mov")){

                    try {
                        binding.idExoPlayerVIew.setVisibility(View.VISIBLE);
                        binding.floatingActionButton.setVisibility(View.VISIBLE);

                        binding.idExoPlayerVIew.setVisibility(View.VISIBLE);

                        // BandwidthMeter is used for
                        ExoPlayer player = new ExoPlayer.Builder(MainActivity.this).build();
                        binding.idExoPlayerVIew.setPlayer(player);
                        // Build the media item.
                        MediaItem mediaItem = MediaItem.fromUri(videoURL);
// Set the media item to be played.
                        player.setMediaItem(mediaItem);
// Prepare the player.
                        player.prepare();
// Start the playback.
                        player.play();
                        // we are setting our exoplayer
                        // when it is ready.
                        exoPlayer.setPlayWhenReady(true);
                        binding.textView.setText("");

                    } catch (Exception e) {
                        // below line is used for
                        // handling our errors.
                        Log.e("TAG", "Error : " + e.toString());
                    }

                }else {
                    binding.textView.setText("");
                    Toast.makeText(MainActivity.this, "Please Enter correct video link", Toast.LENGTH_SHORT).show();
                }
               // exoPlayerView = findViewById(R.id.idExoPlayerVIew);


            }
        });


    }

    public void imagedownload(String filename, String imageurl) {

        try {




            DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri = Uri.parse(imageurl);
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI)
                    .setTitle(filename)
                    // .setMimeType("vedio/mp4")
                    .setAllowedOverRoaming(false)

                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, File.separator + filename +".mp4");

            downloadManager.enqueue(request);

            Toast.makeText(MainActivity.this, filename+" Downloading start......", Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, filename+" Downloading  progress see in Notification.", Toast.LENGTH_SHORT).show();
            // binding.progressBar.setVisibility(View.GONE);

            //   if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE))
            // Permission is already granted
            // Perform storage-related operations here



        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Downloading fail...", Toast.LENGTH_SHORT).show();
        }


    }




}