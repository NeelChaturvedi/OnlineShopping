package com.example.onlineshopping.ui.Account_info;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.onlineshopping.R;
import com.example.onlineshopping.User;
import com.example.onlineshopping.UserDBHelper;

public class Account_InfoFragment extends Fragment {

    private TextView nameTextView;
    private TextView contactTextView;
    private TextView emailTextView;
    private TextView addressTextView;
    private TextView dobTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_accountinfo, container, false);

        // Initialize your TextView elements
        nameTextView = root.findViewById(R.id.nameinfo);
        contactTextView = root.findViewById(R.id.contactinfo);
        emailTextView = root.findViewById(R.id.emailinfo);
        addressTextView = root.findViewById(R.id.addressinfo);
        dobTextView = root.findViewById(R.id.DOBinfo);

        // Retrieve user data from UserDBHelper
        UserDBHelper dbHelper = new UserDBHelper(requireContext());
        User user = dbHelper.getUserByEmail("D@123.com");

        // Update the UI with user data
        if (user != null) {
            nameTextView.setText(user.getName());
            contactTextView.setText(user.getContact());
            emailTextView.setText(user.getEmail());
            addressTextView.setText(user.getAddress());
            dobTextView.setText(user.getDob());
        }

        return root;
    }


}
