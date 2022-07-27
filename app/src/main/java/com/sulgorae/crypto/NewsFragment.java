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

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NewsFragment extends Fragment {

    SQLiteDatabase database;
    String databaseName = "Crypto";          //데이터베이스 이름 설정
    String tableName2 = "video_checkbox";   //테이블 이름설정

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_news, container, false);

        // 데이터베이스 생성 및 Select문 출력
        onDatabaseCreate(rootView);

        // 인플레이션 설명 좀 유튜브 재생
        ImageView iv1_fg_news = (ImageView) rootView.findViewById(R.id.iv1_fg_news);
        iv1_fg_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 이벤트 내 Intent를 생성하여 Intent.ACTION_VIEW 액션을 취해준 뒤, Url을 넣어줌
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=fpE3ac_PNMU"));
                startActivity(myIntent);
            }
        });

        // GDP 세계 4위 경제 대국 베네수엘라의 몰락 유튜브 재생
        ImageView iv2_fg_news = (ImageView) rootView.findViewById(R.id.iv2_fg_news);
        iv2_fg_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 이벤트 내 Intent를 생성하여 Intent.ACTION_VIEW 액션을 취해준 뒤, Url을 넣어줌
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=mcrIcJdsiEg"));
                startActivity(myIntent);
            }
        });

        // '스태그플레이션' 완벽정리 유튜브 재생
        ImageView iv3_fg_news = (ImageView) rootView.findViewById(R.id.iv3_fg_news);
        iv3_fg_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 이벤트 내 Intent를 생성하여 Intent.ACTION_VIEW 액션을 취해준 뒤, Url을 넣어줌
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=u4xra-wKFI4"));
                startActivity(myIntent);
            }
        });

        // 전문가가 선택한 미래의 자산가치? 달러, 한화, 금, 비트코인 유튜브 재생
        ImageView iv4_fg_news = (ImageView) rootView.findViewById(R.id.iv4_fg_news);
        iv4_fg_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 이벤트 내 Intent를 생성하여 Intent.ACTION_VIEW 액션을 취해준 뒤, Url을 넣어줌
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=hIeGpb1nUa4"));
                startActivity(myIntent);
            }
        });

        // 중앙은행 디지털 화폐와 스테이블 코인들
        ImageView iv5_fg_news = (ImageView) rootView.findViewById(R.id.iv5_fg_news);
        iv5_fg_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 이벤트 내 Intent를 생성하여 Intent.ACTION_VIEW 액션을 취해준 뒤, Url을 넣어줌
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Ip7bKoaKSjI"));
                startActivity(myIntent);
            }
        });

        // ------------체크박스 클릭이벤트 (메시지 알림과 상태 DB저장) -------------------------------------------------------
        // 인플레이션 설명 좀 유튜브 클릭시 이벤트
        CheckBox checkBox1_fg_news = (CheckBox) rootView.findViewById(R.id.checkBox1_fg_news);
        checkBox1_fg_news.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "인플레이션 설명";
                String name = "news1";

                VideoActivity activity = (VideoActivity) getActivity();
                if (((CompoundButton) v).isChecked()) {
                    activity.selectMessage(msg);  // 완료 : "인플레이션 설명" 메시지를 띄움
                    UpdateData(name, 1);
                } else {
                    activity.selectMessage2(msg);  // 취소 : "인플레이션 설명" 메시지를 띄움
                    UpdateData(name, 0);
                }
            }
        });

        // GDP 세계 4위 경제 대국 베네수엘라 유튜브 클릭시 이벤트
        CheckBox checkBox2_fg_news = (CheckBox) rootView.findViewById(R.id.checkBox2_fg_news);
        checkBox2_fg_news.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "GDP 세계 4위 경제 대국 베네수엘라";
                String name = "news2";

                VideoActivity activity = (VideoActivity) getActivity();
                if (((CompoundButton) v).isChecked()) {
                    activity.selectMessage(msg);  // 완료 : "GDP 세계 4위 경제 대국 베네수엘라" 메시지를 띄움
                    UpdateData(name, 1);
                } else {
                    activity.selectMessage2(msg);  // 취소 : "GDP 세계 4위 경제 대국 베네수엘라" 메시지를 띄움
                    UpdateData(name, 0);
                }
            }
        });

        // '스태그플레이션' 완벽정리 유튜브 클릭시 이벤트
        CheckBox checkBox3_fg_news = (CheckBox) rootView.findViewById(R.id.checkBox3_fg_news);
        checkBox3_fg_news.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "'스태그플레이션' 완벽정리";
                String name = "news3";

                VideoActivity activity = (VideoActivity) getActivity();
                if (((CompoundButton) v).isChecked()) {
                    activity.selectMessage(msg);  // 완료 : "스태그플레이션' 완벽정리" 메시지를 띄움
                    UpdateData(name, 1);
                } else {
                    activity.selectMessage2(msg);  // 취소 : "스태그플레이션' 완벽정리" 메시지를 띄움
                    UpdateData(name, 0);
                }
            }
        });


        // 전문가가 선택한 미래의 자산가치 유튜브 클릭시 이벤트
        CheckBox checkBox4_fg_news = (CheckBox) rootView.findViewById(R.id.checkBox4_fg_news);
        checkBox4_fg_news.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "전문가가 선택한 미래의 자산가치";
                String name = "news4";

                VideoActivity activity = (VideoActivity) getActivity();
                if (((CompoundButton) v).isChecked()) {
                    activity.selectMessage(msg);  // 완료 : "전문가가 선택한 미래의 자산가치" 메시지를 띄움
                    UpdateData(name, 1);
                } else {
                    activity.selectMessage2(msg);  // 취소 : "전문가가 선택한 미래의 자산가치" 메시지를 띄움
                    UpdateData(name, 0);
                }
            }
        });


        // 중앙은행 디지털 화폐와 스테이블 코인들 유튜브 재생
        CheckBox checkBox5_fg_news = (CheckBox) rootView.findViewById(R.id.checkBox5_fg_news);
        checkBox5_fg_news.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "중앙은행 디지털 화폐와 스테이블 코인들";
                String name = "news5";

                VideoActivity activity = (VideoActivity) getActivity();
                if (((CompoundButton) v).isChecked()) {
                    activity.selectMessage(msg);  // 완료 : "중앙은행 디지털 화폐와 스테이블 코인들" 메시지를 띄움
                    UpdateData(name, 1);
                } else {
                    activity.selectMessage2(msg);  // 취소 : "중앙은행 디지털 화폐와 스테이블 코인들" 메시지를 띄움
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
        CheckBox checkBox1_fg_news = (CheckBox) view.findViewById(R.id.checkBox1_fg_news);
        CheckBox checkBox2_fg_news = (CheckBox) view.findViewById(R.id.checkBox2_fg_news) ;
        CheckBox checkBox3_fg_news = (CheckBox) view.findViewById(R.id.checkBox3_fg_news) ;
        CheckBox checkBox4_fg_news = (CheckBox) view.findViewById(R.id.checkBox4_fg_news) ;
        CheckBox checkBox5_fg_news = (CheckBox) view.findViewById(R.id.checkBox5_fg_news) ;

        if (database != null) {
            String sql = "select name, num, chk from " + tableName;
            Cursor cursor = database.rawQuery(sql, null);

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();//다음 레코드로 넘어간다.        // 처음에 커서는 첫번째 커서 위를 가리키고 있어서, 첫 시작에 이걸 적어줘야 첫번째 레코드를 가리킴
                String name = cursor.getString(0);          // columIndex : 속성의 순서를 뜻함
                int num = cursor.getInt(1);
                int chk = cursor.getInt(2);

                // NewsFragment-----------------------------------------------
                // 인플레이션 설명 좀 유튜브 _ 체크박스
                if (num == 8){
                    if(chk == 1)
                        checkBox1_fg_news.setChecked(true);
                    else
                        checkBox1_fg_news.setChecked(false);
                }
                // GDP 세계 4위 경제 대국 베네수엘라의 몰락 유튜브 _ 체크박스
                else if (num == 9){
                    if(chk == 1)
                        checkBox2_fg_news.setChecked(true);
                    else
                        checkBox2_fg_news.setChecked(false);
                }
                // '스태그플레이션' 완벽정리 유튜브 _ 체크박스
                else if (num == 10){
                    if(chk == 1)
                        checkBox3_fg_news.setChecked(true);
                    else
                        checkBox3_fg_news.setChecked(false);
                }
                // 전문가가 선택한 미래의 자산가치 유튜브 _ 체크박스
                else if (num == 11){
                    if(chk == 1)
                        checkBox4_fg_news.setChecked(true);
                    else
                        checkBox4_fg_news.setChecked(false);
                }
                // 중앙은행 디지털 화폐와 스테이블 코인들 유튜브 _ 체크박스
                else if (num == 12){
                    if(chk == 1)
                        checkBox5_fg_news.setChecked(true);
                    else
                        checkBox5_fg_news.setChecked(false);
                }
            }
            cursor.close();
        }
    }
}
