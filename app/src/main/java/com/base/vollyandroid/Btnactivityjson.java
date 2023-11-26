package com.base.vollyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Btnactivityjson extends AppCompatActivity {

    Button buttonReso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btnactivityjson);

        buttonReso = findViewById(R.id.buttonReso);

        buttonReso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Btnactivityjson.this,MakingJsonArrayReq.class));
            }
        });
    }
}