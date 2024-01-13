package com.example.onlineshopping.ui.Account_info;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Account_infoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Account_infoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}