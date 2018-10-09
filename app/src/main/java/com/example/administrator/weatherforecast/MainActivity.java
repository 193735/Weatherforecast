package com.example.administrator.weatherforecast;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager mViewPager;
    ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initfragment();
        mViewPager=findViewById(R.id.view_pager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position==1) {

                  Weather1Fragment fragment = new Weather1Fragment();
                   return fragment;
                }else {

                    Weather2Fragment fragment2 = new Weather2Fragment();
                  return fragment2;
                }
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });


    }

    private void initfragment() {
        fragments.add(new Weather1Fragment());

          fragments.add(new Weather2Fragment());
}




}
