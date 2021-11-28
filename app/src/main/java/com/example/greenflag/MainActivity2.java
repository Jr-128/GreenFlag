package com.example.greenflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.Set;

public class MainActivity2 extends AppCompatActivity {

    private EditText email;
    private EditText pwd1;
    private EditText pwd2;
    private ImageButton nextButton;
    private TextView nextButtonTextView;
    private SharedPreferences sharedPreferences;
    private Set allKeys;

    private TextWatcher textWatcherEmail = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Log.d("MainActivity2", "email beforeTextChanged invoked");
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (nextButton.getAlpha() == 1f) {
                nextButton.setEnabled(false);
                nextButtonTextView.setEnabled(false);
                nextButton.setAlpha(.25f);
            }

            if (String.valueOf(email.getText()).length() < 7) {
                findViewById(R.id.email_Green).setVisibility(View.INVISIBLE);
                findViewById(R.id.email_green_tick).setVisibility(View.INVISIBLE);
                findViewById(R.id.Email_Red).setVisibility(View.INVISIBLE);
                findViewById(R.id.error4_invalid_email_2).setVisibility(View.INVISIBLE);
                findViewById(R.id.error3_email_already_exists).setVisibility(View.INVISIBLE);
            } else if (isValidEmail(String.valueOf(email.getText()))) {
                Log.d("MainActivity2", "Valid email, setting email green to visible");
                findViewById(R.id.email_Green).setVisibility(View.VISIBLE);
                findViewById(R.id.email_green_tick).setVisibility(View.VISIBLE);
            } else if (allKeys.contains(String.valueOf(email.getText()))) {
                Log.d("MainActivity2", "Email already exists, setting error3 to visible");
                findViewById(R.id.error3_email_already_exists).setVisibility(View.VISIBLE);
                findViewById(R.id.Email_Red).setVisibility(View.VISIBLE);
            } else {
                Log.d("MainActivity2", "Invalid email, setting error4 to visible");
                findViewById(R.id.error4_invalid_email_2).setVisibility(View.VISIBLE);
                findViewById(R.id.Email_Red).setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (nextButton.getAlpha() == 1f) {
                nextButton.setEnabled(false);
                nextButtonTextView.setEnabled(false);
                nextButton.setAlpha(.25f);
            }

            if (String.valueOf(email.getText()).length() < 7) {
                findViewById(R.id.email_Green).setVisibility(View.INVISIBLE);
                findViewById(R.id.email_green_tick).setVisibility(View.INVISIBLE);
                findViewById(R.id.Email_Red).setVisibility(View.INVISIBLE);
                findViewById(R.id.error4_invalid_email_2).setVisibility(View.INVISIBLE);
                findViewById(R.id.error3_email_already_exists).setVisibility(View.INVISIBLE);
            } else if (isValidEmail(String.valueOf(email.getText()))) {
                Log.d("MainActivity2", "Valid email, setting email green to visible");
                findViewById(R.id.email_Green).setVisibility(View.VISIBLE);
                findViewById(R.id.email_green_tick).setVisibility(View.VISIBLE);
                findViewById(R.id.Email_Red).setVisibility(View.INVISIBLE);
                findViewById(R.id.error4_invalid_email_2).setVisibility(View.INVISIBLE);
            } else if (allKeys.contains(String.valueOf(email.getText()))) {
                Log.d("MainActivity2", "Email already exists, setting error3 to visible");
                findViewById(R.id.error3_email_already_exists).setVisibility(View.VISIBLE);
                findViewById(R.id.Email_Red).setVisibility(View.VISIBLE);
            } else {
                Log.d("MainActivity2", "Invalid email, setting error4 to visible");
                findViewById(R.id.error4_invalid_email_2).setVisibility(View.VISIBLE);
                findViewById(R.id.Email_Red).setVisibility(View.VISIBLE);
            }
        }
    };

    private TextWatcher textWatcherPassword1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Log.d("MainActivity2", "password1 beforeTextChanged invoked");
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (nextButton.getAlpha() == 1f) {
                nextButton.setEnabled(false);
                nextButtonTextView.setEnabled(false);
                nextButton.setAlpha(.25f);
            }

            if (String.valueOf(pwd1.getText()).length() < 7) {
                findViewById(R.id.create_pass_green).setVisibility(View.INVISIBLE);
                findViewById(R.id.CP_green_tick).setVisibility(View.INVISIBLE);
                findViewById(R.id.error1_invalid_password).setVisibility(View.INVISIBLE);
                findViewById(R.id.create_pass_red).setVisibility(View.INVISIBLE);

            } else if (isValidPassword(String.valueOf(pwd1.getText()))) {
                Log.d("MainActivity2", "Valid password, setting password1 green to visible");
                findViewById(R.id.create_pass_green).setVisibility(View.VISIBLE);
                findViewById(R.id.CP_green_tick).setVisibility(View.VISIBLE);
                findViewById(R.id.error1_invalid_password).setVisibility(View.INVISIBLE);
                findViewById(R.id.create_pass_red).setVisibility(View.INVISIBLE);
            } else {
                Log.d("MainActivity2", "Invalid password, setting error1 to visible");
                findViewById(R.id.error1_invalid_password).setVisibility(View.VISIBLE);
                findViewById(R.id.create_pass_red).setVisibility(View.VISIBLE);
                findViewById(R.id.create_pass_green).setVisibility(View.INVISIBLE);
                findViewById(R.id.CP_green_tick).setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (nextButton.getAlpha() == 1f) {
                nextButton.setEnabled(false);
                nextButtonTextView.setEnabled(false);
                nextButton.setAlpha(.25f);
            }
            if (String.valueOf(pwd1.getText()).length() < 7) {
                findViewById(R.id.create_pass_green).setVisibility(View.INVISIBLE);
                findViewById(R.id.CP_green_tick).setVisibility(View.INVISIBLE);
                findViewById(R.id.error1_invalid_password).setVisibility(View.INVISIBLE);
                findViewById(R.id.create_pass_red).setVisibility(View.INVISIBLE);

            } else if (isValidPassword(String.valueOf(pwd1.getText()))) {
                Log.d("MainActivity2", "Valid password, setting password1 green to visible");
                findViewById(R.id.create_pass_green).setVisibility(View.VISIBLE);
                findViewById(R.id.CP_green_tick).setVisibility(View.VISIBLE);
            } else {
                Log.d("MainActivity2", "Invalid password, setting error1 to visible");
                findViewById(R.id.error1_invalid_password).setVisibility(View.VISIBLE);
                findViewById(R.id.create_pass_red).setVisibility(View.VISIBLE);
            }
        }
    };

    private TextWatcher textWatcherPassword2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Log.d("MainActivity2", "password2 beforeTextChanged invoked");
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.d("MainActivity2", "password2 onTextChanged invoked");
            if (nextButton.getAlpha() == 1f) {
                nextButton.setEnabled(false);
                nextButtonTextView.setEnabled(false);
                nextButton.setAlpha(.25f);
            }

            if (String.valueOf(pwd2.getText()).length() == 0 ||
                    String.valueOf(pwd2.getText()).length() < 7 ||
                    findViewById(R.id.create_pass_red).getVisibility() == View.VISIBLE) {
                findViewById(R.id.repeat_pass_green).setVisibility(View.INVISIBLE);
                findViewById(R.id.RP_green_tick).setVisibility(View.INVISIBLE);
                findViewById(R.id.repeat_pswd_red).setVisibility(View.INVISIBLE);
                findViewById(R.id.error2_passwords_dont_match).setVisibility(View.INVISIBLE);
            } else if (String.valueOf(pwd2.getText()).equals(String.valueOf(pwd1.getText())) &&
                    findViewById(R.id.create_pass_green).getVisibility() == View.VISIBLE) {
                findViewById(R.id.repeat_pass_green).setVisibility(View.VISIBLE);
                findViewById(R.id.RP_green_tick).setVisibility(View.VISIBLE);
                findViewById(R.id.repeat_pswd_red).setVisibility(View.INVISIBLE);
                findViewById(R.id.error2_passwords_dont_match).setVisibility(View.INVISIBLE);
            } else {
                findViewById(R.id.repeat_pass_green).setVisibility(View.INVISIBLE);
                findViewById(R.id.RP_green_tick).setVisibility(View.INVISIBLE);
                findViewById(R.id.repeat_pswd_red).setVisibility(View.VISIBLE);
                findViewById(R.id.error2_passwords_dont_match).setVisibility(View.VISIBLE);
            }

            if (findViewById(R.id.email_Green).getVisibility() == View.VISIBLE &&
                    findViewById(R.id.create_pass_green).getVisibility() == View.VISIBLE &&
                    findViewById(R.id.repeat_pass_green).getVisibility() == View.VISIBLE
            ) {
                nextButton.setEnabled(true);
                nextButtonTextView.setEnabled(true);
                nextButton.setAlpha(1f);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.d("MainActivity2", "password2 afterTextChanged invoked");
            if (nextButton.getAlpha() == 1f) {
                nextButton.setEnabled(false);
                nextButtonTextView.setEnabled(false);
                nextButton.setAlpha(.25f);
            }

            if (String.valueOf(pwd2.getText()).length() == 0 ||
                    String.valueOf(pwd2.getText()).length() < 7 ||
                    findViewById(R.id.create_pass_red).getVisibility() == View.VISIBLE) {
                findViewById(R.id.repeat_pass_green).setVisibility(View.INVISIBLE);
                findViewById(R.id.RP_green_tick).setVisibility(View.INVISIBLE);
                findViewById(R.id.repeat_pswd_red).setVisibility(View.INVISIBLE);
                findViewById(R.id.error2_passwords_dont_match).setVisibility(View.INVISIBLE);
            } else if (String.valueOf(pwd2.getText()).equals(String.valueOf(pwd1.getText())) &&
                    findViewById(R.id.create_pass_green).getVisibility() == View.VISIBLE) {
                findViewById(R.id.repeat_pass_green).setVisibility(View.VISIBLE);
                findViewById(R.id.RP_green_tick).setVisibility(View.VISIBLE);
                findViewById(R.id.repeat_pswd_red).setVisibility(View.INVISIBLE);
                findViewById(R.id.error2_passwords_dont_match).setVisibility(View.INVISIBLE);
            } else {
                findViewById(R.id.repeat_pass_green).setVisibility(View.INVISIBLE);
                findViewById(R.id.RP_green_tick).setVisibility(View.INVISIBLE);
                findViewById(R.id.repeat_pswd_red).setVisibility(View.VISIBLE);
                findViewById(R.id.error2_passwords_dont_match).setVisibility(View.VISIBLE);
            }
            if (findViewById(R.id.email_Green).getVisibility() == View.VISIBLE &&
                    findViewById(R.id.create_pass_green).getVisibility() == View.VISIBLE &&
                    findViewById(R.id.repeat_pass_green).getVisibility() == View.VISIBLE
            ) {
                nextButton.setEnabled(true);
                nextButtonTextView.setEnabled(true);
                nextButton.setAlpha(1f);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        email = findViewById(R.id.email);
        pwd1 = findViewById(R.id.createPassword);
        pwd2 = findViewById(R.id.repeatPassword);
        nextButton = findViewById(R.id.nextButton);
        ImageView backButton = findViewById(R.id.back_button);
        nextButtonTextView = findViewById(R.id.nextTextView);
        sharedPreferences = getSharedPreferences("com.example.greenflag", MODE_PRIVATE);
        allKeys = sharedPreferences.getAll().keySet();

        nextButton.setEnabled(false);
        nextButtonTextView.setEnabled(false);
        nextButton.setAlpha(.25f);

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            email.setText("");
            pwd1.setText("");
            pwd2.setText("");
            startActivity(intent);
        });

        nextButton.setOnClickListener(v -> {
            email.setText("");
            pwd1.setText("");
            pwd2.setText("");
            onPause();

            Intent displayUserIntent = new Intent(getBaseContext(), MainActivity3.class);
            startActivity(displayUserIntent);
        });
        nextButtonTextView.setOnClickListener(v -> {
            email.setText("");
            pwd1.setText("");
            pwd2.setText("");
            onPause();

            Intent displayUserIntent = new Intent(getBaseContext(), MainActivity3.class);
            startActivity(displayUserIntent);
        });

        email.addTextChangedListener(textWatcherEmail);
        pwd1.addTextChangedListener(textWatcherPassword1);
        pwd2.addTextChangedListener(textWatcherPassword2);
    }


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
        return String.valueOf(password).length() >= 8 &&
                containsNumber(String.valueOf(password)) &&
                containsUpperCaseChar(String.valueOf(password)) &&
                containsLowerCaseChar(String.valueOf(password));
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity2", "onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity2", "onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity2", "onPause invoked");

        if (findViewById(R.id.email_Green).getVisibility() == View.VISIBLE &&
                findViewById(R.id.create_pass_green).getVisibility() == View.VISIBLE &&
                findViewById(R.id.repeat_pass_green).getVisibility() == View.VISIBLE)
        {
            SharedPreferences.Editor preferencesEditor = sharedPreferences.edit();
            preferencesEditor.putString("email", String.valueOf(email.getText()));
            preferencesEditor.putString("password", String.valueOf(pwd1.getText()));
            preferencesEditor.apply();

            Log.d("MainActivity2", "Information saved");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity2", "onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity2", "onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity2", "onDestroy invoked");
    }
}