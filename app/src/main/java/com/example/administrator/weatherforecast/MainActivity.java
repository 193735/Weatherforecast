package com.example.administrator.weatherforecast;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private LinearLayout linearLayout;
    ViewPager mViewPager;
    ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initfragment();
        getData();
        linearLayout = findViewById(R.id.layout);
        ImageButton imageButton3 = findViewById(R.id.imageButton3);
        mViewPager.addOnPageChangeListener(this);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
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

    private void getData() {
        //设置图片

        View view;
        for (int i=0;i<fragments.size();i++) {


            //创建底部指示器(小圆点)
            view = new View(MainActivity.this);
            view.setBackgroundResource(R.drawable.background);
            view.setEnabled(false);
            //设置宽高
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(30, 30);
            //设置间隔

                layoutParams.leftMargin = 10;

            //添加到LinearLayout
            linearLayout.addView(view);
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        linearLayout.getChildAt(position).setEnabled(false);
        linearLayout.getChildAt(position).setEnabled(true);


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}



