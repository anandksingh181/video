package com.example.video;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example usage: Saving a video from raw resources to internal storage
        InputStream videoInputStream = getResources().openRawResource(R.raw.my_video); // Assuming my_video.mp4 is in the raw folder
        String fileName = "my_video.mp4";
        File savedFile = VideoUtils.saveVideoToInternalStorage(this, videoInputStream, fileName);
        if (savedFile != null) {
            String savedFilePath = savedFile.getAbsolutePath();
            Toast.makeText(this, "Video saved successfully to internal storage\nPath: " + savedFilePath, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Failed to save video to internal storage", Toast.LENGTH_SHORT).show();
        }
    }
}

