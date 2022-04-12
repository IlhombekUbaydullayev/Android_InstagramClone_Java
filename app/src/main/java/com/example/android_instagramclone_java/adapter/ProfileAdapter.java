package com.example.android_instagramclone_java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_instagramclone_java.R;
import com.example.android_instagramclone_java.fragments.ProfileFragment;
import com.example.android_instagramclone_java.fragments.SearchFragment;
import com.example.android_instagramclone_java.model.Post;
import com.example.android_instagramclone_java.model.User;
import com.example.android_instagramclone_java.utils.Utils;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;


public class ProfileAdapter extends BaseAdapter {
    ProfileFragment fragment;
    ArrayList<Post> items;

    public ProfileAdapter(ProfileFragment fragment, ArrayList<Post> items) {
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
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_profile,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Post post = items.get(position);

        if (holder instanceof PostViewHolder) {
            ShapeableImageView iv_post = ((PostViewHolder) holder).iv_post;

            setViewHeight(iv_post);
            Glide.with(fragment).load(post.getImage()).into(iv_post);
        }
    }

    private static class PostViewHolder extends RecyclerView.ViewHolder {
        public View view;
        ShapeableImageView iv_post;
        TextView tv_caption;
        public PostViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            iv_post = view.findViewById(R.id.iv_post);
            tv_caption = view.findViewById(R.id.tv_caption);
        }
    }

    /**
     * Set ShapeableImageView height as a half of screen width
     * **/

    private void setViewHeight(View view) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = Utils.screenSize(fragment.requireActivity().getApplication()).getWidth() / 2;
        view.setLayoutParams(params);
    }
}
