package com.example.android_instagramclone_java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_instagramclone_java.R;
import com.example.android_instagramclone_java.fragments.FavoriteFragment;
import com.example.android_instagramclone_java.fragments.HomeFragment;
import com.example.android_instagramclone_java.model.Post;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class FavoriteAdapter extends BaseAdapter {
    FavoriteFragment fragment;
    ArrayList<Post> items;

    public FavoriteAdapter(FavoriteFragment fragment, ArrayList<Post> items) {
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
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_favorite,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Post post = items.get(position);

        if (holder instanceof PostViewHolder) {
            ShapeableImageView iv_post = ((PostViewHolder) holder).iv_post;


            Glide.with(fragment).load(post.getImage()).into(iv_post);
        }
    }

    private static class PostViewHolder extends RecyclerView.ViewHolder {
        public View view;
        ShapeableImageView iv_profile,iv_post;
        TextView tv_fullname,tv_time,tv_caption;
        ImageView iv_more,iv_like,iv_share;
        public PostViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            iv_profile = view.findViewById(R.id.iv_profile);
            iv_post = view.findViewById(R.id.iv_post);
            tv_fullname = view.findViewById(R.id.tv_fullname);
            tv_time = view.findViewById(R.id.tv_TIMEfullname);
            tv_caption = view.findViewById(R.id.tv_caption);
            iv_more = view.findViewById(R.id.iv_more);
            iv_like = view.findViewById(R.id.iv_like);
            iv_share = view.findViewById(R.id.iv_share);
        }
    }
}
