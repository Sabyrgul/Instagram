package com.geektech.instagram.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.instagram.R;

public class ProfileFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    public void onProfilePictureListener(View view) {
    }

    public void onLinesClick(View view) {
    }

    public void onAccountClick(View view) {
    }

    public void onAddClick(View view) {
    }

    public void onFollowingsClick(View view) {
    }

    public void onFollowersClick(View view) {
    }
}