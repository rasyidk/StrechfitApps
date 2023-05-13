package com.app.strechfitapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.app.strechfitapps.Games.InstructionActivity;
import com.app.strechfitapps.Notification.AlarmReceiver;
import com.app.strechfitapps.Notification.AlarmReceiver2;
import com.app.strechfitapps.Panduan.PanduanStreching1_Activity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    CardView cvPanduan,cvGames, cvDashboard, cvQuiz;
    TextView tvRef,tvUsername, tvLogout;
    private Calendar calendar,calendar2;
    private AlarmManager alarmManager, alarmManager2;
    private PendingIntent pendingIntent, pendingIntent2;


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

        runNotification();



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



    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "foxandroidReminderChannel";
            String description = "Channel For Alarm Manager";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("foxandroid",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }


    }

    private void createNotificationChannel2() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "foxandroidReminderChannel";
            String description = "Channel For Alarm Manager";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("foxandroid2",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }


    }

    private void setAlarm() {

        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, AlarmReceiver.class);

//        pendingIntent = PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_IMMUTABLE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        }
        else
        {
            pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        }

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,pendingIntent);

        Toast.makeText(this, "Alarm 1 set Successfully", Toast.LENGTH_SHORT).show();



    }

    private void setAlarm2() {

        alarmManager2 = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent2 = new Intent(this, AlarmReceiver2.class);

//        pendingIntent2 = PendingIntent.getBroadcast(this,0,intent2, PendingIntent.FLAG_IMMUTABLE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, PendingIntent.FLAG_IMMUTABLE);
        }
        else
        {
            pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, PendingIntent.FLAG_ONE_SHOT);
        }

        alarmManager2.setRepeating(AlarmManager.RTC_WAKEUP,calendar2.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,pendingIntent2);

        Toast.makeText(this, "Alarm 2 set Successfully", Toast.LENGTH_SHORT).show();

    }

    private void runNotification() {

        createNotificationChannel();
        createNotificationChannel2();

        calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,16);
        calendar.set(Calendar.MINUTE,9);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);


        calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.HOUR_OF_DAY,15);
        calendar2.set(Calendar.MINUTE,58);
        calendar2.set(Calendar.SECOND,0);
        calendar2.set(Calendar.MILLISECOND,0);

        setAlarm();
        setAlarm2();
    }



}