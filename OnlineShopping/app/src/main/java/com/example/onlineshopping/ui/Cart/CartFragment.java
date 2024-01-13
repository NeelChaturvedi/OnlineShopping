package com.example.onlineshopping.ui.Cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import com.example.onlineshopping.databinding.FragmentCartBinding;
import com.example.onlineshopping.models.CartItem;
import com.example.onlineshopping.R;

public class CartFragment extends Fragment {


    private ImageView productImg;
    private TextView productTitle;
    private TextView productInfo;
    private TextView productPrice;
    private Button goHomeButton;
    private Button placeOrderButton;

    private NavController navController;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentCartBinding binding = FragmentCartBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstancesState){
        super.onViewCreated(view, savedInstancesState);

        goHomeButton = view.findViewById(R.id.goHome);
        navController = Navigation.findNavController(view);

        productImg = view.findViewById(R.id.productImg);
        productTitle = view.findViewById(R.id.productTag);
        productInfo = view.findViewById(R.id.productInfo);
        productPrice = view.findViewById(R.id.productPrice);

        final CartItem[] cartItem = {CartFragmentArgs.fromBundle(getArguments()).getCartItem()};
        productImg.setImageResource(cartItem[0].getProductImage());
        productTitle.setText(cartItem[0].getProductTitle());
        productInfo.setText(cartItem[0].getProductInfo());
        productPrice.setText(cartItem[0].getProductPrice());


        goHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate back to the HomeFragment using the action defined in your navigation graph
                navController.navigate(R.id.action_nav_cart_to_nav_home);
            }
        });

        placeOrderButton = view.findViewById(R.id.placeOrder);
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear the cartItem data
                cartItem[0] = null;

                // Clear the text from TextViews
                productImg.setImageDrawable(null);
                productTitle.setText("");
                productInfo.setText("");
                productPrice.setText("");

                Toast.makeText(getContext(), "Order Placed Successfully", Toast.LENGTH_SHORT).show();

                placeOrderButton.setVisibility(View.GONE);
            }
        });

    }
}

