package com.example.mylandmark;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class infoActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img_info;
    TextView  txt_info;
    Button    btn_info_back;
    int imgno = 0;
    int imgs[] = {R.drawable.img_1 , R.drawable.img_2,
             R.drawable.img_3,R.drawable.img_4,
             R.drawable.img_5 };
    String txts[] = {"레고랜드 소개","짜릿한 어트랙션","온가족이 함께하는 놀이기구","레고와 함께하는 레고호텔","전세계 레고가 있는 레고 상점"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        img_info = findViewById(R.id.image_info);
        txt_info = findViewById(R.id.txt_info);
        btn_info_back = findViewById(R.id.btn_info_back);

        img_info.setImageResource(imgs[imgno]);
        txt_info.setText(txts[imgno]);

        img_info.setOnClickListener(this);
        btn_info_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_info_back) {

            finish();
        }else if(view.getId() == R.id.image_info){
            imgno = ++imgno % 5;
            img_info.setImageResource(imgs[imgno]);
            txt_info.setText(txts[imgno]);
        }
    }
}