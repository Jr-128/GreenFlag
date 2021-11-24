package com.example.greenflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Set;

public class MainActivity2 extends AppCompatActivity {

    private EditText email;
    private EditText pwd1;
    private EditText pwd2;
    private ImageButton nextButton;
    private ImageView backButton;
    private TextView nextButtonTextView;
    private String spf = "com.example.greenflag";
    private SharedPreferences sharedPreferences;
    private TextWatcher textWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        email = findViewById(R.id.email);
        pwd1 = findViewById(R.id.createPassword);
        pwd2 = findViewById(R.id.repeatPassword);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.back_button);
        nextButtonTextView = findViewById(R.id.nextTextView);
        sharedPreferences = getSharedPreferences(spf, MODE_PRIVATE);

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            email.setText("");
            pwd1.setText("");
            pwd2.setText("");
            startActivity(intent);
        });

        //Disabling the Next button by default
        nextButton.setEnabled(false);
        nextButtonTextView.setEnabled(false);
        nextButton.setAlpha(.25f);





    }//End of the onCreate


    public boolean containsNumber(String password) {
        return password.matches(".*\\d+.*");
    }

    public boolean containsUpperCaseChar(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i)))
                return true;
        }
        return false;
    }

    public boolean containsLowerCaseChar(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i)))
                return true;
        }
        return false;
    }


    public boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isValidPassword(String password) {
        if (String.valueOf(password).length() < 8 ||
                !containsNumber(String.valueOf(password)) ||
                !containsUpperCaseChar(String.valueOf(password)) ||
                !containsLowerCaseChar(String.valueOf(password))
        ) return false;
        else
            return true;
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume invoked");
        email.addTextChangedListener(textWatcher);
        pwd1.addTextChangedListener(textWatcher);
        pwd2.addTextChangedListener(textWatcher);
        textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //Checking if the email is valid
                if (!isValidEmail(String.valueOf(email.getText()))) {
                    Log.d("MainActivity2", "Invalid email, setting error4 to visible");
                    findViewById(R.id.error4_invalid_email_2).setVisibility(View.VISIBLE);
                    findViewById(R.id.Email_Red).setVisibility(View.VISIBLE);
                }

                //Checking if the password meets requirements
                if (!isValidPassword(pwd1.getText().toString())) {
                    Log.d("MainActivity2", "Invalid password, setting error1 to visible");
                    findViewById(R.id.error1_invalid_password).setVisibility(View.VISIBLE);

                    //Check if email in the shared pref file if not, commit , if so error3 visible
                    Set allKeys = sharedPreferences.getAll().keySet();
                    if(!allKeys.contains(email.getText().toString()) &&
                        String.valueOf(pwd1.getText()).equals(String.valueOf(pwd2.getText()))) {
                        findViewById(R.id.email_Green).setVisibility(View.VISIBLE);
                        findViewById(R.id.email_green_tick).setVisibility(View.VISIBLE);
                        findViewById(R.id.create_pass_green).setVisibility(View.VISIBLE);
                        findViewById(R.id.CP_green_tick).setVisibility(View.VISIBLE);
                        findViewById(R.id.RP_green_tick).setVisibility(View.VISIBLE);
                        findViewById(R.id.repeat_pass_green).setVisibility(View.VISIBLE);
                        onPause();
                    }
                    else if(!allKeys.contains(email.getText().toString())){
                        findViewById(R.id.error3_email_already_exists).setVisibility(View.VISIBLE);
                        findViewById(R.id.Email_Red).setVisibility(View.VISIBLE);
                    }
                    else if(!allKeys.contains(email.getText().toString())){
                        findViewById(R.id.error3_email_already_exists).setVisibility(View.VISIBLE);
                        findViewById(R.id.Email_Red).setVisibility(View.VISIBLE);
                    }

                }
            }
        };



    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause invoked");

        SharedPreferences.Editor preferencesEditor = sharedPreferences.edit();
        preferencesEditor.putString(String.valueOf(email), String.valueOf(pwd1));
        preferencesEditor.commit();
        Toast.makeText(getBaseContext(),"Thanks",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy invoked");
    }
}