package com.app.strechfitapps.Panduan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.strechfitapps.R;

public class PanduanStreching6_Activity extends AppCompatActivity {
    Button ps6_bt_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan_streching6);
        getSupportActionBar().hide();

        ps6_bt_next =  findViewById(R.id.ps6_bt_next);

        ps6_bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanduanStreching6_Activity.this, PanduanStrechingVideo_Activity.class);
                startActivity(intent);
            }
        });
    }
}