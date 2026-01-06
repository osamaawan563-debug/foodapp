package com.example.foodhungry;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText regEmail = findViewById(R.id.regEmail);
        EditText regPass = findViewById(R.id.regPassword);
        Button signupBtn = findViewById(R.id.signupButton);

        signupBtn.setOnClickListener(v -> {
            String email = regEmail.getText().toString().trim();
            String pass = regPass.getText().toString().trim();

            if(!email.isEmpty() && !pass.isEmpty()) {
                // Data Save Karna
                SharedPreferences pref = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("email", email);
                editor.putString("password", pass);
                editor.apply();

                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                finish(); // Wapis Login screen par janay ke liye
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}