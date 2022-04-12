package com.example.android_instagramclone_java.fragments;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.android_instagramclone_java.R;
import com.example.android_instagramclone_java.activity.MainActivity;
import com.example.android_instagramclone_java.utils.Logger;
import com.example.android_instagramclone_java.utils.Utils;
import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter;

import java.util.ArrayList;

/*
in UploadFragment user can upload a post with poto and caption
 */

public class UploadFragment extends BaseFragment {

    private final String TAG = UploadFragment.class.getSimpleName();
    private UploadListener listener = null;

    private FrameLayout fl_photo;
    private ImageView iv_photo;
    private EditText et_caption;

    Uri pickedPhoto = null;
     ArrayList<Uri> allPhotos = new ArrayList<Uri>();


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upload, container, false);
        initViews(view);
        return view;
    }

     /*
    onAttach is for communication of Fragments
     */

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof UploadListener){
            listener = (UploadListener) context;
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

        FrameLayout fl_view = view.findViewById(R.id.fl_view);
        setViewHeight(fl_view);

        et_caption = view.findViewById(R.id.et_caption);
        fl_photo = view.findViewById(R.id.fl_photo);
        iv_photo = view.findViewById(R.id.iv_photo);

        ImageView iv_close = view.findViewById(R.id.iv_close);
        ImageView iv_pick = view.findViewById(R.id.iv_pick);
        ImageView iv_upload = view.findViewById(R.id.iv_upload);

        iv_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickFishBunPhoto();
            }
        });

        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidePickedPhoto();
            }
        });

        iv_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadNewPost();
            }
        });
    }

    /*
   /set view height as screen width
    */
    private void setViewHeight(View view) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = Utils.screenSize(requireActivity().getApplication()).getWidth();

    }

     /*
    pick photo using fishBun
     */

    private void pickFishBunPhoto(){
        FishBun.with(this)
                .setImageAdapter(new GlideAdapter())
                .setMaxCount(1)
                .setMinCount(1)
                .setSelectedImages(allPhotos)
                .startAlbumWithActivityResultCallback(detailLauncher);
    }

    ActivityResultLauncher<Intent> detailLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        if (result.getData() != null) {
                            allPhotos = result.getData().getParcelableArrayListExtra(FishBun.INTENT_PATH);
                        }
                        pickedPhoto = allPhotos.get(0);
                        showPickedPhoto();
                    }
                }
            }
    );

    private void showPickedPhoto() {
        fl_photo.setVisibility(VISIBLE);
        iv_photo.setImageURI(pickedPhoto);
    }

    private void uploadNewPost() {
        listener.scrollToHome();
        String caption = et_caption.getText().toString().trim();
        if (!caption.isEmpty()&&pickedPhoto != null){
            Logger.d(TAG,caption);
            Logger.d(TAG,pickedPhoto.getPath().toString());
            resetAll();
        }
    }

    private void resetAll() {
        et_caption.getText().clear();
        pickedPhoto = null;
        fl_photo.setVisibility(GONE);
    }

    private void hidePickedPhoto() {
        pickedPhoto = null;
        fl_photo.setVisibility(GONE);
    }

     /*
    /this Interface is created for communication with HomeFragmant
     */

    public interface UploadListener{
        void scrollToHome();
    }
}