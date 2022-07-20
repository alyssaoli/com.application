package com.example.comapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    TextView textWelcome;
    Button btnDontCallMe, btnThankYou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        // Get the user's name from intent
        String userName = getIntent().getExtras().getString("name", null);

        // Find views
        textWelcome = findViewById(R.id.welcomeText);
        btnDontCallMe = findViewById(R.id.btnDontCallMe);
        btnThankYou = findViewById(R.id.btnThankYou);

        // Set name to welcome text
        textWelcome.setText("Welcome " + userName + "!");

        // Button presses
        btnThankYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set result as 1 and end activity
                setResult(1);
                finish();
            }
        });

        btnDontCallMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set result as 0 and end activity
                setResult(0);
                finish();
            }
        });
    }
}