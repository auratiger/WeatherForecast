package com.WeatherForecast_new.Queries;

import com.WeatherForecast_new.WeatherDataModels.HourlyWeatherData;
import com.WeatherForecast_new.WeatherDataModels.WeatherData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class dataDtoHandler {
    private static dataDtoHandler instance = new dataDtoHandler();

    // Date[] 'dt' contains: ("date"), ("from") the start time from which to query from and ("to") it's end time
    public static List<Double> getTemp(String city, Date[] dt, String field, String value){
        List<WeatherData> data = QueryController.getData(city, dt, field);

        return getTemp(data);
    }


    public static List<Double> getTemp(List<WeatherData> data) {
        List<Double> forecast = new ArrayList<>();

        for (WeatherData wd : data) {
            forecast.add(wd.getMaxTemp());
        }

        return forecast;
    }

    public static List<Double> getWind(List<WeatherData> data) {
        List<Double> forecast = new ArrayList<>();

        for (WeatherData wd : data) {
            forecast.add(wd.getWind());
        }

        return forecast;
    }

    public static List<Double> getCloudiness(List<WeatherData> data) {
        List<Double> forecast = new ArrayList<>();

        for (WeatherData wd : data) {
            forecast.add(wd.getCloudiness());
        }

        return forecast;
    }

    public static List<Double> getHourlyTemp(String city, Date[] dt, String field){
        List<HourlyWeatherData> data = QueryController.getHourlyDataByTime(city, dt, field);
        List<Double> temperatures = new ArrayList<>();

        for (HourlyWeatherData wd : data) {
            temperatures.add(wd.getTemp());
        }
        return temperatures;
    }








//    public static List<Double> getCurrentDayDataByTime(String city, Date[] dt){
//        List<WeatherData> data = QueryController.getCurrentDataByTime(city, dt);
//        List<Double> temperatures = new ArrayList<>();
//
//        for (WeatherData wd : data) {
//            temperatures.add(wd.getMaxTemp());
//        }
//        return temperatures;
//    }
//
//    public static List<Double> getFiveDayDataByTime(String city, Date[] dt){
//        List<WeatherData> data = QueryController.getFiveDayDataByTime(city, dt);
//        List<Double> temperatures = new ArrayList<>();
//
//        for (WeatherData wd : data) {
//            temperatures.add(wd.getMaxTemp());
//        }
//        return temperatures;
//    }
//
//    public static List<Double> getTenDayDataByTime(String city, Date[] dt, String field){
//        List<WeatherData> data = QueryController.getTenDayDataByTime(city, dt, field);
//        List<Double> temperatures = new ArrayList<>();
//
//        for (WeatherData wd : data) {
//            temperatures.add(wd.getMaxTemp());
//        }
//        return temperatures;
//    }
//
//    public static List<Double> getWeekendDataByTime(String city, Date[] dt){
//        List<WeatherData> data = QueryController.getWeekendDataByTime(city, dt);
//        List<Double> temperatures = new ArrayList<>();
//
//        for (WeatherData wd : data) {
//            temperatures.add(wd.getMaxTemp());
//        }
//        return temperatures;
//    }
}
