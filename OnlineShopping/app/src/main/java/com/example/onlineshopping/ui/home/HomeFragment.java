package com.example.onlineshopping.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.onlineshopping.models.CartItem;
import com.example.onlineshopping.R;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment {

    CartItem cartItem;

    ImageView CartIcon1;
    ImageView CartIcon2;

    private NavController navController;

    // ...

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstances){
        super.onViewCreated(view, savedInstances);

        CartIcon1 = view.findViewById(R.id.cartIcon1);
        CartIcon2 = view.findViewById(R.id.cartIcon2);

        navController = Navigation.findNavController(view);

        CartIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartItem = new CartItem(R.drawable.bookimg, "Books", "Latest Books for Everyone", "₹1500");
                NavDirections action = HomeFragmentDirections.actionNavHomeToNavCart(cartItem);
                navController.navigate(action);
            }
        });

        CartIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartItem = new CartItem(R.drawable.clothes, "Clothes", "Brand new clothes ", "₹10000");
                NavDirections action = HomeFragmentDirections.actionNavHomeToNavCart(cartItem);
                navController.navigate(action);
            }
        });


    }



}
