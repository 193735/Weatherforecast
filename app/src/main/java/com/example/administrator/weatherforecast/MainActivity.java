package com.example.administrator.weatherforecast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Weather weather;
    private  Weather2Fragment fragment = new Weather2Fragment();
    private  Weather1Fragment fragment1 = new Weather1Fragment();
    ViewPager mViewPager;
    private static String a;
    ArrayList<Fragment> fragments = new ArrayList<>();
    @BindView(R.id.shuaxin)
    ImageButton shuaxin;
    @BindView(R.id.home)
    ImageButton home;
    @BindView(R.id.location)
    ImageButton location;
    @BindView(R.id.map)
    ImageButton map;
    @BindView(R.id.city_name)
    TextView cityName;
    @BindView(R.id.city_time)
    TextView cityTime;
    @BindView(R.id.city_shidu)
    TextView cityShidu;
    @BindView(R.id.city_fl)
    TextView cityFl;
    //    @BindView(R.id.city_air_quality)
//    TextView cityAirQuality;
    @BindView(R.id.city_air)
    ImageView cityAir;
    @BindView(R.id.city_weather_quality)
    TextView cityWeatherQuality;
    @BindView(R.id.city_wind)
    TextView cityWind;
    @BindView(R.id.city_tem_low)
    TextView cityTemLow;
    @BindView(R.id.city_date)
    TextView cityDate;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.viewGroup)
    LinearLayout viewGroup;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.city_tem_high)
    TextView cityTemHigh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initfragment();
        //getsql();

        SharedPreferences preferences = getSharedPreferences("天气状况", MODE_PRIVATE);
        String s1 = preferences.getString("city", "");
        cityName.setText(s1);

        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 1) {

                    return fragment1;
                } else {

                    return fragment;
                }

            }

            @Override
            public int getCount() {
                return fragments.size();

            }
        });
    }


//    private void getsql() {
//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        if (bundle != null) {
//            City city = (City) bundle.get("city");
//            if (city != null) {
//                a = city.getCity();
//                String b = city.getProvince();
//                Toast.makeText(MainActivity.this, a, Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

    private void initfragment() {
        fragments.add(new Weather1Fragment());
        fragments.add(new Weather2Fragment());
    }


    @OnClick({R.id.shuaxin, R.id.home})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shuaxin:
                RequestBody formBody = new FormBody
                        .Builder()
                        .add("City", (String) cityName.getText())
                        .build();
                Request request1 = new Request.Builder()
                        .url("https://www.apiopen.top/weatherApi")
                        .post(formBody)
                        .build();

                OkHttpClient okHttpClient = new OkHttpClient();
                Call call = okHttpClient.newCall(request1);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String s = response.body().string();
                        String json = s;
                        Gson gson = new Gson();
                        weather = gson.fromJson(json, Weather.class);

                        Bundle bundle =new Bundle();
                        bundle.putSerializable("weather",weather);
                        fragment.setArguments(bundle);


                        //今天
                        final String gaowen = weather.getData().getForecast().get(0).getHigh();
                        final String diwen = weather.getData().getForecast().get(0).getLow();
                        final String fengli = weather.getData().getForecast().get(0).getFengli();
                        final String riqi = weather.getData().getForecast().get(0).getDate();
                        final String fengxiang = weather.getData().getForecast().get(0).getFengxiang();
                        final String tianqi = weather.getData().getYesterday().getType();
                        //明天
                        final String riqi_one = weather.getData().getForecast().get(1).getDate();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //今天
                                cityWeatherQuality.setText(tianqi);
                                cityWind.setText(fengxiang);
                                cityDate.setText(riqi);
                                cityTemHigh.setText(gaowen);
                                cityTemLow.setText(diwen);
                                cityFl.setText(fengli);

                            }

                        });
                        SharedPreferences.Editor editor = getSharedPreferences("天气状况", MODE_PRIVATE).edit();
                        Log.e("city", "onResponse: " + cityName.getText().toString());
                        editor.putString("city", cityName.getText().toString());
                        editor.apply();

                    }
                });
                break;
            case R.id.home:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent,400);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       switch (requestCode){
           case 400:
               if(resultCode==RESULT_OK){

               Bundle bundle = data.getExtras();
               if (bundle != null) {
                   City city = (City) bundle.get("city");
                   if (city != null) {
                       a = city.getCity();

                       cityName.setText(a);

                       Toast.makeText(MainActivity.this, a, Toast.LENGTH_SHORT).show();
                   }
               }
               }
                   break;
       }
        super.onActivityResult(requestCode, resultCode, data);
    }
}



