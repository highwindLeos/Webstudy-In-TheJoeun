package com.tj.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Sub3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3);

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outintent =  new Intent();
                outintent.putExtra("msg", "From Sub3 Text Massage"); // 특정 데이터를 묶어놓는다.
                setResult(RESULT_OK, outintent); // 응답에 인덴트를 묶어 놓는다.
                finish();
            }
        });
    }
}
