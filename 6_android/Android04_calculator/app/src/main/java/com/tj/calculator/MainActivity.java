package com.tj.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button[] btnNum = new Button[10];
    private int[] ids = {R.id.Btn0, R.id.Btn1, R.id.Btn2, R.id.Btn3,
                        R.id.Btn4, R.id.Btn5, R.id.Btn6, R.id.Btn7,
                        R.id.Btn8, R.id.Btn9 };

    private Button btnAdd, btnSub, btnMul, btnDiv;
    private Button btnC, btnCE, btnDEL, btnPoint, btnResult;
    private boolean power = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i =0; i < ids.length; i++) {
            btnNum[i] = (Button)findViewById(ids[i]);
        }
        textView = (TextView)findViewById(R.id.TextView);
        btnAdd = (Button)findViewById(R.id.BtnAdd);
        btnSub = (Button)findViewById(R.id.BtnSub);
        btnMul = (Button)findViewById(R.id.BtnMul);
        btnDiv = (Button)findViewById(R.id.BtnDiv);

        btnC = (Button)findViewById(R.id.BtnC);
        btnCE = (Button)findViewById(R.id.BtnCE);
        btnDEL = (Button)findViewById(R.id.BtnDEL);
        btnPoint = (Button)findViewById(R.id.BtnPoint);
        btnResult = (Button)findViewById(R.id.BtnResult);

        findViewById(R.id.BtnPOW).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (power == true){ // 파워가 참이면 on
                    textView.setText("");
                    btnC.setEnabled(false);
                    btnCE.setEnabled(false);
                    btnDEL.setEnabled(false);
                    btnPoint.setEnabled(false);
                    btnResult.setEnabled(false);
                    btnAdd.setEnabled(false);
                    btnSub.setEnabled(false);
                    btnMul.setEnabled(false);
                    btnDiv.setEnabled(false);
                    for(int i = 0; i < ids.length; i++){
                        btnNum[i].setEnabled(false);
                    }
                    power = false;
                } else { // 파워가 거짓이면 false
                    textView.setText("0");
                    btnC.setEnabled(true);
                    btnCE.setEnabled(true);
                    btnDEL.setEnabled(true);
                    btnPoint.setEnabled(true);
                    btnResult.setEnabled(true);
                    btnAdd.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMul.setEnabled(true);
                    btnDiv.setEnabled(true);
                    for(int i = 0; i < ids.length; i++){
                        btnNum[i].setEnabled(true);
                    }
                    power = true;
                }
            }
        });
    }
}
