package com.app.strechfitapps.Panduan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.strechfitapps.R;

public class PanduanStreching4_Activity extends AppCompatActivity {

    Button ps4_bt_next;
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan_streching4);

        getSupportActionBar().hide();

        ps4_bt_next =  findViewById(R.id.ps4_bt_next);

        ps4_bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanduanStreching4_Activity.this, PanduanStreching5_Activity.class);
                startActivity(intent);
            }
        });

    }
}