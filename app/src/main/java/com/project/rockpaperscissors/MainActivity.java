package com.project.rockpaperscissors;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
    {

        @Override
        protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                setContentView(R.layout.activity_main);
                final Button play_b  = findViewById(R.id.play_button);
                final Button exit_b = findViewById(R.id.exit_button);
                final MediaPlayer click_sound = MediaPlayer.create(this,R.raw.click);
                final MediaPlayer bgp = MediaPlayer.create(this,R.raw.bg_m);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                bgp.start();
                bgp.setVolume(0.3f,0.3f);
                bgp.setLooping(true);

                play_b.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                click_sound.start();
                                bgp.stop();
                                Intent sm = new Intent(MainActivity.this, select.class);
                                startActivity(sm);
                            }
                    });
                exit_b.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                click_sound.start();
                                finish();
                                bgp.stop();
                                System.exit(0);
                            }
                    });
                if(!bgp.isPlaying())
                {
                    bgp.start();
                }
            }
    }
