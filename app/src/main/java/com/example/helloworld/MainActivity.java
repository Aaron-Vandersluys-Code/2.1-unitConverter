package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Importing classes
    EditText myEditText;
    TextView myTextView;
    Button myButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking to UI assets
        myTextView = findViewById(R.id.textView2);
        myEditText = findViewById(R.id.editTextTextPersonName);
        myButton = findViewById(R.id.button);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            // Get the value of myEditText
            public void onClick(View view) {
                String inputValue = myEditText.getText().toString();
                Toast.makeText(MainActivity.this, inputValue,Toast.LENGTH_LONG).show();

                // Change the value of myTextView
                myTextView.setText("This is new text");
                myTextView.setText("Welcome to SIT305 " + inputValue);
            }
        });
    }
}