package com.geektech.instagram.home;

import android.hardware.lights.LightState;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.instagram.R;
import com.geektech.instagram.model.Post;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{
    private List<Post> list=new ArrayList<>();
    public void setList(List<Post>list){
        this.list.clear();
        this.list.addAll(list);
    notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
  String  name=list.get(position).getName();
  String profile=list.get(position).getProfile();
  holder.name.setText(name);
  holder.image.setImageURI(Uri.parse(profile));
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
    }
}
