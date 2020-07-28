package com.tj.android01_firstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void btn1Clicked(View view){
        Toast.makeText(this,"시작버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
    }

    public void btn2Clicked(View view){
        Toast.makeText(this,"네이버로 갑니다.", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com"));
        startActivity(intent); // 우체통을 안드로이드에게 요청
    }

    public void btn3Clicked(View view){
        Toast.makeText(this,"전화를 겁니다.", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-8695-0977"));
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
