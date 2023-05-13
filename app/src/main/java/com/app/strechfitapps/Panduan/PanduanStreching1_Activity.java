package com.app.strechfitapps.Panduan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.strechfitapps.R;

public class PanduanStreching1_Activity extends AppCompatActivity {

    Button ps1_bt_next;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan_streching1);

        getSupportActionBar().hide();

        ps1_bt_next =  findViewById(R.id.ps1_bt_next);

        ps1_bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanduanStreching1_Activity.this, PanduanStreching2_Activity.class);
                startActivity(intent);
            }
        });
    }
}