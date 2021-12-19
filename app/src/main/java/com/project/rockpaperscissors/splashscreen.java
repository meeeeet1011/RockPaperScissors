package com.project.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashscreen extends AppCompatActivity
    {

        @Override
        protected void onCreate(Bundle savedInstanceState)
            {
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_splashscreen);
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                        {
                            Intent sps = new Intent(splashscreen.this, MainActivity.class);
                            startActivity(sps);
                        }
                },2000);
                new Handler().postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                            {
                                finish();
                            }
                    },3000);
            }
    }
