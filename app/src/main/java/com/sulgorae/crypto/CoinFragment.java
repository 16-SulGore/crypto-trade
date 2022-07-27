package com.sulgorae.crypto;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CoinFragment extends Fragment {

    SQLiteDatabase database;
    String databaseName = "Crypto";          //데이터베이스 이름 설정
    String tableName2 = "video_checkbox";   //테이블 이름설정

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_coin, container, false);

        onDatabaseCreate(rootView);

        // ------------이미지뷰 클릭이벤트 (유튜브 재생) ---------------------------------------------------------
        // 블록체인 5분 만에 이해하기 유튜브 재생
        ImageView iv1_fg_coin = (ImageView) rootView.findViewById(R.id.iv1_fg_coin);
        iv1_fg_coin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 이벤트 내 Intent를 생성하여 Intent.ACTION_VIEW 액션을 취해준 뒤, Url을 넣어줌
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=BKLfMx5hscI"));
                startActivity(myIntent);
            }
        });

        // 10분만에 이해하는 초보자를 위한 비트코인 원리 유튜브 재생
        ImageView iv2_fg_coin = (ImageView) rootView.findViewById(R.id.iv2_fg_coin);
        iv2_fg_coin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 이벤트 내 Intent를 생성하여 Intent.ACTION_VIEW 액션을 취해준 뒤, Url을 넣어줌
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=5dkaMkcTgNA"));
                startActivity(myIntent);
            }
        });


        // 이더리움은 무엇인가 유튜브 재생
        ImageView iv3_fg_coin = (ImageView) rootView.findViewById(R.id.iv3_fg_coin);
        iv3_fg_coin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 이벤트 내 Intent를 생성하여 Intent.ACTION_VIEW 액션을 취해준 뒤, Url을 넣어줌
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=TApXOy7Phjo"));
                startActivity(myIntent);
            }
        });

        // 4분만에 이해하는 비트코인과 이더리움 차이점 유튜브 재생
        ImageView iv4_fg_coin = (ImageView) rootView.findViewById(R.id.iv4_fg_coin);
        iv4_fg_coin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 이벤트 내 Intent를 생성하여 Intent.ACTION_VIEW 액션을 취해준 뒤, Url을 넣어줌
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=XzKMIkb3zIY"));
                startActivity(myIntent);
            }
        });

        // 왜 비트코인은 '디지털 금' 이더리움은 '인터넷'이라고 하나 유튜브 재생
        ImageView iv5_fg_coin = (ImageView) rootView.findViewById(R.id.iv5_fg_coin);
        iv5_fg_coin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 이벤트 내 Intent를 생성하여 Intent.ACTION_VIEW 액션을 취해준 뒤, Url을 넣어줌
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=zstIsEidt08"));
                startActivity(myIntent);
            }
        });


        // ------------체크박스 클릭이벤트 (메시지 알림과 상태 DB저장) -------------------------------------------------------
        // 블록체인 5분만에 이해하기 유튜브 클릭시 이벤트
        CheckBox checkBox1_fg_coin = (CheckBox) rootView.findViewById(R.id.checkBox1_fg_coin);
        checkBox1_fg_coin.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "블록체인 5분만에 이해하기";
                String name = "coin1";

                VideoActivity activity = (VideoActivity) getActivity();
                if (((CompoundButton) v).isChecked()) {
                    activity.selectMessage(msg);  // 완료 : "블록체인 5분만에 이해하기" 메시지를 띄움
                    UpdateData(name, 1);
                } else {
                    activity.selectMessage2(msg);  // 취소 : "블록체인 5분만에 이해하기" 메시지를 띄움
                    UpdateData(name, 0);
                }
            }
        });

        // 10분만에 이해하는 초보자를 위한 비트코인 원리 유튜브 클릭시 이벤트
        CheckBox checkBox2_fg_coin = (CheckBox) rootView.findViewById(R.id.checkBox2_fg_coin);
        checkBox2_fg_coin.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "초보자를 위한 비트코인 원리";
                String name = "coin2";

                VideoActivity activity = (VideoActivity) getActivity();
                if (((CompoundButton) v).isChecked()) {
                    activity.selectMessage(msg);  // 완료 : "초보자를 위한 비트코인 원리" 메시지를 띄움
                    UpdateData(name, 1);
                } else {
                    activity.selectMessage2(msg);  // 취소 : "초보자를 위한 비트코인 원리" 메시지를 띄움
                    UpdateData(name, 0);
                }
            }
        });

        // 이더리움은 무엇인가 유튜브 클릭시 이벤트
        CheckBox checkBox3_fg_coin = (CheckBox) rootView.findViewById(R.id.checkBox3_fg_coin);
        checkBox3_fg_coin.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "이더리움은 무엇인가";
                String name = "coin3";

                VideoActivity activity = (VideoActivity) getActivity();
                if (((CompoundButton) v).isChecked()) {
                    activity.selectMessage(msg);  // 완료 : "이더리움은 무엇인가" 메시지를 띄움
                    UpdateData(name, 1);
                } else {
                    activity.selectMessage2(msg);  // 취소 : "이더리움은 무엇인가" 메시지를 띄움
                    UpdateData(name, 0);
                }
            }
        });


        // 4분만에 이해하는 비트코인과 이더리움 차이점 유튜브 클릭시 이벤트
        CheckBox checkBox4_fg_coin = (CheckBox) rootView.findViewById(R.id.checkBox4_fg_coin);
        checkBox4_fg_coin.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "비트코인과 이더리움 차이점";
                String name = "coin4";

                VideoActivity activity = (VideoActivity) getActivity();
                if (((CompoundButton) v).isChecked()) {
                    activity.selectMessage(msg);  // 완료 : "비트코인과 이더리움 차이점" 메시지를 띄움
                    UpdateData(name, 1);
                } else {
                    activity.selectMessage2(msg);  // 취소 : "비트코인과 이더리움 차이점" 메시지를 띄움
                    UpdateData(name, 0);
                }
            }
        });


        // 왜 비트코인은 '디지털 금' 이더리움은 '인터넷'이라고 하나 유튜브 재생
        CheckBox checkBox5_fg_coin = (CheckBox) rootView.findViewById(R.id.checkBox5_fg_coin);
        checkBox5_fg_coin.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "비트코인은 '금' 이더리움은 '인터넷'";
                String name = "coin5";

                VideoActivity activity = (VideoActivity) getActivity();
                if (((CompoundButton) v).isChecked()) {
                    activity.selectMessage(msg);  // 완료 : "비트코인은 '금' 이더리움은 '인터넷'" 메시지를 띄움
                    UpdateData(name, 1);
                } else {
                    activity.selectMessage2(msg);  // 취소 : "비트코인은 '금' 이더리움은 '인터넷'" 메시지를 띄움
                    UpdateData(name, 0);
                }
            }
        });

        return rootView;
    }

    // 체크박스 데이터베이스의 생성자
    public void onDatabaseCreate(View view) {
        openDatabase(databaseName);
        createTable(tableName2);
        selectData(view, tableName2);
    }

    // 데이터베이스 호출
    public void openDatabase(String databaseName){
        database = getActivity().openOrCreateDatabase(databaseName, Context.MODE_PRIVATE, null);//보안때문에 요즘은 대부분 PRIVATE사용, SQLiteDatabase객체가 반환됨
    }

    // 체크박스 테이블 생성
    public void createTable(String tableName){
        if(database!= null) {
            String sql = "create table if not exists " + tableName + "(_id integer PRIMARY KEY autoincrement, name text, num integer, chk integer)";
            database.execSQL(sql);
        }
    }

    // 선택한 체크박스의 체크유무에 따라 데이터베이스의 해당 레코드의 체크유무 상태를 수정
    public void UpdateData(String selected_name, Integer chk){
        if(database != null) {
            String sql = "UPDATE video_checkbox SET chk ='" + chk + "'" + "WHERE name='" + selected_name + "'";
            database.execSQL(sql);
        }
    }


    // 체크박스 체크 유무를 내부 DB에서 검색하여 출력력
    public void selectData(View view, String tableName){
        CheckBox checkBox1_fg_coin = (CheckBox) view.findViewById(R.id.checkBox1_fg_coin);
        CheckBox checkBox2_fg_coin = (CheckBox) view.findViewById(R.id.checkBox2_fg_coin) ;
        CheckBox checkBox3_fg_coin = (CheckBox) view.findViewById(R.id.checkBox3_fg_coin) ;
        CheckBox checkBox4_fg_coin = (CheckBox) view.findViewById(R.id.checkBox4_fg_coin) ;
        CheckBox checkBox5_fg_coin = (CheckBox) view.findViewById(R.id.checkBox5_fg_coin) ;

        if (database != null) {
            String sql = "select name, num, chk from " + tableName;
            Cursor cursor = database.rawQuery(sql, null);

            for (int i = 0; i < 5; i++) {
                cursor.moveToNext();//다음 레코드로 넘어간다.        // 처음에 커서는 첫번째 커서 위를 가리키고 있어서, 첫 시작에 이걸 적어줘야 첫번째 레코드를 가리킴
                String name = cursor.getString(0);    // columIndex : 속성의 순서를 뜻함
                int num = cursor.getInt(1);
                int chk = cursor.getInt(2);

                // CoinFragment-----------------------------------------------
                // 블록체인 5분 만에 이해하기 유튜브
                if (num == 0){
                    if(chk == 1)
                        checkBox1_fg_coin.setChecked(true);
                    else
                        checkBox1_fg_coin.setChecked(false);
                }

                else if (num == 1){
                    if(chk == 1)
                        checkBox2_fg_coin.setChecked(true);
                    else
                        checkBox2_fg_coin.setChecked(false);
                }

                else if (num == 2){
                    if(chk == 1)
                        checkBox3_fg_coin.setChecked(true);
                    else
                        checkBox3_fg_coin.setChecked(false);
                }

                else if (num == 3){
                    if(chk == 1)
                        checkBox4_fg_coin.setChecked(true);
                    else
                        checkBox4_fg_coin.setChecked(false);
                }

                else if (num == 4){
                    if(chk == 1)
                        checkBox5_fg_coin.setChecked(true);
                    else
                        checkBox5_fg_coin.setChecked(false);
                }
            }
            cursor.close();
        }
    }
}
