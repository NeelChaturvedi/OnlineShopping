package com.example.onlineshopping;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.models.CartItem;

import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder> {

    private List<CartItem> cartItems;

    public CartItemAdapter(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public CartItemAdapter() {

    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_cart, parent, false);
        return new CartItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder holder, int position) {
        CartItem cartItem = cartItems.get(position);
        holder.cartItemTitle.setText(cartItem.getProductTitle());
        holder.cartItemPrice.setText(cartItem.getProductPrice());

        // Load the item image (You can use a library like Picasso or Glide for image loading)
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView cartItemImage;
        public TextView cartItemTitle;
        public TextView cartItemPrice;

        public CartItemViewHolder(View itemView) {
            super(itemView);
            cartItemImage = itemView.findViewById(R.id.books);
            cartItemTitle = itemView.findViewById(R.id.booktag);
            cartItemPrice = itemView.findViewById(R.id.price);
        }
    }
}

