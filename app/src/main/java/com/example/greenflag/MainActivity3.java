package com.example.greenflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView t1, t2;
        t1 = findViewById(R.id.username);
        t2 = findViewById(R.id.password);
        ImageView backButton2 = findViewById(R.id.back_button2);

        backButton2.setOnClickListener(v -> {
            Intent goBackIntent = new Intent(getBaseContext(), MainActivity2.class);
            startActivity(goBackIntent);
        });

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.greenflag",MODE_PRIVATE);
        String user = sharedPreferences.getString("email","");
        String password = sharedPreferences.getString("password","");

        t1.setText(user);
        t2.setText(password);
    }
}