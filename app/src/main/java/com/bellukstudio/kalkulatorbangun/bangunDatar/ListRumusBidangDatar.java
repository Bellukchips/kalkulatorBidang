package com.bellukstudio.kalkulatorbangun.bangunDatar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bellukstudio.kalkulatorbangun.R;
import com.bellukstudio.kalkulatorbangun.view.CalculateActivity;

public class ListRumusBidangDatar extends AppCompatActivity {
    //data array
    String rumus[] = {
            "Luas","Keliling",
    };
    ListView listView;
    //adapter
    ArrayAdapter<String> arrayAdapter;
    //get data from BangunDatarActivity
    Intent intent;
    //
    String namaBidang;
    String rumusBidang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_rumus_bidang_datar);
        listView = findViewById(R.id.listRumusBidangDatar);
        //instantiate
        arrayAdapter = new ArrayAdapter<String>(
                this,R.layout.list_item,rumus
        );
        // set adapter for listview
        listView.setAdapter(arrayAdapter);
        // retrieve data passing value
        intent = getIntent();
        // get data with key name
        namaBidang = intent.getStringExtra("namaBidang");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // get data from listview on item click
                    rumusBidang = (String) ((TextView)view).getText();
                    // intent activity
                    Intent startCalculate = new Intent(ListRumusBidangDatar.this, CalculateActivity.class);
                    //passing value
                    startCalculate.putExtra("namaBidang",namaBidang);
                    startCalculate.putExtra("rumusBidang",rumusBidang);
                    startActivity(startCalculate);


            }
        });
    }
}