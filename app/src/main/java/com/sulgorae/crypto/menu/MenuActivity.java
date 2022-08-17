package com.sulgorae.crypto.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.sulgorae.crypto.AutoTradeActivity;
import com.sulgorae.crypto.R;
import com.sulgorae.crypto.VideoActivity;
import com.sulgorae.crypto.di.Injection;
import com.sulgorae.crypto.di.ViewModelFactory;
import com.sulgorae.crypto.ratio.RatioActivity;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    SQLiteDatabase database;
    String databaseName = "Crypto";   //데이터베이스 이름 설정
    String tableName = "crypto";     //테이블 이름설정

    EditText editText;
    TextView textview11;

    ImageView imageView2;                                           // 코인 이미지
    ArrayList<Drawable> drawableList = new ArrayList<>();           // drawable객체를 저장하기 위한 배열
    Handler handler = new Handler();                                // 메인스레드에 있는 UI에 바로 접근할 수 없어서 핸들러를 사용해서 접근

    MenuViewModel menuViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setViewModel();
        setTotalAccounts();


        // 타이틀바에 비트코인 아이콘 추가
        getSupportActionBar().setIcon(R.drawable.app_bar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // 코인 애니메이션을 위한 이미지 뷰
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        // 코인이 바뀌는 애니메이션 시작
        startAnimation();



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
        TextView textView6 = findViewById(R.id.textView6);
        textView6.setOnClickListener(view -> {
            Intent menuIntent = new Intent(getApplicationContext(), RatioActivity.class);
            menuIntent.putExtra(RatioActivity.RATIO_TYPE, RatioActivity.RATIO_K);
            startActivity(menuIntent);
        });

        // 화면을 터치하면 기간에 따른 수익률 화면으로 이동하기 위한 텍스트뷰 클릭 리스너
        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setOnClickListener(view -> {
            Intent menuIntent = new Intent(getApplicationContext(), RatioActivity.class);
            menuIntent.putExtra(RatioActivity.RATIO_TYPE, RatioActivity.RATIO_P);
            startActivity(menuIntent);
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

        // 목표 금액을 입력한 후, Done버튼을 누르면 데이터베이스로 값을 전달 (앱을 껐다 켜도 금액 유지를 위함)
        editText = (EditText) findViewById(R.id.editText);                // 목표금액 입력창
        textview11 = (TextView) findViewById(R.id.textView11);            // 목표금액 출력창

        initDB();

        ImageView imageview4 = (ImageView) findViewById(R.id.imageView4); // 목표금액 입력버튼
        imageview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String price = editText.getText().toString();
                UpdateData("goal_price", price);
                selectData(tableName);
                editText.setText("");
                editText.setHint("숫자만 입력");
            }
        });
    }

    private void setViewModel() {
        menuViewModel = new ViewModelProvider(this, new ViewModelFactory(
                Injection.INSTANCE.getExchangeDataSource(),
                Injection.INSTANCE.getQuotationDataSource()
        )).get(MenuViewModel.class);
    }

    // 데이터의 호출
    public void initDB() {
        openDatabase(databaseName);
        createTable(tableName);
        selectData(tableName);

    }

    // 데이터베이스 호출
    public void openDatabase(String databaseName) {
        database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null); //보안때문에 요즘은 대부분 PRIVATE사용, SQLiteDatabase객체가 반환됨
    }

    // crypto 테이블 생성
    public void createTable(String tableName) {
        if (database != null) {
            String sql = "create table if not exists " + tableName + "(_id integer PRIMARY KEY autoincrement, name text, price text)";
            database.execSQL(sql);

            String sql1 = "select name, price from crypto";
            Cursor cursor = database.rawQuery(sql1, null);

            // 데이터베이스에 아직 레코드가 없을 경우에만 목표금액을 저장하기 위한 레코드 하나 삽입
            if (cursor.getCount() == 0) {
                insertData("goal_price", "0");
            }
        }

    }

    // 데이터베이스에 목표잔고 레코드 추가 - 테이블 생성시 최초 1회만 입력
    public void insertData(String name, String price) {
        if (database != null) {
            String sql2 = "insert into crypto(name, price) values(?, ?)";
            Object[] params = {name, price};
            database.execSQL(sql2, params);

        }
    }

    // 데이터베이스에 저장된 목표금액을 텍스트뷰에 출력
    public void selectData(String tableName) {
        if (database != null) {
            String sql = "select name, price from crypto where name =" + "'" + "goal_price" + "'";
            Cursor cursor = database.rawQuery(sql, null);

            for (int i = 0; i < cursor.getCount(); i++) {        // 테이블에 저장된 레코드가 1개뿐이라서 반복문 필요없음. 1회전 후 종료
                cursor.moveToNext();//다음 레코드로 넘어간다.        // 처음에 커서는 첫번째 커서 위를 가리키고 있어서, 첫 시작에 이걸 적어줘야 첫번째 레코드를 가리킴
                String name = cursor.getString(0);    // columIndex : 속성의 순서를 뜻함
                String price = cursor.getString(1);

                // string으로 입력받은 값을 숫자로 변환
                int number_price = Integer.parseInt(price);

                // 입력된 금액이 만원이하이면 '원'으로 표시
                if (number_price < 10000) {
                    textview11.setText(price + "원");
                }
                // 입력된 금액이 만원이상 1억원이하이면 '만원'을 표시
                else if (number_price >= 10000 && number_price < 100000000){
                    textview11.setText(price.substring(0, price.length()-4) + "만원");
                }

                // 입력된 금액이 1억원이상이면 '억'을 표시
                else if (number_price >= 100000000 && number_price <= 2000000000) {
                    textview11.setText(price.substring(0, price.length()-8) + "억");
                }
                // 입력된 금액이 10억이상이라면 '10억'으로 고정표시' int값 저장한계, 경고 알림 추가하기
                else {
                    textview11.setText("10억");
                }

            }
            cursor.close();
        }
    }

    // EditText에 새로운 목표금액을 입력하면 데이터베이스의 목표금액도 수정
    public void UpdateData(String selected_name, String price_data){
        if(database != null) {
            String sql = "UPDATE crypto SET price ='" + price_data + "'" + "WHERE name='" + selected_name + "'";
            database.execSQL(sql);
        }

    }

    // 코인 애니메이션 구현
    public void startAnimation() {
        Resources res = getResources();

        drawableList.add(res.getDrawable(R.drawable.crypto1));      // 인덱스 0~4에 drawable객체 5개를 저장
        drawableList.add(res.getDrawable(R.drawable.crypto2));
        drawableList.add(res.getDrawable(R.drawable.crypto3));
        drawableList.add(res.getDrawable(R.drawable.crypto4));
        drawableList.add(res.getDrawable(R.drawable.crypto5));

        AnimThread thread = new AnimThread();
        thread.start();
    }

    private void setTotalAccounts() {
        menuViewModel.getTotalAccount().observe(this, total ->
                Log.i("TOTAL", total.toString())
        );
    }

    class AnimThread extends Thread {
        public void run() {
            for (int i = 0; i < 300; i++) {
                // i를 5로 나눈 나머지에 해당하는 인덱스를 가지는 Drawable을 drawableList에서 가져온다.
                final Drawable drawable = drawableList.get(i%5);
                // handler를 이용하여 imageView에 선택한 Drawable을 imageView에 표현한다.
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView2.setImageDrawable(drawable);
                    }
                });


                try {
                    Thread.sleep(500);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }




}
