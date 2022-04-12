package com.example.android_instagramclone_java.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.android_instagramclone_java.R;
import com.example.android_instagramclone_java.adapter.SearchAdapter;
import com.example.android_instagramclone_java.model.Post;
import com.example.android_instagramclone_java.model.User;

import java.util.ArrayList;

/**
 * In SearchFragment, all registered users can be found by searching keyword and followed.
 * **/

public class SearchFragment extends BaseFragment {

    String TAG = SearchFragment.class.getSimpleName();
    RecyclerView rv_search;
    ArrayList<User> items = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        rv_search = view.findViewById(R.id.rv_search);
        rv_search.setLayoutManager(new GridLayoutManager(getActivity(),1));
        EditText et_search = view.findViewById(R.id.et_search);
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                String keyword = s.toString().trim();
                usersByKeyword(keyword);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        loadUsers();
        refreshAdapter(items);
    }

    private void refreshAdapter(ArrayList<User> items) {
        SearchAdapter adapter = new SearchAdapter(this,items);
        rv_search.setAdapter(adapter);
    }

    private void usersByKeyword(String keyword) {
        if (keyword.isEmpty()) refreshAdapter(items);

        users.clear();

        for (User user : items)
            if (user.getFullname().toLowerCase().startsWith(keyword.toLowerCase()))
                users.add(user);

        refreshAdapter(users);
    }

    private ArrayList<User> loadUsers(){
        items.add(new User("Ilhombek","ubaydullaev1997@gmail.com"));
        items.add(new User("mega343","ubaydullaev1997@gmail.com"));
        items.add(new User("ubaydullaevIlhombek","ubaydullaev1997@gmail.com"));
        items.add(new User("comUzb","ubaydullaev1997@gmail.com"));
        items.add(new User("Murodjon","Murod444@gmail.com"));
        items.add(new User("Said","said344@gmail.com"));
        items.add(new User("begzod","begzod555@gmail.com"));
        items.add(new User("begzod564","begzod666m@gmail.com"));
        return items;
    }
}