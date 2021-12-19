package com.project.rockpaperscissors;

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

import androidx.appcompat.app.AppCompatActivity;

import com.project.rockpaperscissors.R.drawable;

import java.util.Random;

public class normal_level extends AppCompatActivity
    {
        int pc_score =0;
        int player_score = 0;
        String my_c, cpu_c;
        Random r;
        ImageView iv_me;
        ImageView iv_bg;
        ImageView iv_cpu;
        TextView cpu_Score;
        TextView me_Score;
        MediaPlayer win_sound;
        MediaPlayer lose_sound;
        MediaPlayer point;
        @Override
        protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                setContentView(R.layout.activity_insane_level);
                
                r = new Random();
                iv_me = findViewById(R.id.iv_me);
                iv_cpu = findViewById(R.id.iv_cpu);
                iv_bg = findViewById(R.id.iv_bg);
                my_c = "null";
                cpu_c = "null";
                final MediaPlayer click_sound = MediaPlayer.create(this,R.raw.b_clik);
                point = MediaPlayer.create(this,R.raw.point);
                final Button stone_b = findViewById(R.id.stone_button);
                final Button paper_b = findViewById(R.id.paper_button);
                final Button scissor_b = findViewById(R.id.scissor_button);
                final Button back = findViewById(R.id.back_button);
                me_Score = findViewById(R.id.me_score);
                cpu_Score = findViewById(R.id.cpu_score);
                win_sound = MediaPlayer.create(this,R.raw.win);
                lose_sound = MediaPlayer.create(this,R.raw.lose);
                final TranslateAnimation anim = new TranslateAnimation(0f, 0f, 0f, 100f);
                anim.setRepeatCount(Animation.INFINITE);
                anim.setDuration(300);

                back.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                click_sound.start();
                                Intent go_back = new Intent(normal_level.this,select.class);
                                startActivity(go_back);
                                finish();
                            }
                    });

                stone_b.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                click_sound.start();
                                stone_b.setClickable(false);
                                paper_b.setClickable(false);
                                scissor_b.setClickable(false);
                                iv_me.startAnimation(anim);
                                iv_cpu.startAnimation(anim);
                                iv_me.setImageResource(drawable.rock);
                                iv_cpu.setImageResource(drawable.rock);
                                new Handler().postDelayed(new Runnable()
                                    {
                                        @SuppressLint("SetTextI18n")
                                        @Override
                                        public void run()
                                            {
                                               iv_me.setAnimation(null);
                                               iv_cpu.setAnimation(null);
                                                iv_me.setImageResource(drawable.rock);
                                                my_c = "rock";
                                                calc();
                                                stopper();
                                                paper_b.setClickable(true);
                                                scissor_b.setClickable(true);
                                                stone_b.setClickable(true);
                                            }
                                    },700);
                            }
                    });
                paper_b.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                click_sound.start();
                                stone_b.setClickable(false);
                                scissor_b.setClickable(false);
                                paper_b.setClickable(false);
                                iv_me.startAnimation(anim);
                                iv_cpu.startAnimation(anim);
                                iv_me.setImageResource(drawable.rock);
                                iv_cpu.setImageResource(drawable.rock);
                                new Handler().postDelayed(new Runnable()
                                    {
                                        @SuppressLint("SetTextI18n")
                                        @Override
                                        public void run()
                                            {
                                                iv_me.setAnimation(null);
                                                iv_cpu.setAnimation(null);
                                                iv_me.setImageResource(drawable.paper);
                                                my_c = "paper";
                                                calc();
                                                stopper();
                                                paper_b.setClickable(true);
                                                scissor_b.setClickable(true);
                                                stone_b.setClickable(true);
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
                                click_sound.start();
                                paper_b.setClickable(false);
                                stone_b.setClickable(false);
                                scissor_b.setClickable(false);
                                iv_me.startAnimation(anim);
                                iv_cpu.startAnimation(anim);
                                iv_me.setImageResource(drawable.rock);
                                iv_cpu.setImageResource(drawable.rock);
                                new Handler().postDelayed(new Runnable()
                                    {
                                        @SuppressLint("SetTextI18n")
                                        @Override
                                        public void run()
                                            {
                                                iv_me.setAnimation(null);
                                                iv_cpu.setAnimation(null);
                                                iv_me.setImageResource(drawable.scissors);
                                                my_c = "scissor";
                                                calc();
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
        @SuppressLint("SetTextI18n")
        void calc()
            {
                int cpu = r.nextInt(16);
                Log.d("RANDOM",Integer.toString(cpu));
              if(cpu>=0 && cpu <=5)
              {
                cpu_c = "rock";
                  Log.d("RANDOM_if","Rock");
                iv_cpu.setImageResource(drawable.rock);
              }
              else
              {
                  if(cpu>5 && cpu <=10)
                  {
                      cpu_c = "paper";
                      Log.d("RANDOM_if","Paper");
                      iv_cpu.setImageResource(drawable.paper);
                  }
                  else
                  {
                      if(cpu<=15 && cpu>10)
                      {
                          cpu_c="scissor";
                          Log.d("RANDOM_if","Scissor");
                          iv_cpu.setImageResource(drawable.scissors);
                      }
                  }
              }

                Log.d("RANDOM_after_if",cpu_c);
                Log.d("RANDOM_after_if",my_c);

              if(my_c.equals("rock") && cpu_c.equals("rock"))
              {
                  iv_bg.setImageResource(drawable.tie_bg);
              }
              else
              {
                  if(my_c.equals("rock") && cpu_c.equals("paper"))
                  {
                     pc_score++;
                     cpu_Score.setText(Integer.toString(pc_score));
                      Log.d("RANDOM_check","CPU...");
                      iv_bg.setImageResource(drawable.lose_bg);
                  }
                  else
                  {
                      if(my_c.equals("rock") && cpu_c.equals("scissor"))
                      {
                         player_score++;
                         point.start();
                          me_Score.setText(Integer.toString(player_score));
                          Log.d("RANDOM_check","PLAYER...");
                          iv_bg.setImageResource(drawable.win_bg);
                      }
                      else
                      {
                          if(my_c.equals("paper") && cpu_c.equals("rock"))
                          {
                              player_score++;
                              point.start();
                              me_Score.setText(Integer.toString(player_score));
                              Log.d("RANDOM_check","PLAYER...");
                              iv_bg.setImageResource(drawable.win_bg);
                          }
                          else
                          {
                              if(my_c.equals("paper") && cpu_c.equals("paper"))
                              {
                                  Log.d("RANDOM_check","DRAW...");
                                  iv_bg.setImageResource(drawable.tie_bg);
                              }
                              else
                              {
                                  if(my_c.equals("paper") && cpu_c.equals("scissor"))
                                  {
                                     pc_score++;
                                      cpu_Score.setText(Integer.toString(pc_score));
                                      Log.d("RANDOM_check","CPU...");
                                      iv_bg.setImageResource(drawable.lose_bg);
                                  }
                                  else
                                  {
                                      if(my_c.equals("scissor") && cpu_c.equals("rock"))
                                      {
                                          pc_score++;
                                          cpu_Score.setText(Integer.toString(pc_score));
                                          Log.d("RANDOM_check","CPU...");
                                          iv_bg.setImageResource(drawable.lose_bg);

                                      }
                                      else
                                      {
                                          if(my_c.equals("scissor") && cpu_c.equals("paper"))
                                          {
                                             player_score++;
                                             point.start();
                                              me_Score.setText(Integer.toString(player_score));
                                              Log.d("RANDOM_check","PLAYER...");
                                              iv_bg.setImageResource(drawable.win_bg);
                                          }
                                          else
                                          {
                                              if(my_c.equals("scissor") && cpu_c.equals("scissor"))
                                              {
                                                  Log.d("RANDOM_check","DRAW...");
                                                  iv_bg.setImageResource(drawable.tie_bg);
                                              }
                                          }
                                      }
                                  }
                              }
                          }
                      }
                  }
              }
            }
        void stopper()
            {
                if ((pc_score > 9) | (player_score > 9))
                {

                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    if(player_score>9)
                    {
                        player_score = 10;
                      win_sound.start();
                    }
                    if(pc_score>9)
                    {
                        pc_score = 10;
                        lose_sound.start();
                    }
                    Log.d("THIS HERE IS IF", "IF CALLED");
                }
            }
    }
