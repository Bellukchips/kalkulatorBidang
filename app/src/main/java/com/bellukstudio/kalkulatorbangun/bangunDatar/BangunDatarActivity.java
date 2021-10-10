package com.bellukstudio.kalkulatorbangun.bangunDatar;

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

import com.bellukstudio.kalkulatorbangun.MainActivity;
import com.bellukstudio.kalkulatorbangun.R;
import com.bellukstudio.kalkulatorbangun.view.CalculateActivity;

public class BangunDatarActivity extends AppCompatActivity {
    private static final String TAG = "DATARACT";
    /// data array
    ListView listView;
    String bangunDatar[] = {
            "Persegi","Segitiga","Lingkaran","Persegi Panjang",
            "Belah Ketupat","Jajar Genjang"
    };
    //adapter
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangun_datar);
        listView = findViewById(R.id.listBangunDatar);
        //instantiate
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_item,bangunDatar);
        //set adapter for listview
        listView.setAdapter(arrayAdapter);

        //on click data item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // get data from listview on item click
                String bidang = (String) ((TextView)view).getText();
                Log.i(TAG,"Click "+bidang);
                //show toast
                Toast.makeText(getApplicationContext(),bidang, Toast.LENGTH_SHORT).show();
                //intent activity
                Intent pilihRumus = new Intent(BangunDatarActivity.this, ListRumusBidangDatar.class);
                //passing value
                pilihRumus.putExtra("namaBidang",bidang);
                startActivity(pilihRumus);
            }
        });
    }
}