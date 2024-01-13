package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineshopping.databinding.ActivityUserDataBinding;

public class UserDataActivity extends AppCompatActivity {



    UserDBHelper userDBHelper;
    EditText Name;
    EditText Contact;
    EditText Email;
    EditText Address;
    EditText DOB;
    Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        Name = findViewById(R.id.editTextName);
        Contact = findViewById(R.id.editTextContact);
        Email = findViewById(R.id.editTextEmail);
        Address = findViewById(R.id.editTextAddress);
        DOB = findViewById(R.id.editTextDateOfBirth);
        btnProceed = findViewById(R.id.SubmitButton);

        userDBHelper = new UserDBHelper(this);

        btnProceed.setOnClickListener(v -> {
            String userName, userEmail, userAddress, userDOB, userContact;
            userName = Name.getText().toString();
            userEmail = Email.getText().toString();
            userAddress = Address.getText().toString();
            userDOB = DOB.getText().toString();
            userContact = (Contact.getText().toString());

            if(userName.equals("") || userEmail.equals("") || userAddress.equals("") || userDOB.equals("")){
                Toast.makeText(UserDataActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            }else {
                if (userDBHelper.checkUserinfo(String.valueOf(Name))) {
                    Toast.makeText(UserDataActivity.this, "User Already Exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean registerSuccess = userDBHelper.insertData(userName,userEmail,userAddress,userDOB,userContact);
                if (registerSuccess) {
                    Toast.makeText(UserDataActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UserDataActivity.this, Activity_Login.class);
                    startActivity(intent); // Start UserDataActivity
                } else {
                    Toast.makeText(UserDataActivity.this, "User Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}