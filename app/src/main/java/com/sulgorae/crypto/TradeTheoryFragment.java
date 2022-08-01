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
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class TradeTheoryFragment extends Fragment {

    SQLiteDatabase database;
    String databaseName = "Crypto";          //데이터베이스 이름 설정
    String tableName2 = "video_checkbox";   //테이블 이름설정
    TextView test3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_trade_theory, container, false);

        // 데이터베이스 생성 및 Select문 출력
        onDatabaseCreate(rootView);

        // 기법을 딸에게 물려준 전설의 단타 트레이더 래리 월리엄스 유튜브 재생
        ImageView iv1_fg_theory = (ImageView) rootView.findViewById(R.id.iv1_fg_theory);
        iv1_fg_theory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 이벤트 내 Intent를 생성하여 Intent.ACTION_VIEW 액션을 취해준 뒤, Url을 넣어줌
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=TL2-jDLF72o"));
                startActivity(myIntent);
            }
        });

        // 연수익 10000% 휴먼 돈복사기 경기침에 올지 안올지 정리해줌 유튜브 재생
        ImageView iv2_fg_theory = (ImageView) rootView.findViewById(R.id.iv2_fg_theory);
        iv2_fg_theory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 이벤트 내 Intent를 생성하여 Intent.ACTION_VIEW 액션을 취해준 뒤, Url을 넣어줌
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=6dRtzB5kloQ"));
                startActivity(myIntent);
            }
        });

        // 최강 트레이더의 최강 전략 유튜브 재생
        ImageView iv3_fg_theory = (ImageView) rootView.findViewById(R.id.iv3_fg_theory);
        iv3_fg_theory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 이벤트 내 Intent를 생성하여 Intent.ACTION_VIEW 액션을 취해준 뒤, Url을 넣어줌
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=7jGzo3bv7jc"));
                startActivity(myIntent);
            }
        });

        // ------------체크박스 클릭이벤트 (메시지 알림과 상태 DB저장) -------------------------------------------------------
        // 기법을 딸에게 물려준 전설의 단타 트레이더 래리 월리엄스 유튜브 클릭시 이벤트
        CheckBox checkBox1_fg_theory = (CheckBox) rootView.findViewById(R.id.checkBox1_fg_theory);
        checkBox1_fg_theory.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = " 전설의 단타 트레이더 래리";
                String name = "theory1";

                VideoActivity activity = (VideoActivity) getActivity();
                if (((CompoundButton) v).isChecked()) {
                    activity.selectMessage(msg);  // 완료 : "전설의 단타 트레이더 래리" 메시지를 띄움
                    UpdateData(name, 1);
                } else {
                    activity.selectMessage2(msg);  // 취소 : "전설의 단타 트레이더 래리" 메시지를 띄움
                    UpdateData(name, 0);
                }
            }
        });

        // 연수익 10000% 휴먼 돈복사기 경기침에 올지 안올지 정리해줌 유튜브 클릭시 이벤트
        CheckBox checkBox2_fg_theory = (CheckBox) rootView.findViewById(R.id.checkBox2_fg_theory);
        checkBox2_fg_theory.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "연수익 10000% 휴먼 돈복사기";
                String name = "theory2";

                VideoActivity activity = (VideoActivity) getActivity();
                if (((CompoundButton) v).isChecked()) {
                    activity.selectMessage(msg);  // 완료 : "연수익 10000% 휴먼 돈복사기" 메시지를 띄움
                    UpdateData(name, 1);
                } else {
                    activity.selectMessage2(msg);  // 취소 : "연수익 10000% 휴먼 돈복사기" 메시지를 띄움
                    UpdateData(name, 0);
                }
            }
        });

        // 최강 트레이더의 최강 전략 유튜브 재생클릭시 이벤트
        CheckBox checkBox3_fg_theory = (CheckBox) rootView.findViewById(R.id.checkBox3_fg_theory);
        checkBox3_fg_theory.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "최강 트레이더의 최강 전략 ";
                String name = "theory3";

                VideoActivity activity = (VideoActivity) getActivity();
                if (((CompoundButton) v).isChecked()) {
                    activity.selectMessage(msg);  // 완료 : "최강 트레이더의 최강 전략 " 메시지를 띄움
                    UpdateData(name, 1);
                } else {
                    activity.selectMessage2(msg);  // 취소 : "최강 트레이더의 최강 전략 " 메시지를 띄움
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
    // 체크박스 체크 유무를 내부 DB에서 검색하여 출력
    public void selectData(View view, String tableName){
        CheckBox checkBox1_fg_theory = (CheckBox) view.findViewById(R.id.checkBox1_fg_theory);
        CheckBox checkBox2_fg_theory = (CheckBox) view.findViewById(R.id.checkBox2_fg_theory);
        CheckBox checkBox3_fg_theory = (CheckBox) view.findViewById(R.id.checkBox3_fg_theory);

        if (database != null) {
            String sql = "select name, num, chk from " + tableName;
            Cursor cursor = database.rawQuery(sql, null);

            for (int i = 0; i < 8; i++) {
                cursor.moveToNext();//다음 레코드로 넘어간다.// 처음에 커서는 첫번째 커서 위를 가리키고 있어서, 첫 시작에 이걸 적어줘야 첫번째 레코드를 가리킴
                String name = cursor.getString(0);    // columIndex : 속성의 순서를 뜻함
                int num = cursor.getInt(1);
                int chk = cursor.getInt(2);

                // TradeTheoryFragment-----------------------------------------------
                // 기법을 딸에게 물려준 전설의 단타 트레이더 래리 월리엄스 _ 체크박스
                if (num == 5){
                    if(chk == 1)
                        checkBox1_fg_theory.setChecked(true);
                    else
                        checkBox1_fg_theory.setChecked(false);
                }

                // 최강 트레이더의 최강 전략 _ 체크박스
                else if (num == 6){
                    if(chk == 1)
                        checkBox2_fg_theory.setChecked(true);
                    else
                        checkBox2_fg_theory.setChecked(false);
                }

                else if (num == 7){
                    if(chk == 1)
                        checkBox3_fg_theory.setChecked(true);
                    else
                        checkBox3_fg_theory.setChecked(false);
                }
            }
            cursor.close();
        }
    }


}
