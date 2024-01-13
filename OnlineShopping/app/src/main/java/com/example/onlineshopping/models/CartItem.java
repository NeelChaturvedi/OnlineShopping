package com.example.onlineshopping.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class CartItem implements Parcelable{
    private int productImage;
    private String productTitle;
    private String productInfo;
    private String productPrice;

    public CartItem(int productImage, String productTitle, String productInfo, String productPrice) {
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.productInfo = productInfo;
        this.productPrice = productPrice;
    }

    protected CartItem(Parcel in) {
        productImage = in.readInt();
        productTitle = in.readString();
        productInfo = in.readString();
        productPrice = in.readString();
    }

    public static final Creator<CartItem> CREATOR = new Creator<CartItem>() {
        @Override
        public CartItem createFromParcel(Parcel in) {
            return new CartItem(in);
        }

        @Override
        public CartItem[] newArray(int size) {
            return new CartItem[size];
        }
    };

    public int getProductImage() {
        return productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public String getProductPrice() {
        return productPrice;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(productImage);
        dest.writeString(productTitle);
        dest.writeString(productInfo);
        dest.writeString(productPrice);
    }
}
