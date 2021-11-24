package com.example.greenflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private ImageView image_view;
    private TextView text_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_view = findViewById(R.id.imageView5);
        text_view = findViewById(R.id.textView6);

        image_view.setOnClickListener(v -> {
            Intent createAccountIntent = new Intent(getBaseContext(), MainActivity2.class);
            startActivity(createAccountIntent);
        });

        text_view.setOnClickListener(v -> {
            Intent createAccountIntent = new Intent(getBaseContext(), MainActivity2.class);
            startActivity(createAccountIntent);
        });

    }
}