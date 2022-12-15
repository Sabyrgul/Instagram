package com.geektech.instagram.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.instagram.R;
import com.geektech.instagram.model.Post;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
  RecyclerView recyclerView;
  HomeAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        List <Post> list=new ArrayList<>();
        list.add(new Post("","John",""));
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}