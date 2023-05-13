package com.app.strechfitapps.Panduan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.strechfitapps.R;

public class PanduanStreching3_Activity extends AppCompatActivity {

    Button ps3_bt_next;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan_streching3);

        getSupportActionBar().hide();

        ps3_bt_next =  findViewById(R.id.ps3_bt_next);

        ps3_bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanduanStreching3_Activity.this, PanduanStreching4_Activity.class);
                startActivity(intent);
            }
        });
    }
}