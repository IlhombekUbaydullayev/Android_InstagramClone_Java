package com.example.android_instagramclone_java.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android_instagramclone_java.R;
import com.example.android_instagramclone_java.adapter.HomeAdapter;
import com.example.android_instagramclone_java.model.Post;

import java.util.ArrayList;


public class HomeFragment extends BaseFragment {

    private HomeFragment.HomeListener listener;
    private RecyclerView recyclerView;
    private ImageView iv_photo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(view);
        return view;
    }

    /*
  onAttach is for communication of Fragments
   */

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof HomeFragment.HomeListener){
            listener = (HomeFragment.HomeListener) context;
        }else{
            throw new RuntimeException("$context must implement UploadListener");
        }
    }

      /*
  onAttach is for communication of Fragments
   */

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager((new GridLayoutManager(getActivity(),1)));

        iv_photo = view.findViewById(R.id.iv_camera);
        iv_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.scrollToUpload();
            }
        });

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
        HomeAdapter adapter = new HomeAdapter(this,items);
        recyclerView.setAdapter(adapter);
    }


     /*
   this interface is created for communication with UploadFragment
     */

    public interface HomeListener{
        void scrollToUpload();
    }
}