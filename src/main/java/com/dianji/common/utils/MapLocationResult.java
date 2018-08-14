package com.dianji.common.utils;

/**
 * @author XuanFeng
 * @create 2017/11/29
 * Copyright (C) 杭州典击科技有限公司
 */
public class MapLocationResult {

    //省份名称
    String province ;
    //城市名称
    String city ;
    //区域名称
    String district ;
    //区域code
    String adcode;
    //经度
    double lng ;
    //纬度
    double lat ;

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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    @Override
    public String toString() {
        return "MapLocationResult{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", adcode='" + adcode + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
