package com.sulgorae.crypto;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {

    TextView tv_video_menu1;               // 사용법 텍스트뷰
    TextView tv_video_menu2;               // 코인정보 텍스트뷰
    TextView tv_video_menu3;               // 매매이론 텍스트뷰
    TextView tv_video_menu4;               // 경제뉴스 텍스트뷰
    TextView tv_video_menu5;               // 뒤로가기 텍스트뷰

    MenualFragment menualFragment;
    CoinFragment coinFragment;
    TradeTheoryFragment tradeTheoryFragment;
    NewsFragment newsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        // 타이틀바에 비트코인 아이콘 추가
        getSupportActionBar().setIcon(R.drawable.app_bar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        menualFragment = new MenualFragment();
        coinFragment = new CoinFragment();
        tradeTheoryFragment = new TradeTheoryFragment();
        newsFragment = new NewsFragment();

        tv_video_menu1 = (TextView) findViewById((R.id.tv_video_menu1));   // 사용법 텍스트뷰
        tv_video_menu2 = (TextView) findViewById((R.id.tv_video_menu2));   // 코인정보 텍스트뷰
        tv_video_menu3 = (TextView) findViewById((R.id.tv_video_menu3));   // 매매이론 텍스트뷰
        tv_video_menu4 = (TextView) findViewById((R.id.tv_video_menu4));   // 경제뉴스 텍스트뷰
        tv_video_menu5 = (TextView) findViewById((R.id.tv_video_menu5));   // 뒤로가기 텍스트뷰

        // 참고영상 Activity에 접근했을 때 디폴트값
        tv_video_menu1.setBackgroundColor(Color.parseColor("#4CD9E8"));
        getSupportFragmentManager().beginTransaction().replace(R.id.container3,menualFragment ).commit();


        // 사용법 동영상 리스트가 나오게 하는 이미지 버튼클릭 리스너
        tv_video_menu1 = (TextView) findViewById(R.id.tv_video_menu1);
        tv_video_menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_video_menu1.setBackgroundColor(Color.parseColor("#4CD9E8"));
                tv_video_menu2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu5.setBackgroundColor(Color.parseColor("#FFFFFF"));
                getSupportFragmentManager().beginTransaction().replace(R.id.container3,menualFragment ).commit();
            }
        });

        // 코인정보 동영상 리스트가 나오게 하는 이미지 버튼클릭 리스너
        tv_video_menu2 = (TextView) findViewById(R.id.tv_video_menu2);
        tv_video_menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_video_menu1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu2.setBackgroundColor(Color.parseColor("#4CD9E8"));
                tv_video_menu3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu5.setBackgroundColor(Color.parseColor("#FFFFFF"));
                getSupportFragmentManager().beginTransaction().replace(R.id.container3,coinFragment ).commit();
            }
        });

        // 매매이론 동영상 리스트가 나오게 하는 이미지 버튼클릭 리스너
        tv_video_menu3 = (TextView) findViewById(R.id.tv_video_menu3);
        tv_video_menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_video_menu1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu3.setBackgroundColor(Color.parseColor("#4CD9E8"));
                tv_video_menu4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu5.setBackgroundColor(Color.parseColor("#FFFFFF"));
                getSupportFragmentManager().beginTransaction().replace(R.id.container3,tradeTheoryFragment ).commit();
            }
        });

        // 경제뉴스 동영상 리스트가 나오게 하는 이미지 버튼클릭 리스너
        tv_video_menu4 = (TextView) findViewById(R.id.tv_video_menu4);
        tv_video_menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_video_menu1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu4.setBackgroundColor(Color.parseColor("#4CD9E8"));
                tv_video_menu5.setBackgroundColor(Color.parseColor("#FFFFFF"));
                getSupportFragmentManager().beginTransaction().replace(R.id.container3,newsFragment ).commit();
            }
        });

        // 뒤로 가기
        tv_video_menu5 = (TextView) findViewById(R.id.tv_video_menu5);
        tv_video_menu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_video_menu1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tv_video_menu5.setBackgroundColor(Color.parseColor("#4CD9E8"));
                Intent calendarIntent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(calendarIntent);
            }
        });
    }

    // 꼬일까봐 다른 프로젝트에서 체크박스 체크유무 상태 데이터베이스에 저장하는거 구현하고 있는데
    // 액티비티에서 프래그먼트뷰 제거가 쉽지가 않아서 오늘은 해결하지 못했습니다.. 하루종일 붙잡고 있는데 어렵군요 ㅠㅠ
    // FragmentManager,, 내일 꼭 없애버립니다.. Git 업로드 하루에 한 번 해야 마음이 편해서 푸쉬합니다..
    // 여기는 아마 깔끔할겁니다.. 다른 프로젝트에서 작업을 하고 있기 때문에,,
}