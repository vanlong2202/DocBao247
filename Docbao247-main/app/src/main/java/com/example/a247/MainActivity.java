package com.example.a247;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.a247.fragment.MyViewPager2Adapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 pagerMain;
    private BottomNavigationView btnNavigationView;

    BottomNavigationView bottomNavigationView;

    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerMain = findViewById(R.id.view_pager2);
        btnNavigationView = findViewById(R.id.bottom_navigation);

        MyViewPager2Adapter adapter = new MyViewPager2Adapter(this);
        pagerMain.setAdapter(adapter);

        pagerMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        btnNavigationView.getMenu().findItem(R.id.menu_home).setChecked(true);
                        break;
                    case 1:
                        btnNavigationView.getMenu().findItem(R.id.menu_read).setChecked(true);
                        break;
                    case 2:
                        btnNavigationView.getMenu().findItem(R.id.menu_search).setChecked(true);
                        break;
                    case 3:
                        btnNavigationView.getMenu().findItem(R.id.menu_ex).setChecked(true);
                        break;
                }
            }
        });
        btnNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.menu_home){
                    pagerMain.setCurrentItem(0);
                }else if(id == R.id.menu_read){
                    pagerMain.setCurrentItem(1);
                }else if(id == R.id.menu_search){
                    pagerMain.setCurrentItem(2);
                }else if(id == R.id.menu_ex){
                    pagerMain.setCurrentItem(3);
                }
                return true;
            }
        });
        pagerMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        btnNavigationView.getMenu().findItem(R.id.menu_home).setChecked(true);
                        break;
                    case 1:
                        btnNavigationView.getMenu().findItem(R.id.menu_read).setChecked(true);
                        break;
                    case 2:
                        btnNavigationView.getMenu().findItem(R.id.menu_search).setChecked(true);
                        break;
                    case 3:
                        btnNavigationView.getMenu().findItem(R.id.menu_ex).setChecked(true);
                        break;
                }
            }
        });


    }

}