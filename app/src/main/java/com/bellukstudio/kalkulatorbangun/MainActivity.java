package com.bellukstudio.kalkulatorbangun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bellukstudio.kalkulatorbangun.bangunDatar.BangunDatarActivity;
import com.bellukstudio.kalkulatorbangun.bangunRuang.BangunRuangActvity;

public class MainActivity extends AppCompatActivity {

    Button bangunRuang;
    Button bangunDatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bangunDatar = findViewById(R.id.btnbangunDatar);
        bangunRuang = findViewById(R.id.btnBangunRuang);

        // navigate to activity bangun datar
        bangunDatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navToBangunDatar = new Intent(MainActivity.this,BangunDatarActivity.class);
                startActivity(navToBangunDatar);
            }
        });

        //navigate tp activity bangun ruang
        bangunRuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navToBangunRuang = new Intent(MainActivity.this, BangunRuangActvity.class);
                startActivity(navToBangunRuang);
            }
        });
    }
}