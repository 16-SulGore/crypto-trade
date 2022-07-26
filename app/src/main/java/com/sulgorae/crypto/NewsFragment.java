package com.sulgorae.crypto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NewsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_news, container, false);

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


        return rootView;
    }
}
