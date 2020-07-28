package com.tj.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Sub4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub4);

        Intent inintent = getIntent();
        int num1 = inintent.getIntExtra("num1", 0);
        int num2 = inintent.getIntExtra("num2",0);
        final int sum = num1 + num2;

        Toast.makeText(this,"전달받은 수" + num1 +"+"+num2 +"=" + (num1+num2), Toast.LENGTH_LONG).show();

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outintent = new Intent();
                outintent.putExtra("sum", sum);
                setResult(RESULT_OK, outintent);
                finish();
            }
        });

    }
}
