package com.example.administrator.weatherforecast;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity  {
    private ArrayList<City> c = new ArrayList<>();
    private RecyclerView recyclerView;
    private String a ;
    private  static String b;

    private SearchView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sv = findViewById(R.id.searchView);
        adapter adapter = new adapter(this,c);
        recyclerView.setAdapter(adapter);

    }


    @Override
    protected void onResume() {
        super.onResume();
//在子线程中进行对数据库的打开操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                DBManger manager = new DBManger(Main2Activity.this);
                manager.openDataBase();
                SQLiteDatabase db = manager.getDb();
                Cursor cursor = db.query("city", null, null, null, null, null, null);
                if (cursor.moveToNext()) {


                    int  province = cursor.getColumnIndex("province");
                    int city = cursor.getColumnIndex("city");

                    do {
                        a = cursor.getString(province);
                        b = cursor.getString(city);
                        City citys=  new City(1,a,b);
                        c.add(citys);
//使用Log查看数据,未在界面展示
                    }while(cursor.moveToNext());
                }
                manager.closeDataBase();

            }
        }).start();
    }


}


