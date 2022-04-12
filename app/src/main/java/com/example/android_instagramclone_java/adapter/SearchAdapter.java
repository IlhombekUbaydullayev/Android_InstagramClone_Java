package com.example.android_instagramclone_java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_instagramclone_java.R;
import com.example.android_instagramclone_java.fragments.SearchFragment;
import com.example.android_instagramclone_java.model.User;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;


public class SearchAdapter extends BaseAdapter {
    SearchFragment fragment;
    ArrayList<User> items;

    public SearchAdapter(SearchFragment fragment, ArrayList<User> items) {
        this.fragment = fragment;
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_search,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = items.get(position);

        if (holder instanceof UserViewHolder) {
            ((UserViewHolder) holder).tv_fullname.setText(user.getFullname());
            ((UserViewHolder) holder).tv_email.setText(user.getEmail());
        }
    }

    private static class UserViewHolder extends RecyclerView.ViewHolder {
        public View view;
        ShapeableImageView iv_profile;
        TextView tv_fullname,tv_email,tv_follow;
        public UserViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            iv_profile = view.findViewById(R.id.iv_profile);
            tv_fullname = view.findViewById(R.id.tv_fullname);
            tv_email = view.findViewById(R.id.tv_email);
            tv_follow = view.findViewById(R.id.tv_follow);
        }
    }

}
