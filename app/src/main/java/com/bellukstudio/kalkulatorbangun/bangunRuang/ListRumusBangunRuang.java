package com.bellukstudio.kalkulatorbangun.bangunRuang;

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

public class ListRumusBangunRuang extends AppCompatActivity {

    String rumus[] = {
            "Luas","Keliling","Volume"
    };
    ListView listView;

    //adapter
    ArrayAdapter<String> arrayAdapter;

    // get passing value from BangunRuangActivity
    Intent intent;
    String namaBidang;
    String rumusBidang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_rumus_bangun_ruang);
        listView = findViewById(R.id.listRumusBangunRuang);
        //instantiate
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_item,rumus);
        listView.setAdapter(arrayAdapter);
        //intent
        intent = getIntent();
        // get data passing value
        namaBidang = intent.getStringExtra("namaBidang");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // get data from listview on item click
                rumusBidang = (String) ((TextView)view).getText();
                if(namaBidang.equalsIgnoreCase("Bola") && rumusBidang.equalsIgnoreCase("Keliling")){
                    Toast.makeText(getApplicationContext(),"Bidang tidak miliki rumus yang anda pilih",Toast.LENGTH_LONG).show();
                }else{
                    //intent activity
                    Intent startCalculate = new Intent(ListRumusBangunRuang.this, CalculateActivity.class);
                    /// passing data
                    startCalculate.putExtra("namaBidang",namaBidang);
                    startCalculate.putExtra("rumusBidang",rumusBidang);
                    startActivity(startCalculate);
                }

            }
        });
    }
}