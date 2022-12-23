package com.geektech.instagram.home;

import android.hardware.lights.LightState;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geektech.instagram.R;
import com.geektech.instagram.model.Post;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    private List<Post> list=new ArrayList<>();

    public void setList(List<Post>list){
        this.list=list;
    notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.item_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
   ImageView profile;
   TextView name;
   ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile=itemView.findViewById(R.id.item_home_image);
            name=itemView.findViewById(R.id.item_home_name);
            image=itemView.findViewById(R.id.home_main_image);
        }
        public void bind(Post post){
           name.setText(post.getName());
            Glide.with(itemView.getContext()).load(post.getProfile()).into(profile);
            Glide.with(itemView.getContext()).load(post.getImage()).into(image);
        }
    }
}
