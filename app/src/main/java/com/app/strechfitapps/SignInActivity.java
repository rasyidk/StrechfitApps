package com.app.strechfitapps;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    Button btMasuk;
    EditText etUsername;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().hide();

        btMasuk = findViewById(R.id.signin_bt_masuk);
        etUsername = findViewById(R.id.signin_et_username);

        btMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username;

                username = etUsername.getText().toString();

                if (username.equals("")){
                    Toast.makeText(SignInActivity.this, "Username tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else  {
                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();

                    // write all the data entered by the user in SharedPreference and apply
                    myEdit.putString("username", username);
                    myEdit.apply();

                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }
            }
        });
    }
}