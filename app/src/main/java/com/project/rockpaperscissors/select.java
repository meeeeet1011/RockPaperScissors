package com.project.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class select extends AppCompatActivity
    {
        ProgressDialog dialog;
        @Override
        protected void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                setContentView(R.layout.activity_select);
                final Button insane = findViewById(R.id.insane_button);
                final Button normal = findViewById(R.id.normal_button);
                final Button back = findViewById(R.id.back_button);
                final Button mp = findViewById(R.id.mpmode);
                final MediaPlayer click = MediaPlayer.create(this,R.raw.click);

                mp.setVisibility(View.GONE);
                back.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                click.start();
                                Intent go_back = new Intent(select.this,MainActivity.class);
                                startActivity(go_back);
                                finish();
                            }
                    });

                insane.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                click.start();
                                dialog = ProgressDialog.show(select.this, "MAKING COFFEE...", "Please wait...", true);
                                /* dialog.setContentView(R.layout.mk_cofe); */
                                Intent il = new Intent(select.this,insane_level.class);
                                startActivity(il);
                                new Handler().postDelayed(new Runnable()
                                    {
                                        @Override
                                        public void run()
                                            {
                                                dialog.cancel();
                                            }
                                    },2000);
                            }
                    });
                normal.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                click.start();
                                dialog = ProgressDialog.show(select.this, "MAKING PASTA...", "Please wait...", true);
                                Intent nl = new Intent(select.this,normal_level.class);
                                startActivity(nl);
                                new Handler().postDelayed(new Runnable()
                                    {
                                        @Override
                                        public void run()
                                            {
                                                dialog.cancel();
                                            }
                                    },2000);
                            }
                    });
                mp.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                click.start();
                                dialog = ProgressDialog.show(select.this, "MAKING PIZZA...", "Please wait...", true);
                                Intent nl = new Intent(select.this,mp_level.class);
                                startActivity(nl);
                                new Handler().postDelayed(new Runnable()
                                    {
                                        @Override
                                        public void run()
                                            {
                                                dialog.cancel();
                                            }
                                    },2000);
                            }
                    });
            }
    }
