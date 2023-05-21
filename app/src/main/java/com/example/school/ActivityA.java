package com.example.school;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityA extends AppCompatActivity {

    private static final int REQUEST_CODE_B = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Button launchActivityBButton = findViewById(R.id.launchActivityBButton);
        launchActivityBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivityB();
            }
        });
    }

    private void launchActivityB() {
        String message = "Lancée depuis l'activité A!";
        Intent intent = new Intent(this, ActivityB.class);
        intent.putExtra("message", message);
        startActivityForResult(intent, REQUEST_CODE_B);
    }


            }

