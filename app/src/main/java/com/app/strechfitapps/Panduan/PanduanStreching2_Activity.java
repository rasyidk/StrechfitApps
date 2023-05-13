package com.app.strechfitapps.Panduan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.strechfitapps.R;

public class PanduanStreching2_Activity extends AppCompatActivity {
    Button ps2_bt_next;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan_streching2);

        getSupportActionBar().hide();

        ps2_bt_next =  findViewById(R.id.ps2_bt_next);

        ps2_bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanduanStreching2_Activity.this, PanduanStreching3_Activity.class);
                startActivity(intent);
            }
        });
    }
}