package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Second extends Activity {
    private static int SPLASH_SCREEN_TIME_OUT=5000;
    //String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_btn);

        TextView text1 = (TextView)findViewById(R.id.text1);
        TextView text2 = (TextView)findViewById(R.id.text2);
        TextView text3 = (TextView)findViewById(R.id.text3);

        Intent intent1 = getIntent();
        String user = intent1.getStringExtra("Test1");
        String pass = intent1.getStringExtra("Test2");
        String cpass = intent1.getStringExtra("Test3");
        text1.setText(user);
        text2.setText(pass);
        text3.setText(cpass);
//        Toast.makeText(this, "T1"+user, Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),
                        Forth_image_disp.class);
                //Intent is used to switch from one activity to another.

                startActivity(i);
                //invoke the SecondActivity.

                finish();
                //the current activity will get finished.
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }}