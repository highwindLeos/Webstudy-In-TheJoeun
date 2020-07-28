package com.tj.tablelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edit1, edit2;
    private Button[] btnNum = new Button[10]; // btnNum0 -> btnNum[0] ~btnNum[9]
    private int[] IDs = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,
                        R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5,
                        R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9};

    private Button btnAdd, btnSub, btnMul, btnDiv, btnReset;
    private TextView textResult;
    private String num1, num2; // 텍스트 에디터에서 넣은 값을 받는 변수
    private int result; // 계산 결과를 뿌림

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.gridlayout);

        edit1 = (EditText)findViewById(R.id.Edit1);
        edit2 = (EditText)findViewById(R.id.Edit2);

        for (int i = 0; i < IDs.length; i++) {
            btnNum[i] = (Button)findViewById(IDs[i]);
        }

        btnAdd = (Button)findViewById(R.id.BtnAdd);
        btnSub = (Button)findViewById(R.id.BtnSub);
        btnMul = (Button)findViewById(R.id.BtnMul);
        btnDiv = (Button)findViewById(R.id.BtnDiv);

        btnReset = (Button)findViewById(R.id.BtnReset);

        textResult = (TextView)findViewById(R.id.TextResult);

        for (int i =0; i < IDs.length; i++) {
            final int idx = i; // inner 객체에 쓰이는  final변수
            btnNum[idx].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edit1.isFocused()) {
                        num1 = edit1.getText().toString() + btnNum[idx].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused()) {
                        num2 = edit2.getText().toString() + btnNum[idx].getText().toString();
                        edit2.setText(num2);
                    }
                }
            });
        } // for end

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("덧셈결과 : " + result);
                return false;
            }
        }); // 더하기

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("빼기 결과 : " + result);
            }
        }); // 빼기

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("곱하기 결과 : " + result);
            }
        }); // 곱하기

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("나누기 결과 : " + result);
            }
        }); // 나누기

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText("");
                edit2.setText("");
                textResult.setText("계산결과 : -");
            }
        }); // 리셋

    }
}
