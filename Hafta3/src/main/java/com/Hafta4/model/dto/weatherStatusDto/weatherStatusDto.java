package com.Hafta4.model.dto.weatherStatusDto;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.annotations.JsonAdapter;

import java.util.ArrayList;


public class weatherStatusDto {
    public static class City{
        public int id;
        public String name;
        public Coord coord;
        public String country;
        public int population;
        public int timezone;
        public int sunrise;
        public int sunset;
    }

    public static class Clouds{
        public int all;
    }

    public static class Coord{
        public double lat;
        public double lon;
    }

//    public static class List{
//        public int dt;
//        public Main main;
//        public ArrayList<Weather> weather;
//        public Clouds clouds;
//        public Wind wind;
//        public int visibility;
//        public double pop;
//        public Sys sys;
//        public String dt_txt;
//    }

    public static class Main{
        public double temp;
        public double feels_like;
        public double temp_min;
        public double temp_max;
        public int pressure;
        public int sea_level;
        public int grnd_level;
        public int humidity;
        public double temp_kf;
    }

    public static class Root{
        public String cod;
        public int message;
        public int cnt;
        public ArrayList<JsonNode> list;
        public City city;
    }

    public static class Sys{
        public String pod;
    }

    public static class Weather{
        public int id;
        public String main;
        public String description;
        public String icon;
    }

    public static class Wind{
        public double speed;
        public int deg;
        public double gust;
    }
}
