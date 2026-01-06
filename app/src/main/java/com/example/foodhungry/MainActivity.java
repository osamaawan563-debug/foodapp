package com.example.foodhungry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput;
    private Button loginButton;
    private TextView signupText; // Naya variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        signupText = findViewById(R.id.signupText); // XML mein id 'signupText' honi chahiye

        // 1. Signup Screen par janay ka logic
        signupText.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(intent);
        });

        // 2. Login Logic (Data matching)
        loginButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            // Saved user data nikalna
            SharedPreferences pref = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            String savedEmail = pref.getString("email", "");
            String savedPass = pref.getString("password", "");

            if(email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            } else if(email.equals(savedEmail) && password.equals(savedPass)) {
                // Agar data match kar jaye
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                // Agar data galat ho
                Toast.makeText(this, "Invalid Email or Password!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}