package com.example.administrator.weatherforecast;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class Weather2Fragment extends Fragment {

    private String riqi_one_yes;
    private String diwen_one_yes;
    private String gaowen_one_yes;
    private String wea_qua_one_yes;
    private String fengxiang_one_yes;
    @BindView(R.id.date_one)
    TextView dateOne;
    @BindView(R.id.tem_low_one)
    TextView temLowOne;
    @BindView(R.id.tem_high_one)
    TextView temHighOne;
    @BindView(R.id.city_weather_quality_one)
    TextView cityWeatherQualityOne;
    @BindView(R.id.city_wind_one)
    TextView cityWindOne;
    @BindView(R.id.date_two)
    TextView dateTwo;
    @BindView(R.id.tem_low_two)
    TextView temLowTwo;
    @BindView(R.id.tem_high_two)
    TextView temHighTwo;
    @BindView(R.id.city_weather_quality_two)
    TextView cityWeatherQualityTwo;
    @BindView(R.id.city_wind_two)
    TextView cityWindTwo;
    @BindView(R.id.date_three)
    TextView dateThree;
    @BindView(R.id.tem_low_three)
    TextView temLowThree;
    @BindView(R.id.tem_high_three)
    TextView temHighThree;
    @BindView(R.id.city_weather_quality_three)
    TextView cityWeatherQualityThree;
    @BindView(R.id.city_wind_three)
    TextView cityWindThree;
    @BindView(R.id.right_fragment)
    FrameLayout rightFragment;
    Unbinder unbinder;

    public Weather2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_weather2, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        Bundle bundle = getArguments();
        Weather weather = (Weather) bundle.getSerializable("weather");
        if (bundle!=null){

            riqi_one_yes = weather.getData().getYesterday().getDate();
            diwen_one_yes = weather.getData().getYesterday().getLow();
            gaowen_one_yes=weather.getData().getYesterday().getLow();
            wea_qua_one_yes=weather.getData().getYesterday().getType();
            fengxiang_one_yes=weather.getData().getYesterday().getFx();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dateOne.setText(riqi_one_yes);
                temLowOne.setText(diwen_one_yes);
                temHighOne.setText(gaowen_one_yes);
                cityWeatherQualityOne.setText(wea_qua_one_yes);
                cityWindOne.setText(fengxiang_one_yes);
            }
        });
    }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
