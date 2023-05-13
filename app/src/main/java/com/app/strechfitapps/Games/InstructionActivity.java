package com.app.strechfitapps.Games;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.strechfitapps.R;

public class InstructionActivity extends AppCompatActivity {

    Button instruction_bt_next;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        getSupportActionBar().hide();

        instruction_bt_next = findViewById(R.id.instruction_bt_next);

        instruction_bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InstructionActivity.this, GamesActivity.class);
                startActivity(i);
            }
        });


    }
}