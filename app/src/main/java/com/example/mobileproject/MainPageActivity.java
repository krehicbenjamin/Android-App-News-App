package com.example.mobileproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainPageActivity extends AppCompatActivity {
    public static final String ARTICLE_EXTRA_ID = "extraid";
    private EditText title, body;
    private ListView listView;
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener );
        viewPager = findViewById(R.id.fragment_container);
        title = findViewById(R.id.title_add);
        body = findViewById(R.id.body_add);

        setUpAdapter(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void setUpAdapter(ViewPager viewPager ){
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT );
        viewPageAdapter.addFragment(new HomeFragment());
        viewPageAdapter.addFragment(new AdminFragment());
       // viewPageAdapter.addFragment(new ProfileFragment());

        viewPager.setAdapter(viewPageAdapter);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Log.d("Debug", "Item clicked" + item.getItemId());
            switch (item.getItemId()){
                case R.id.nav_home:
                    viewPager.setCurrentItem(0);
                    return true;

                case R.id.nav_admin:
                    viewPager.setCurrentItem(1);
                    return true;

               /* case R.id.nav_profile:
                    viewPager.setCurrentItem(2);
                    return true;

                */
                default:
                    return false;
            }
        }
    };
/*
    public void onAdd(View view){
        Articles article = new Articles(title.getText().toString(),body.getText().toString());
        GolazoDatabase.getInstance(this).articleDao().add(article);
        Toast.makeText(this, "Succesfully added a new article", Toast.LENGTH_LONG).show();
    }
*/

}
