package com.example.weekthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        backButton = findViewById(R.id.backButton);

        Intent valueFromIntent = getIntent();
        String value = valueFromIntent.getStringExtra("Value");
        Toast.makeText(MainActivity2.this, value, Toast.LENGTH_SHORT).show();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBack = new Intent();
                goBack.putExtra("Name", "MainActivity2");
                setResult(MainActivity2.RESULT_OK, goBack);
                startActivity(goBack);
            }
        }) ;

    }
}