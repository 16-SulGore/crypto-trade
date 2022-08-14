package com.sulgorae.crypto;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

// 기간에 따른 수익률 화면
public class P_RatioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_ratio);

        // 타이틀바에 비트코인 아이콘 추가
        getSupportActionBar().setIcon(R.drawable.app_bar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
}