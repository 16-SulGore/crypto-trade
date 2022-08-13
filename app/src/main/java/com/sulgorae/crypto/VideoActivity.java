package com.sulgorae.crypto;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sulgorae.crypto.menu.MenuActivity;

public class VideoActivity extends AppCompatActivity {

    SQLiteDatabase database;
    String databaseName = "Crypto";          //데이터베이스 이름 설정
    String tableName2 = "video_checkbox";   //테이블 이름설정

    TextView tv_video_menu1;               // 사용법 텍스트뷰
    TextView tv_video_menu2;               // 코인정보 텍스트뷰
    TextView tv_video_menu3;               // 매매이론 텍스트뷰
    TextView tv_video_menu4;               // 경제뉴스 텍스트뷰
    TextView tv_video_menu5;               // 뒤로가기 텍스트뷰
    TextView test2;

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

        initDB();

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

    // 데이터의 호출 및 초기화
    public void initDB(){
        openDatabase(databaseName);
        createTable(tableName2);
    }

    // 데이터베이스 호출
    public void openDatabase(String databaseName){
        database = openOrCreateDatabase(databaseName, MODE_PRIVATE,null) ; //보안때문에 요즘은 대부분 PRIVATE사용, SQLiteDatabase객체가 반환됨
    }

    // 체크박스 테이블 생성
    public void createTable(String tableName){
        if(database!= null) {
            String sql = "create table if not exists " + tableName + "(_id integer PRIMARY KEY autoincrement, name text, num integer, chk integer)";
            database.execSQL(sql);

            String sql1 = "select name, num, chk from video_checkbox";
            Cursor cursor = database.rawQuery(sql1, null);

            // 데이터베이스에 아직 레코드가 없을 경우에만 목표금액을 저장하기 위한 레코드 하나 삽입
            if (cursor.getCount() == 0) {
                // CoinFragment의 체크박스 레코드들 추가
                insertData("coin1", 0, 0);   // CoinFragment의 첫번째 체크박스 레코드의 상태, (이름, 일련번호, 상태(0:체크x, 1:체크o)
                insertData("coin2", 1, 0);   // CoinFragment의 두번째 체크박스 레코드의 상태, (이름, 일련번호, 상태(0:체크x, 1:체크o)
                insertData("coin3", 2, 0);   // CoinFragment의 세번째 체크박스 레코드의 상태, (이름, 일련번호, 상태(0:체크x, 1:체크o)
                insertData("coin4", 3, 0);   // CoinFragment의 네번째 체크박스 레코드의 상태, (이름, 일련번호, 상태(0:체크x, 1:체크o)
                insertData("coin5", 4, 0);   // CoinFragment의 다섯번째 체크박스 레코드의 상태, (이름, 일련번호, 상태(0:체크x, 1:체크o)

                // TradeTheory 체크박스 레코드들 추가
                insertData("theory1", 5, 0);   // TradeTheoryFragment의 첫번째 체크박스 레코드의 상태, (이름, 일련번호, 상태(0:체크x, 1:체크o)
                insertData("theory2", 6, 0);   // TradeTheoryFragment의 두번째 체크박스 레코드의 상태, (이름, 일련번호, 상태(0:체크x, 1:체크o)
                insertData("theory3", 7, 0);   // TradeTheoryFragment의 세번째 체크박스 레코드의 상태, (이름, 일련번호, 상태(0:체크x, 1:체크o)


                // NewsFragment 체크박스 레코드들 추가
                insertData("news1", 8, 0);   // NewFragment의 첫번째 체크박스 레코드의 상태, (이름, 일련번호, 상태(0:체크x, 1:체크o)
                insertData("news2", 9, 0);   // NewFragment의 두번째 체크박스 레코드의 상태, (이름, 일련번호, 상태(0:체크x, 1:체크o)
                insertData("news3", 10, 0);   // NewFragment의 세번째 체크박스 레코드의 상태, (이름, 일련번호, 상태(0:체크x, 1:체크o)
                insertData("news4", 11, 0);   // NewFragment의 네번째 체크박스 레코드의 상태, (이름, 일련번호, 상태(0:체크x, 1:체크o)
                insertData("news5", 12, 0);   // NewFragment의 다섯번째 체크박스 레코드의 상태, (이름, 일련번호, 상태(0:체크x, 1:체크o)
            }
        }
    }

    // 체크박스 데이터베이스 생성자
    public void onDatabaseCreate(String name, Integer chk) {
        openDatabase(databaseName);
        createTable(tableName2);
        UpdateData(name, chk);
    }

    // 데이터베이스에 체크박스 레코드 추가 - 테이블 생성시 최초 1회만 입력
    public void insertData(String name, Integer num, Integer chk) {
        if (database != null) {
            String sql2 = "insert into video_checkbox(name, num, chk) values(?, ?, ?)";
            Object[] params = {name, num, chk};
            database.execSQL(sql2, params);
        }
    }
    // 선택한 체크박스의 체크유무에 따라 데이터베이스의 해당 레코드의 체크유무 상태를 수정
    public void UpdateData(String selected_name, Integer chk){
        if(database != null) {
            String sql = "UPDATE video_checkbox SET chk ='" + chk + "'" + "WHERE name='" + selected_name + "'";
            database.execSQL(sql);
        }
    }

    // 영상 옆 체크박스를 체크하면, 어떤 영상을 다 보았는지 알려주는 메시지
    public void selectMessage(String name){
        Toast.makeText(getApplicationContext(), "완료 : " + name, Toast.LENGTH_LONG).show();
    }

    // 영상 옆 체크박스를 체크를 해제하면, 해제했다고 알려주는 매시지
    public void selectMessage2(String name){
        Toast.makeText(getApplicationContext(), "취소 : " + name, Toast.LENGTH_LONG).show();
    }

}