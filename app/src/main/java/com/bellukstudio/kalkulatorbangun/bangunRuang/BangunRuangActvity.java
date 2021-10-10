package com.bellukstudio.kalkulatorbangun.bangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bellukstudio.kalkulatorbangun.R;
import com.bellukstudio.kalkulatorbangun.bangunDatar.BangunDatarActivity;
import com.bellukstudio.kalkulatorbangun.view.CalculateActivity;

public class BangunRuangActvity extends AppCompatActivity {

    private static final String TAG = "RUANGACT";
    ListView listView;
    /// list data bangun ruang
    String dataRuang[] = {
            "Kubus","Balok","Tabung","Kerucut","Bola"
    };
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangun_ruang_actvity);
        listView = findViewById(R.id.listBangunRuang);
        //instantiate
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_item,dataRuang);
        //set adapter fot listview
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // get data from listview on item click
                String message = (String) ((TextView)view).getText();
                Log.i(TAG,"Click "+message);
                //toast
                Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
                //intent activity
                Intent pilihRumus = new Intent(BangunRuangActvity.this, ListRumusBangunRuang.class);
                pilihRumus.putExtra("namaBidang",message);
                startActivity(pilihRumus);
            }
        });
    }
}