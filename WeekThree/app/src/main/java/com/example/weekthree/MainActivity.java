package com.example.weekthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // create button variable (class must be imported)
    Button buttonOne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOne = findViewById(R.id.buttonOne);

        // Set onClick listener and Intent to move between app screens

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent moveIntent = new Intent(MainActivity.this, MainActivity2.class);
            moveIntent.putExtra("Value", "SIT305");
            startActivity(moveIntent);
            }
        }) ;


    }
}