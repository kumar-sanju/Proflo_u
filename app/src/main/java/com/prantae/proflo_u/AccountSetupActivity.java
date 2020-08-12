package com.prantae.proflo_u;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class AccountSetupActivity extends AppCompatActivity {

    ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter ;
    TabLayout tabIndicator;
    int position = 0 ;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    Button save,tvSkip,sendOtp,resendBtn,loginBtn,regBtn,fbBtn,googleBtn;
    Animation btnAnim ;
    EditText age,gender,weight,disease,mobileNo,Name,EmailLogin,EmailRegister,Password;
    TextView show,forgotPw,terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // make the activity on full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // when this activity is about to be launch we need to check if its openened before or not
        setContentView(R.layout.activity_account_setup);

        save = findViewById(R.id.save);
        tabIndicator = findViewById(R.id.tab_indicator);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);
        tvSkip = findViewById(R.id.tv_skip);
        sendOtp = findViewById(R.id.sendOtp);
        resendBtn = findViewById(R.id.resendBtn);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        weight = findViewById(R.id.weight);
        disease = findViewById(R.id.disease);
        mobileNo = findViewById(R.id.mobileNo);
        loginBtn = findViewById(R.id.loginBtn);
        regBtn = findViewById(R.id.regBtn);
        Name = findViewById(R.id.Name);
        EmailLogin = findViewById(R.id.EmailLogin);
        EmailRegister = findViewById(R.id.EmailRegister);
        Password = findViewById(R.id.Password);
        show = findViewById(R.id.show);
        forgotPw = findViewById(R.id.forgotPw);
        fbBtn = findViewById(R.id.fbBtn);
        googleBtn = findViewById(R.id.googleBtn);
        terms = findViewById(R.id.terms);

        // fill list screen
        final List<ScreenItem> mList = new ArrayList<>();
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        mList.add(new ScreenItem("Register",""));
        mList.add(new ScreenItem("LogIn",""));
        mList.add(new ScreenItem("Email is not verified","Verification mail has been sent to your email. If you haven't recieved it press resend.",R.drawable.gmail));
        mList.add(new ScreenItem("Verify mobile number","",R.drawable.number));
        mList.add(new ScreenItem("User details","",R.drawable.save));

        screenPager =findViewById(R.id.screen_viewpager);
        screenPager.setAdapter(introViewPagerAdapter);
        tabIndicator.setupWithViewPager(screenPager);
        screenPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
        };

        colors = colors_temp;

        screenPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (introViewPagerAdapter.getCount() - 1) && position < (colors.length - 1)) {
                    screenPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                } else {
                    screenPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-2) {
                    loadFourthScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-3) {
                    loadThirdScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-4) {
                    loadSecondScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-5) {
                    loadFirstScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainActivity = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(mainActivity);
                finish();
            }
        });
        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenPager.setCurrentItem(mList.size());
            }
        });
    }

    private void loadFirstScreen() {
        resendBtn.setVisibility(View.INVISIBLE);
        loginBtn.setVisibility(View.INVISIBLE);
        regBtn.setVisibility(View.VISIBLE);
        regBtn.setAnimation(btnAnim);
        Name.setVisibility(View.VISIBLE);
        EmailRegister.setVisibility(View.VISIBLE);
        EmailLogin.setVisibility(View.INVISIBLE);
        Password.setVisibility(View.VISIBLE);
        show.setVisibility(View.VISIBLE);
        forgotPw.setVisibility(View.INVISIBLE);
        fbBtn.setVisibility(View.VISIBLE);
        googleBtn.setVisibility(View.VISIBLE);
        terms.setVisibility(View.VISIBLE);
        tvSkip.setVisibility(View.VISIBLE);
    }

    private void loadSecondScreen() {
        resendBtn.setVisibility(View.INVISIBLE);
        loginBtn.setVisibility(View.VISIBLE);
        regBtn.setVisibility(View.INVISIBLE);
        Name.setVisibility(View.INVISIBLE);
        EmailRegister.setVisibility(View.INVISIBLE);
        EmailLogin.setVisibility(View.VISIBLE);
        Password.setVisibility(View.VISIBLE);
        show.setVisibility(View.VISIBLE);
        forgotPw.setVisibility(View.VISIBLE);
        fbBtn.setVisibility(View.VISIBLE);
        googleBtn.setVisibility(View.VISIBLE);
        terms.setVisibility(View.INVISIBLE);
        tvSkip.setVisibility(View.INVISIBLE);
    }

    private void loadThirdScreen() {
        resendBtn.setVisibility(View.VISIBLE);
        tvSkip.setVisibility(View.VISIBLE);

        sendOtp.setVisibility(View.INVISIBLE);
        save.setVisibility(View.INVISIBLE);
        age.setVisibility(View.INVISIBLE);
        gender.setVisibility(View.INVISIBLE);
        weight.setVisibility(View.INVISIBLE);
        disease.setVisibility(View.INVISIBLE);
        mobileNo.setVisibility(View.INVISIBLE);
        loginBtn.setVisibility(View.INVISIBLE);
        regBtn.setVisibility(View.INVISIBLE);
        Name.setVisibility(View.INVISIBLE);
        EmailRegister.setVisibility(View.INVISIBLE);
        EmailLogin.setVisibility(View.INVISIBLE);
        Password.setVisibility(View.INVISIBLE);
        show.setVisibility(View.INVISIBLE);
        forgotPw.setVisibility(View.INVISIBLE);
        fbBtn.setVisibility(View.INVISIBLE);
        googleBtn.setVisibility(View.INVISIBLE);
        terms.setVisibility(View.INVISIBLE);
    }

    private void loadFourthScreen() {
        sendOtp.setVisibility(View.VISIBLE);
        mobileNo.setVisibility(View.VISIBLE);
        resendBtn.setVisibility(View.INVISIBLE);
        tvSkip.setVisibility(View.VISIBLE);
        save.setVisibility(View.INVISIBLE);
        age.setVisibility(View.INVISIBLE);
        gender.setVisibility(View.INVISIBLE);
        weight.setVisibility(View.INVISIBLE);
        disease.setVisibility(View.INVISIBLE);
        resendBtn.setVisibility(View.INVISIBLE);
        loginBtn.setVisibility(View.INVISIBLE);
        regBtn.setVisibility(View.INVISIBLE);
        Name.setVisibility(View.INVISIBLE);
        EmailRegister.setVisibility(View.INVISIBLE);
        EmailLogin.setVisibility(View.INVISIBLE);
        Password.setVisibility(View.INVISIBLE);
        show.setVisibility(View.INVISIBLE);
        forgotPw.setVisibility(View.INVISIBLE);
        fbBtn.setVisibility(View.INVISIBLE);
        googleBtn.setVisibility(View.INVISIBLE);
        terms.setVisibility(View.INVISIBLE);
    }

    private void loaddLastScreen() {
        save.setVisibility(View.VISIBLE);
        age.setVisibility(View.VISIBLE);
        gender.setVisibility(View.VISIBLE);
        weight.setVisibility(View.VISIBLE);
        disease.setVisibility(View.VISIBLE);
        resendBtn.setVisibility(View.INVISIBLE);
        tvSkip.setVisibility(View.VISIBLE);
        sendOtp.setVisibility(View.INVISIBLE);
        mobileNo.setVisibility(View.INVISIBLE);
        resendBtn.setVisibility(View.INVISIBLE);
        loginBtn.setVisibility(View.INVISIBLE);
        regBtn.setVisibility(View.INVISIBLE);
        Name.setVisibility(View.INVISIBLE);
        EmailRegister.setVisibility(View.INVISIBLE);
        EmailLogin.setVisibility(View.INVISIBLE);
        Password.setVisibility(View.INVISIBLE);
        show.setVisibility(View.INVISIBLE);
        forgotPw.setVisibility(View.INVISIBLE);
        fbBtn.setVisibility(View.INVISIBLE);
        googleBtn.setVisibility(View.INVISIBLE);
        terms.setVisibility(View.INVISIBLE);
        // TODO : ADD an animation the getstarted button
        // setup animation
        save.setAnimation(btnAnim);
    }
}