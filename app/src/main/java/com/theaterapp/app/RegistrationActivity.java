package com.theaterapp.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etFullName, etUsername, etEmail, etPassword;
    private Button btnRegister;

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        dbHelper = new DatabaseHelper(this);

        etFullName = findViewById(R.id.fullname);
        etUsername = findViewById(R.id.Username);
        etEmail = findViewById(R.id.Email);
        etPassword = findViewById(R.id.password);
        btnRegister = findViewById(R.id.registerBtn);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = etFullName.getText().toString().trim();
                String username = etUsername.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (fullname.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean result = dbHelper.newUser(fullname, username, email, password);
                    if (result) {
                        Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        // Handle successful registration, e.g., navigate to login activity
                    } else {
                        Toast.makeText(RegistrationActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        // Handle registration failure
                    }
                }
            }
        });
    }
}
