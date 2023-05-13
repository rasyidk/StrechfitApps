package com.app.strechfitapps.Games;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.strechfitapps.MainActivity;
import com.app.strechfitapps.R;

public class GamesActivity extends AppCompatActivity {
    ImageView img1,img2,img3,img4, img5, img6, imgMain;

    int val = 0;
    int myVal =0;
    int before = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        getSupportActionBar().hide();

        img1 = findViewById(R.id.games_img_games1);
        img2 = findViewById(R.id.games_img_games2);
        img3 = findViewById(R.id.games_img_games3);
        img4 = findViewById(R.id.games_img_games4);
        img5 = findViewById(R.id.games_img_games5);
        img6 = findViewById(R.id.games_img_games6);
        imgMain = findViewById(R.id.games_img_main);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVal = 1;
                checkVal(myVal);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVal =2;
                checkVal(myVal);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVal=3;
                checkVal(myVal);
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVal = 4;
                checkVal(myVal);
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVal = 5;
                checkVal(myVal);
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVal = 6;
                checkVal(myVal);
            }
        });

    }

    private void checkVal(int newVal) {

        int selisih = newVal - val;
        if (val > newVal || selisih != 1){
//            Toast.makeText(this, "GAGAL", Toast.LENGTH_SHORT).show();
            showAlert();

        }else{
//            Toast.makeText(this, "BENER", Toast.LENGTH_SHORT).show();
            val = newVal;
            setMainImage();

        }


    }

    private void showAlert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyCustomTheme);


        final View customLayout = getLayoutInflater().inflate(R.layout.games_alertdialog, null);
        builder.setView(customLayout);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button = customLayout.findViewById(R.id.games_bt_ulangi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GamesActivity.this, InstructionActivity.class );
                startActivity(intent);
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void setMainImage() {
        if (val == 1){
            imgMain.setImageResource(R.drawable.content_games1);
        }else if (val == 2){
            imgMain.setImageResource(R.drawable.content_games2);
        }else if (val == 3){
            imgMain.setImageResource(R.drawable.content_games3);
        }else if (val == 4){
            imgMain.setImageResource(R.drawable.content_games4);
        }else if (val == 5){
            imgMain.setImageResource(R.drawable.content_games5);
            before = 5;
        }else if (val == 6){
            imgMain.setImageResource(R.drawable.content_games6);

            if (before == 5){

                AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyCustomTheme);


                final View customLayout = getLayoutInflater().inflate(R.layout.games_finish, null);
                builder.setView(customLayout);

                @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button = customLayout.findViewById(R.id.games_bt_home);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(GamesActivity.this, MainActivity.class );
                        startActivity(intent);
                    }
                });

                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        }

    }
}