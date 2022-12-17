package com.geektech.instagram.add;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.geektech.instagram.R;
import com.geektech.instagram.model.Post;

import java.util.ArrayList;
import java.util.List;

public class AddFragment extends Fragment {
  Button button;
  ImageView imageView1;
  ImageView imageView2;
  EditText editText;
  List<Post>list=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null){
            if(requestCode==1){
           imageView1.setImageURI(data.getData());}
            else if(requestCode==2){
                imageView2.setImageURI(data.getData());
            }
            }
        }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView1=view.findViewById(R.id.add_image1);
        imageView2=view.findViewById(R.id.add_image2);
        editText=view.findViewById(R.id.add_edittext);
        button=view.findViewById(R.id.btn_add);
        Intent intent=new Intent();
        imageView1.setOnClickListener(view1 -> {
            intent.setAction(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent,1);
        });
        imageView2.setOnClickListener(view12 -> {
            intent.setAction(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent,2);
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            list.add(new Post(Uri.parse(imageView1.toString()),editText.getText().toString(),Uri.parse(imageView2.toString())));
            }
        });
    }

}