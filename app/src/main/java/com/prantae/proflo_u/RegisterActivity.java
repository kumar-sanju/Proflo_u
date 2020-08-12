package com.prantae.proflo_u;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    TextView loginBtn,condition;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginBtn = findViewById(R.id.loginBtn);
        condition = findViewById(R.id.condition);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
//        condition.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PolicyFragment policyFragment = PolicyFragment.newInstance();
//                policyFragment.show(fragmentManager, "fragment_edit_name");
//            }
//        });

    }
}