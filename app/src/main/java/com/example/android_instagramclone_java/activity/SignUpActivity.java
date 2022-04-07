package com.example.android_instagramclone_java.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android_instagramclone_java.R;


public class SignUpActivity extends BaseActivity {
    EditText et_fullName,et_email,et_password,et_cpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initViews();
    }
    private void initViews() {
        et_fullName = findViewById(R.id.et_fullName);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_cpassword = findViewById(R.id.et_cpassword);
        Button b_signup = findViewById(R.id.btn_signup);
        TextView tv_signin = findViewById(R.id.tv_signin);
        b_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tv_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });}
}
