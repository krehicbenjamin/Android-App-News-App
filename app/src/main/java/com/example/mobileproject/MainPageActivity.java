package com.example.mobileproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainPageActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener );
        viewPager = findViewById(R.id.fragment_container);
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
        listView = findViewById(R.id.list_view_container);
    }

    private void setUpAdapter(ViewPager viewPager ){
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT );
        viewPageAdapter.addFragment(new HomeFragment());
        viewPageAdapter.addFragment(new AdminFragment());
        viewPageAdapter.addFragment(new ProfileFragment());

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

                case R.id.nav_profile:
                    viewPager.setCurrentItem(2);
                    return true;
                default:
                    return false;
            }
        }
    };


}
