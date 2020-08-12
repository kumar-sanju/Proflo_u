package com.prantae.proflo_u.Onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.prantae.proflo_u.HomeActivity;
import com.prantae.proflo_u.R;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager screenPager;
    OnboardingAdapter onboardingAdapter ;
    TabLayout tabIndicator;
    int position = 0 ;
    Button btnGetStarted;
    Animation btnAnim ;
    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();

        // ini views
        btnGetStarted = findViewById(R.id.btn_get_started);
        tabIndicator = findViewById(R.id.indicator);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);
        skip = findViewById(R.id.skip);

        final List<BoardingScreen> mList = new ArrayList<>();
        mList.add(new BoardingScreen("","",R.drawable.first));
        mList.add(new BoardingScreen("","",R.drawable.second));
        mList.add(new BoardingScreen("","",R.drawable.third));

        screenPager =findViewById(R.id.screen_pager);
        onboardingAdapter = new OnboardingAdapter(this,mList);
        screenPager.setAdapter(onboardingAdapter);

        tabIndicator.setupWithViewPager(screenPager);

        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-1) {
                    loaddLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        // Get Started button click listener
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(mainActivity);
                finish();
            }
        });
        // skip button click listener
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenPager.setCurrentItem(mList.size());
            }
        });
    }

    private void loaddLastScreen() {
        btnGetStarted.setVisibility(View.VISIBLE);
        skip.setVisibility(View.INVISIBLE);

        btnGetStarted.setAnimation(btnAnim);
    }
}
