package com.app.strechfitapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.app.strechfitapps.Games.InstructionActivity;
import com.app.strechfitapps.Panduan.PanduanStreching1_Activity;

public class MainActivity extends AppCompatActivity {

    CardView cvPanduan,cvGames, cvDashboard, cvQuiz;
    TextView tvRef,tvUsername, tvLogout;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String username = sh.getString("username", "");

        cvDashboard = findViewById(R.id.main_cv_dashboard);
        cvPanduan = findViewById(R.id.main_cv_panduan);
        cvGames =findViewById(R.id.main_cv_games);
        cvQuiz = findViewById(R.id.main_cv_quiz);
        tvLogout = findViewById(R.id.main_tv_logout);

        tvUsername = findViewById(R.id.main_tv_username);

        tvUsername.setText(username);



        cvPanduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PanduanStreching1_Activity.class);
                startActivity(intent);
            }
        });

        cvGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InstructionActivity.class);
                startActivity(intent);
            }
        });

        cvQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://docs.google.com/forms/d/e/1FAIpQLSfThaa5LCrkeEf_aoV5bGg3BwwkINluJw3xasXoxX98f2i17g/viewform?usp=pp_url";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        cvDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://linktr.ee/StrechfitApps1?utm_source=linktree_admin_share";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}