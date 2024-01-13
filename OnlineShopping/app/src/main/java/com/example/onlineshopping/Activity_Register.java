package com.example.onlineshopping;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Register extends AppCompatActivity {

    TextView LoginRedirect;

    EditText Email, Pwd, ConfirmPwd;
    Button btnRegister;

    DBhelper dbHelper;
    UserDBHelper userInfoDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Email = findViewById(R.id.email);
        Pwd = findViewById(R.id.password);
        ConfirmPwd = findViewById(R.id.confPass);
        btnRegister = findViewById(R.id.RegisterBtn);
        LoginRedirect = findViewById(R.id.LoginRedirectText);

        dbHelper = new DBhelper(this);
        userInfoDB = new UserDBHelper(this);

        LoginRedirect.setOnClickListener(v -> {
            Intent intent = new Intent(Activity_Register.this, Activity_Login.class);
            startActivity(intent);
        });

        btnRegister.setOnClickListener(v -> {
            String user, pwd, rePwd;
            user = Email.getText().toString();
            pwd = Pwd.getText().toString();
            rePwd = ConfirmPwd.getText().toString();

            if (user.equals("") || pwd.equals("") || rePwd.equals("")) {
                Toast.makeText(Activity_Register.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            } else {
                if (pwd.equals(rePwd)) {
                    if (dbHelper.checkUser(user)) {
                        Toast.makeText(Activity_Register.this, "User Already Exists", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    boolean registerSuccess = dbHelper.insertData(user, pwd);
                    if (registerSuccess) {
                        Toast.makeText(Activity_Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Activity_Register.this, UserDataActivity.class);
                        startActivity(intent); // Start UserDataActivity
                    } else {
                        Toast.makeText(Activity_Register.this, "User Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Activity_Register.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

