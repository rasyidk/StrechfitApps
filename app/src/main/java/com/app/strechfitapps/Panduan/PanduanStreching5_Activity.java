package com.app.strechfitapps.Panduan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.strechfitapps.R;

public class PanduanStreching5_Activity extends AppCompatActivity {
    Button ps5_bt_next;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan_streching5);

        getSupportActionBar().hide();

        ps5_bt_next =  findViewById(R.id.ps5_bt_next);

        ps5_bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanduanStreching5_Activity.this, PanduanStreching6_Activity.class);
                startActivity(intent);
            }
        });


    }
}