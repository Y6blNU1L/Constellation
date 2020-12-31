package com.hba.xmy.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.hba.xmy.MainActivity;
import com.hba.xmy.R;

public class WelcomeActivity extends AppCompatActivity {
    TextView tv;
    int count =3;
    Handler handler=new Handler(){
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what==1) {
                count--;
                if(count==0){
                    //判断是否第一次进入
                    boolean isFirst= first_pref.getBoolean("isFirst",true);
                    Intent intent=new Intent();
                    if(isFirst){
                        //第一次进入
                        intent.setClass(WelcomeActivity.this, GuideActivity.class);
                        //存储值改为false
                        SharedPreferences.Editor edit=first_pref.edit();
                        edit.putBoolean("isFirst",false);
                        edit.commit();
                    }else{
                        intent.setClass(WelcomeActivity.this, MainActivity.class);
                    }
                    startActivity(intent);
                    finish();
                }else{
                    tv.setText(String.valueOf(count));
                    handler.sendEmptyMessageDelayed(1,500);
                }
            }
        }
    };
    private SharedPreferences first_pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tv=findViewById(R.id.welcomr_tv);
        first_pref = getSharedPreferences("first_pref", MODE_PRIVATE);
        handler.sendEmptyMessageDelayed(1,500);
    }
}