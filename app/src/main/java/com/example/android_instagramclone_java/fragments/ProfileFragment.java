package com.example.android_instagramclone_java.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_instagramclone_java.R;
import com.example.android_instagramclone_java.adapter.ProfileAdapter;
import com.example.android_instagramclone_java.model.Post;
import com.example.android_instagramclone_java.utils.Logger;
import com.google.android.material.imageview.ShapeableImageView;
import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter;

import java.util.ArrayList;

public class ProfileFragment extends BaseFragment {

    String TAG = ProfileFragment.class.getSimpleName();
    RecyclerView rv_profile;

    Uri pickedPhoto = null;
    ArrayList<Uri> allPhotos = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        rv_profile = view.findViewById(R.id.rv_profile);
        rv_profile.setLayoutManager(new GridLayoutManager(getActivity(),2));

        ShapeableImageView iv_profile = view.findViewById(R.id.iv_profiles);
                iv_profile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pickFishBunPhoto();
                    }
                });

        refreshAdapter(loadPosts());
    }


    /**
     * Pick photo using FishBun library
     * **/

    private void pickFishBunPhoto() {
        FishBun.with(this)
                .setImageAdapter(new GlideAdapter())
                .setMaxCount(1)
                .setMinCount(1)
                .setSelectedImages(allPhotos)
                .startAlbumWithActivityResultCallback(photoLauncher);
    }

    ActivityResultLauncher<Intent> photoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        if (result.getData() != null) {
                            allPhotos = result.getData().getParcelableArrayListExtra(FishBun.INTENT_PATH);
                        }
                        pickedPhoto = allPhotos.get(0);
                        uploadPickedPhoto();
                    }
                }
            }
    );

    private void uploadPickedPhoto() {
        if (pickedPhoto != null) {
            Logger.d(TAG,pickedPhoto.getPath().toString());
        }
    }

    private void refreshAdapter(ArrayList<Post> items) {
        ProfileAdapter adapter = new ProfileAdapter(this,items);
        rv_profile.setAdapter(adapter);
    }

    private ArrayList<Post> loadPosts() {
        ArrayList<Post> items = new ArrayList<Post>();
        items.add(new Post("https://images.unsplash.com/photo-1649663016279-3fe60e2038ba?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"));
        items.add(new Post("https://images.unsplash.com/photo-1558227576-0f0612e5cf3a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1161&q=80"));
        items.add(new Post("https://images.unsplash.com/photo-1612596551578-9c81c9de1b3f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"));
        return items;
    }

}