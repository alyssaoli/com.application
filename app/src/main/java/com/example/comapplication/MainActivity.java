package com.example.comapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int REQUEST_CODE = 100;

    SharedPreferences preferences;

// Views
EditText textName;
    Button btnNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init shared prefs
        preferences = getSharedPreferences("user", MODE_PRIVATE);

        // Find views
        btnNext = findViewById(R.id.next);
        textName = findViewById(R.id.name);

        // Check if user's name is saved in shared preferences
        String userName = preferences.getString("name", null);
        if(userName != null){
            // Set it to edit text
            textName.setText(userName);
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent and put name in it
                Intent intent = new Intent(MainActivity.this, NameActivity.class);
                intent.putExtra("name", textName.getText().toString());

                // Start activity for result
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Save the name to shared preferences
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", textName.getText().toString());
            }

            @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check the request code
        if(requestCode == REQUEST_CODE){
            // Check the result
            if(resultCode == 1){
                // User is happy
                finish();
            }else if(resultCode == 0){
                // User wants to change the name
                // we don't do anything, let the user type the new name and press next to change it
            }
        }
    }
}