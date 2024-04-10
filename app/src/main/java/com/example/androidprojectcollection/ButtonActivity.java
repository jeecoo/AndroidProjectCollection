package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    Button btnClose;
    Button btnToast;
    Button btnChangeBg;
    Button btnChangeButtonBg;
    Button btnDisappear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        btnClose = (Button) findViewById(R.id.btnClose);
        btnToast = (Button) findViewById(R.id.btnToast);
        btnChangeBg = (Button) findViewById(R.id.btnChangeBg);
        btnChangeButtonBg = (Button) findViewById(R.id.btnChangeButtonBg);
        btnDisappear = (Button) findViewById(R.id.btnDisappear);


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ButtonActivity.this, ReturnButtonActivity.class);
                startActivity(intent1);
            }
        });

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "Hello, I'm John Mark Econar!", Toast.LENGTH_SHORT).show();
            }
        });

        btnChangeBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().getDecorView().setBackgroundColor(Color.BLACK);
            }
        });

        btnChangeButtonBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnChangeButtonBg.setBackgroundColor(Color.RED);
            }
        });

        btnDisappear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDisappear.setVisibility(View.INVISIBLE);
            }
        });

    }
}
