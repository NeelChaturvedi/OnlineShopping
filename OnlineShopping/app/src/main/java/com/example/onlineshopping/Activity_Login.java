package com.example.onlineshopping;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Login extends AppCompatActivity {

    DBhelper dbhelper;
    Button btnLogin;

    TextView SignupRedirect;

    EditText Email, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbhelper = new DBhelper(this);
        Email = findViewById(R.id.loginEmail);
        Password = findViewById(R.id.loginPassword);
        btnLogin = findViewById(R.id.LoginButton);
        SignupRedirect = findViewById(R.id.RegisterRedirectText);

        SignupRedirect.setOnClickListener(v -> {
            Intent intent = new Intent(Activity_Login.this, Activity_Register.class);
            startActivity(intent); // Start ActivityRegister
        });

        btnLogin.setOnClickListener(v -> {
            boolean isLoggedId = dbhelper.checkEmailPassword(Email.getText().toString(), Password.getText().toString());
            if (isLoggedId) {
                Intent intent = new Intent(Activity_Login.this, MainActivity.class);
                startActivity(intent); // Start MainActivity on successful login
            } else {
                Toast.makeText(Activity_Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
