package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnWebsite, btnDial, btnMap, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWebsite = findViewById(R.id.btnWebsite);
        btnDial = findViewById(R.id.btnDial);
        btnMap = findViewById(R.id.btnMap);
        btnEmail = findViewById(R.id.btnEmail);

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW);
                websiteIntent.setData(Uri.parse("https://www.google.com"));
                startActivity(websiteIntent);
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:1234567890"));
                startActivity(dialIntent);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:28.6139,77.2090"); // Delhi
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:example@email.com"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "This is a test email.");
                startActivity(emailIntent);
            }
        });
    }
}
