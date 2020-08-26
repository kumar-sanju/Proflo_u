package com.prantae.proflo_u;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.prantae.proflo_u.adapters.CategoriesAdapter;
import com.prantae.proflo_u.adapters.HorizontalAdapter;
import com.prantae.proflo_u.adapters.VerticalAdapter;
import com.prantae.proflo_u.model.CategoriesModel;
import com.prantae.proflo_u.model.HorizontalModel;
import com.prantae.proflo_u.model.VerticalModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;
    NavigationView navigationView;
    RecyclerView myRecyclerView1, myRecyclerView2, categoriesRecycler;
    HorizontalAdapter horizontalAdapter;
    VerticalAdapter verticalAdapter;
    CategoriesAdapter categoriesAdapter;
    LinearLayout contentView;

    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;
    ImageView navigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        myDrawer = findViewById(R.id.myDrawer);
        navigationView = findViewById(R.id.navigationView);
        navigationBar = findViewById(R.id.navigationBar);
        contentView = findViewById(R.id.content);

        navigationDrawer();

//// for navigation
//        myToggle = new ActionBarDrawerToggle(this,myDrawer,R.string.open,R.string.close);
//        myDrawer.addDrawerListener(myToggle);
//        myToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
//        toolBarLayout.setTitle(getTitle());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        myRecyclerView1 = findViewById(R.id.myRecyclerView1);
        myRecyclerView2 = findViewById(R.id.myRecyclerView2);
        categoriesRecycler = findViewById(R.id.categoriesRecycler);
        HorizontalRecyclerView();
        VerticalRecyclerView();
        CategoriesRecyclerView();
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        navigationBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myDrawer.isDrawerVisible(GravityCompat.START)) {
                    myDrawer.closeDrawer(GravityCompat.START);
                } else {
                    myDrawer.openDrawer(GravityCompat.START);
                }
            }
        });
        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {
        myDrawer.setScrimColor(getResources().getColor(R.color.color5));
        myDrawer.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(myDrawer.isDrawerVisible(GravityCompat.START)){
            myDrawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    private void CategoriesRecyclerView() {
        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<CategoriesModel> categoriesModelList = new ArrayList<>();

        categoriesModelList.add(new CategoriesModel(R.drawable.home, "Recycler"));
        categoriesModelList.add(new CategoriesModel(R.drawable.home, "Recycler"));
        categoriesModelList.add(new CategoriesModel(R.drawable.home, "Recycler"));
        categoriesModelList.add(new CategoriesModel(R.drawable.home, "Recycler"));

        categoriesAdapter = new CategoriesAdapter(categoriesModelList);
        categoriesRecycler.setAdapter(categoriesAdapter);

    }

    private void VerticalRecyclerView() {
        myRecyclerView2.setHasFixedSize(true);
        myRecyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<VerticalModel> verticalModelList = new ArrayList<>();

        verticalModelList.add(new VerticalModel("Recycler", R.drawable.home, "we will create three designs of card views using the recycler view"));
        verticalModelList.add(new VerticalModel("Recycler", R.drawable.home, "we will create three designs of card views using the recycler view"));
        verticalModelList.add(new VerticalModel("Recycler", R.drawable.home, "we will create three designs of card views using the recycler view"));
        verticalModelList.add(new VerticalModel("Recycler", R.drawable.home, "we will create three designs of card views using the recycler view"));

        verticalAdapter = new VerticalAdapter(verticalModelList);
        myRecyclerView2.setAdapter(verticalAdapter);

    }

    private void HorizontalRecyclerView() {
        myRecyclerView1.setHasFixedSize(true);
        myRecyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<HorizontalModel> horizontalModelList = new ArrayList<>();

        horizontalModelList.add(new HorizontalModel(R.drawable.home, "Recycler", "we will create three designs of card views using the recycler view"));
        horizontalModelList.add(new HorizontalModel(R.drawable.home, "Recycler", "we will create three designs of card views using the recycler view"));
        horizontalModelList.add(new HorizontalModel(R.drawable.home, "Recycler", "we will create three designs of card views using the recycler view"));
        horizontalModelList.add(new HorizontalModel(R.drawable.home, "Recycler", "we will create three designs of card views using the recycler view"));
        horizontalModelList.add(new HorizontalModel(R.drawable.home, "Recycler", "we will create three designs of card views using the recycler view"));

        horizontalAdapter = new HorizontalAdapter(horizontalModelList);
        myRecyclerView1.setAdapter(horizontalAdapter);

        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});

    }

    // for navigation
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (myToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}