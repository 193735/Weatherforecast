package com.example.administrator.weatherforecast;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity  {
    private ArrayList<City> c = new ArrayList<>();
    private ArrayList<City> h = new ArrayList<>();
    private RecyclerView recyclerView;
    private String a ;
    private  static String b;
    private  adapter adapter;
    private  adapter adapter2;
    private SearchView sv;
    private  TextView textView;
    private adapter adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sv = findViewById(R.id.searchView);


        adapter = new adapter(this,c);
        recyclerView.setAdapter(adapter);

       sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String s) {
               return false;
           }

           @Override
           public boolean onQueryTextChange(String s) {
               h.clear();
               if(TextUtils.isEmpty(s))
               {
                   //内容为空进入


               }
               else {
                   //输了内容之后进入，还有当删除一个字符也会进入前提输入框了不为空。
                   for (int i = 0; i < c.size(); i++) {
                       City city = c.get(i);
                       if (city.getCity().contains(s) || city.getProvince().contains(s)) {
                           h.add(city);
                       }
                   }

                   adapter = new adapter(Main2Activity.this, h);
                   recyclerView.setAdapter(adapter);

                 adapter2=new adapter(Main2Activity.this,h);
                recyclerView.setAdapter(adapter2);
                adapter2.setOnItemClickListener(new adapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        City city_search = h.get(position);
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("city",city_search);
                        intent.putExtras(bundle);
                        setResult(RESULT_OK,intent);
                        finish();

                    }
                }); }
               return true;
               }


       });
        Onclick();
    }

    private void Onclick() {
        adapter.setOnItemClickListener(new adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                             City city = c.get(position);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("city", city);
                intent.putExtras(bundle);
              setResult(RESULT_OK,intent);
                finish();
            }
        });
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




                    do {
                        a = cursor.getString(cursor.getColumnIndex("province"));
                        b = cursor.getString(cursor.getColumnIndex("city"));
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


