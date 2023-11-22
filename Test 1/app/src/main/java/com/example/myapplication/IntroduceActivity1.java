package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroduceActivity1 extends AppCompatActivity {

    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce1);
        btn1 = (Button) findViewById(R.id.btn_intro1_ctn);
        btn2 = (Button) findViewById(R.id.btn_intro1_over);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroduceActivity1.this,IntroduceActivity2.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroduceActivity1.this,LoadingActivity.class);
                startActivity(intent);
            }
        });
    }
}