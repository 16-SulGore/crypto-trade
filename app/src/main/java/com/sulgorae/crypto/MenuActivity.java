package com.sulgorae.crypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // 타이틀바에 비트코인 아이콘 추가
        getSupportActionBar().setIcon(R.drawable.app_bar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        // 화면을 터치하면 코인 자동매매 화면으로 이동하기 위한 텍스트뷰 클릭 리스너
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(getApplicationContext(), AutoTradeActivity.class);
                startActivity(menuIntent);
            }
        });

        // 화면을 터치하면 K값에 따른 수익률 화면으로 이동하기 위한 텍스트뷰 클릭 리스너
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(getApplicationContext(), K_RatioActivity.class);
                startActivity(menuIntent);
            }
        });

        // 화면을 터치하면 기간에 따른 수익률 화면으로 이동하기 위한 텍스트뷰 클릭 리스너
        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(getApplicationContext(), P_RatioActivity.class);
                startActivity(menuIntent);
            }
        });

        // 화면을 터치하면 코인관련 참고 영상화면으로 이동하기 위한 텍스트뷰 클릭 리스너
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(getApplicationContext(), VideoActivity.class);
                startActivity(menuIntent);
            }
        });
    }
}
