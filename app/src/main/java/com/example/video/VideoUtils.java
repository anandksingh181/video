package com.example.video;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class VideoUtils {

    private static final String TAG = "VideoUtils";

    public static File saveVideoToInternalStorage(Context context, InputStream videoInputStream, String fileName) {
        // Get internal storage directory
        File internalStorageDir = context.getFilesDir();
        Log.d(TAG, "Internal storage directory: " + internalStorageDir.getAbsolutePath());


        // Create file reference
        File videoFile = new File(internalStorageDir, fileName);
        Log.d(TAG, "Video file path: " + videoFile.getAbsolutePath());

        try {
            // Create FileOutputStream
            OutputStream outputStream = new FileOutputStream(videoFile);

            // Write video data
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = videoInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // Close streams
            outputStream.close();
            videoInputStream.close();

            Log.d(TAG, "Video saved successfully to internal storage");


            return videoFile; // Return saved file
        } catch (IOException e) {
            Log.e(TAG, "Error saving video to internal storage: " + e.getMessage());

            e.printStackTrace();
            return null; // Error
        }
    }
}
