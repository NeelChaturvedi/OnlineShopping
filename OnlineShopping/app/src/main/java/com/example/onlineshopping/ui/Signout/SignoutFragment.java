package com.example.onlineshopping.ui.Signout;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.onlineshopping.Activity_Register;
import com.example.onlineshopping.R;

public class SignoutFragment extends Fragment {

    Button LogoutBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_signout, container, false);

        // Initialize the Button
        LogoutBtn = v.findViewById(R.id.LogoutBtn); // Make sure to use the correct ID

        // Set a click listener on the button
        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the new Activity
                Intent intent = new Intent(getActivity(), Activity_Register.class);
                startActivity(intent);

                // Show a toast message for logout success
                Toast.makeText(getActivity(), "Logout successfully", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
