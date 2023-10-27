package com.example.fitnessfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class splash extends AppCompatActivity
{
    ImageView iv;
    TextView txt;
    Animation up,down;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        ImageView iv = (ImageView) findViewById(R.id.splash);
        down= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        iv.setAnimation(down);

        TextView txt = (TextView) findViewById(R.id.ff);
        up= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
        txt.setAnimation(up);


        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        },3500);

        Intent i = new Intent(getApplicationContext(), menu.class);
        startActivity(i);

    }
}