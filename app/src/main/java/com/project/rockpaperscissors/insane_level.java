package com.project.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.rockpaperscissors.R.drawable;

import java.util.Arrays;

public class insane_level extends AppCompatActivity
    {
        int pc_score =0;
        int player_score = 0;
        MediaPlayer lose;
        Button scissor_b;
        Button paper_b;
        Button stone_b;
        @Override
        protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                setContentView(R.layout.activity_insane_level);

                stone_b = findViewById(R.id.stone_button);
                paper_b = findViewById(R.id.paper_button);
                scissor_b = findViewById(R.id.scissor_button);
                final ImageView iv_me = findViewById(R.id.iv_me);
                final ImageView iv_cpu = findViewById(R.id.iv_cpu);
                final TextView me_Score = findViewById(R.id.me_score);
                final Button back = findViewById(R.id.back_button);
                final TextView cpu_Score = findViewById(R.id.cpu_score);
                final ImageView iv_bg = findViewById(R.id.iv_bg);
                lose = MediaPlayer.create(this,R.raw.lose);
                final MediaPlayer click_sound = MediaPlayer.create(this,R.raw.b_clik);
                final TranslateAnimation anim = new TranslateAnimation(0f, 0f, 0f, 100f);
                anim.setRepeatCount(Animation.INFINITE);
                anim.setDuration(300);

                back.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                click_sound.start();
                                Intent go_back = new Intent(insane_level.this,select.class);
                                startActivity(go_back);
                                finish();
                            }
                    });

                stone_b.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                paper_b.setClickable(false);
                                stone_b.setClickable(false);
                                scissor_b.setClickable(false);
                                click_sound.start();
                                iv_me.startAnimation(anim);
                                iv_cpu.startAnimation(anim);
                                iv_me.setImageResource(R.drawable.rock);
                                iv_cpu.setImageResource(R.drawable.rock);
                                new Handler().postDelayed(new Runnable()
                                    {
                                        @SuppressLint("SetTextI18n")
                                        @Override
                                        public void run()
                                            {
                                               iv_me.setAnimation(null);
                                               iv_cpu.setAnimation(null);
                                                iv_me.setImageResource(R.drawable.rock);
                                                iv_cpu.setImageResource(R.drawable.paper);
                                                iv_bg.setImageResource(drawable.lose_bg);
                                                pc_score++;
                                                stopper();
                                                paper_b.setClickable(true);
                                                stone_b.setClickable(true);
                                                scissor_b.setClickable(true);
                                                cpu_Score.setText(Integer.toString(pc_score));
                                            }
                                    },700);
                            }
                    });
                paper_b.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                paper_b.setClickable(false);
                                stone_b.setClickable(false);
                                scissor_b.setClickable(false);
                                click_sound.start();
                                iv_me.startAnimation(anim);
                                iv_cpu.startAnimation(anim);
                                iv_me.setImageResource(R.drawable.rock);
                                iv_cpu.setImageResource(R.drawable.rock);
                                new Handler().postDelayed(new Runnable()
                                    {
                                        @SuppressLint("SetTextI18n")
                                        @Override
                                        public void run()
                                            {
                                                iv_me.setAnimation(null);
                                                iv_cpu.setAnimation(null);
                                                iv_me.setImageResource(R.drawable.paper);
                                                iv_cpu.setImageResource(R.drawable.scissors);
                                                pc_score++;
                                                stopper();
                                                paper_b.setClickable(true);
                                                stone_b.setClickable(true);
                                                scissor_b.setClickable(true);
                                                cpu_Score.setText(Integer.toString(pc_score));
                                            }
                                    },700);

                            }
                    });
                scissor_b.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                paper_b.setClickable(false);
                                stone_b.setClickable(false);
                                scissor_b.setClickable(false);
                                click_sound.start();
                                iv_me.startAnimation(anim);
                                iv_cpu.startAnimation(anim);
                                iv_me.setImageResource(R.drawable.rock);
                                iv_cpu.setImageResource(R.drawable.rock);
                                new Handler().postDelayed(new Runnable()
                                    {
                                        @SuppressLint("SetTextI18n")
                                        @Override
                                        public void run()
                                            {
                                                iv_me.setAnimation(null);
                                                iv_cpu.setAnimation(null);
                                                iv_me.setImageResource(R.drawable.scissors);
                                                iv_cpu.setImageResource(R.drawable.rock);
                                                pc_score++;
                                                stopper();
                                                paper_b.setClickable(true);
                                                stone_b.setClickable(true);
                                                scissor_b.setClickable(true);
                                                cpu_Score.setText(Integer.toString(pc_score));
                                            }
                                    },700);

                            }
                    });
            }
        void stopper()
            {
                if (pc_score > 9)
                {
                    pc_score =10;
                    lose.start();
                    paper_b.setClickable(false);
                    stone_b.setClickable(false);
                    scissor_b.setClickable(false);
                    Log.d("THIS HERE IS IF", "IF CALLED");

                }
            }
    }
