package com.prantae.proflo_u;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Signup2ndScreenActivity extends AppCompatActivity {

    ImageView backBtn,nextBtn;
    Button phone, email;
    TextView signup_title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2nd_screen);

        backBtn = findViewById(R.id.backBtn);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Signup4thScreenActivity.class));
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Signup3rdScreenActivity.class));
            }
        });

    }
}