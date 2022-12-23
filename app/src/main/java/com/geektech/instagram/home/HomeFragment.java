package com.geektech.instagram.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.instagram.MainActivity;
import com.geektech.instagram.R;
import com.geektech.instagram.add.AddFragment;
import com.geektech.instagram.model.Post;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
  RecyclerView recyclerView;
  HomeAdapter adapter;
  AddFragment addFragment=new AddFragment();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.home_recycler);
        adapter=new HomeAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setList(((MainActivity)getActivity()).list);
    }
}