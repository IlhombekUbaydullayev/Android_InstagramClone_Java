package com.example.android_instagramclone_java.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_instagramclone_java.R;
import com.example.android_instagramclone_java.adapter.FavoriteAdapter;
import com.example.android_instagramclone_java.adapter.HomeAdapter;
import com.example.android_instagramclone_java.model.Post;

import java.util.ArrayList;


public class FavoriteFragment extends BaseFragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager((new GridLayoutManager(getActivity(),1)));

        refresfAdapter(loadPosts());
    }

    private ArrayList<Post> loadPosts(){
        ArrayList<Post> items = new ArrayList<>();
        items.add(new Post("https://images.unsplash.com/photo-1649663016279-3fe60e2038ba?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"));
        items.add(new Post("https://images.unsplash.com/photo-1558227576-0f0612e5cf3a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1161&q=80"));
        items.add(new Post("https://images.unsplash.com/photo-1612596551578-9c81c9de1b3f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"));
        return items;
    }

    private void refresfAdapter(ArrayList<Post> items) {
        FavoriteAdapter adapter = new FavoriteAdapter(this,items);
        recyclerView.setAdapter(adapter);
    }

}