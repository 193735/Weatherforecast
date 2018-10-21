package com.example.administrator.weatherforecast;

/**
 * Created by Administrator on 2018/10/16.
 */

public class City {
    private int id;
  private  String province;
  private  String city;

    public City() {

    }

    public City(int id, String province, String city) {
        this.id = id;
        this.province = province;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
