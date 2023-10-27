package com.example.fitnessfriend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class regs extends AppCompatActivity
{
    private static final String TAG = "EmailPasswordActivity";
    TextInputEditText tpas,temm;
    TextView btn_regs;

    FirebaseAuth mAuth;

    ProgressBar pbar;

    TextView lognow;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regs);

        mAuth = FirebaseAuth.getInstance();
        temm = findViewById(R.id.email);
        tpas = findViewById(R.id.pas);
        btn_regs = findViewById(R.id.btn_regs);
        pbar = findViewById(R.id.pbar);
        lognow = findViewById(R.id.lognow);

        btn_regs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pbar.setVisibility(View.VISIBLE);
                String email = temm.getText().toString();
                String password = tpas.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(regs.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(regs.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(regs.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        pbar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(regs.this, "Account Created", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(regs.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
            }
        });




        lognow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });


    }



    private void updateUI(FirebaseUser user)
    {
    }
}
