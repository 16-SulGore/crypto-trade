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

public class TradeTheoryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_trade_theory, container, false);

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



       return rootView;
    }
}
