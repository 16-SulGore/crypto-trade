package com.sulgorae.crypto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CoinFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_coin, container, false);

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

        return rootView;
    }
}
