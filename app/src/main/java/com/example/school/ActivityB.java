package com.example.school;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 2;

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        resultTextView = findViewById(R.id.resultTextView);

        String message = getIntent().getStringExtra("message");
        TextView messageTextView = findViewById(R.id.messageTextView);
        messageTextView.setText(message);

        Button fetchInfoButton = findViewById(R.id.fetchInfoButton);
        fetchInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchInfo();
            }
        });

        Button takePhotoButton = findViewById(R.id.takePhotoButton);
        takePhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });

        Button activityCButton = findViewById(R.id.launchActivityCButton);
        activityCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivityC();
            }
        });
    }

    private void fetchInfo() {
        new FetchInfoTask().execute();
    }

    private void takePhoto() {
        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePhotoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePhotoIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private class FetchInfoTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            // Simulate fetching information from an external database
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Info BDD récupérée";
        }

        @Override
        protected void onPostExecute(String result) {
            resultTextView.setText(result);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Handle the captured photo
        }
    }

    private void launchActivityC() {
        Intent intent = new Intent(this, ActivityC.class);
        startActivity(intent);
    }
}
