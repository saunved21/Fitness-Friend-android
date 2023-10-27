package com.example.fitnessfriend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class menu extends AppCompatActivity
{
    FirebaseAuth auth;
    FirebaseUser user;
    Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        tb = findViewById(R.id.tb);
        setSupportActionBar(tb);
    }

    public void b18(View view) {
        Intent i = new Intent(menu.this, second_act.class);
        startActivity(i);
    }

    public void af18(View view) {
        Intent i = new Intent(menu.this, second_act_2.class);
        startActivity(i);
    }

    public void food(View view) {
        Intent i = new Intent(menu.this, food_act.class);
        startActivity(i);
    }

    public void cardio_(View view) {
        Intent i = new Intent(menu.this, cardio_king.class);
        startActivity(i);
    }
}
