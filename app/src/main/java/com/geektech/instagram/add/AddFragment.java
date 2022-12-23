package com.geektech.instagram.add;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.geektech.instagram.MainActivity;
import com.geektech.instagram.R;
import com.geektech.instagram.home.HomeFragment;
import com.geektech.instagram.model.Post;

import java.util.ArrayList;
import java.util.List;

public class AddFragment extends Fragment {
  Button button;
  ImageView imageView1;
  ImageView imageView2;
  EditText editText;
  Uri profileUri;
  Uri imageUri;

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

    public Uri getProfileUri() {
        return profileUri;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView1=view.findViewById(R.id.add_image1);
        imageView2=view.findViewById(R.id.add_image2);
        editText=view.findViewById(R.id.add_edittext);
        button=view.findViewById(R.id.btn_add);

        ActivityResultLauncher<Intent>profilePick=
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {
                  profileUri=result.getData().getData();
            Glide.with(this).load(profileUri).transform(new CenterCrop()
                    ,new RoundedCorners(100)).into(imageView1);
                });
        ActivityResultLauncher<Intent>imagePick=
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {
                   imageUri=result.getData().getData();
                    Glide.with(this).load(imageUri).transform(new CenterCrop()).into(imageView2);
                });

        ActivityResultLauncher<Intent>textPick=
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {
                    result.getData().getData();

                });

        imageView1.setOnClickListener(view1 -> {
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_PICK);
            intent.setType("image/*");
            profilePick.launch(intent);
        });
        imageView2.setOnClickListener(view12 -> {
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_PICK);
            intent.setType("image/*");
            imagePick.launch(intent);
        });
        button.setOnClickListener(view13 -> {
       Post post=new Post(profileUri,editText.getText().toString(),imageUri);
            Toast.makeText(getContext(), "Успешно добавлен", Toast.LENGTH_LONG).show();
       ((MainActivity) getActivity()).list.add(post);
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_view,new HomeFragment())
                    .commit();
        });
    }

}