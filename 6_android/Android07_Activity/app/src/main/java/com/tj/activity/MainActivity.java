package com.tj.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn01, btn02, btn03, btn04;
    private EditText editId, editNum1, editNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn01 = (Button)findViewById(R.id.btn01);
        btn02 = (Button)findViewById(R.id.btn02);
        btn03 = (Button)findViewById(R.id.btn03);
        btn04 = (Button)findViewById(R.id.btn04);

        editId = (EditText)findViewById(R.id.editId);
        editNum1 = (EditText)findViewById(R.id.editNum1);
        editNum2 = (EditText)findViewById(R.id.editNum2);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 단순히 서브1로 가기
                Intent intent = new Intent(getApplicationContext(), Sub1Activity.class);
                startActivity(intent); // 데이터 받을 것이 없을때
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 서브2 로 editId에 입력한 값 보내면서 가기
                Intent intent = new Intent(getApplicationContext(), Sub2Activity.class);
                intent.putExtra("id", editId.getText().toString()); // 값을 보낸다.
                startActivity(intent);
            }
        });

        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 서브3 으로부터 데이터를 받을 예정
                Intent intent = new Intent(getApplicationContext(), Sub3Activity.class);
                startActivityForResult(intent, 103); // 어떤 채널을 열어서 데이터를 받을 수 있다.
            }
        });

        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 서브4 데이터를 보내고 받을 예정
                Intent intent = new Intent(getApplicationContext(), Sub4Activity.class);
                if (!editNum1.getText().toString().equals("") && !editNum2.getText().toString().equals("")) {
                    intent.putExtra("num1", Integer.parseInt(editNum1.getText().toString()));
                    intent.putExtra("num2", Integer.parseInt(editNum2.getText().toString()));
                }
                startActivityForResult(intent, 104);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 103 && resultCode == RESULT_OK){
            String msg = data.getStringExtra("msg");
            Toast.makeText(this,"SUB3으로 부터 받은 메세지 "+msg, Toast.LENGTH_LONG).show();
        } else if (requestCode == 104 && resultCode == RESULT_OK){
            int sum = data.getIntExtra("sum", 0);
            Toast.makeText(this, "합을 구해서 넘어온 값 "+sum, Toast.LENGTH_LONG).show();
        }


    }
}
