package com.WeatherForecast_new.Controller;

import com.WeatherForecast_new.Interfaces.Model;
import com.WeatherForecast_new.Manager.ManageData;
import com.WeatherForecast_new.WeatherDataModels.*;
import com.WeatherForecast_new.WeatherModels.*;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DataObjectPersistenceFacade {
    private Logger logger = Logger.getLogger(DataObjectPersistenceFacade.class);

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy");
    private SimpleDateFormat simpleHourFormat = new SimpleDateFormat("hh");

    private CurrentDayModel currentDayModel;
    private FiveDayModel fiveDayModel;
    private TenDayModel tenDayModel;
    private WeekendModel weekendModel;
    private HourlyModel hourlyModel;
    
    private WeatherData creatingWeatherDataObject(List<String> data) throws ParseException {

        return new WeatherData(simpleDateFormat.parse(data.get(0)), Double.parseDouble(data.get(1))
                , Double.parseDouble(data.get(2)), Double.parseDouble(data.get(3)), Double.parseDouble(data.get(4))
                , Double.parseDouble(data.get(5)), Double.parseDouble(data.get(6)), Double.parseDouble(data.get(7)));
    }

    private HourlyWeatherData creatingHourlyWeatherDataModel(List<String> data) throws ParseException {
        return new HourlyWeatherData(simpleDateFormat.parse(data.get(0)), simpleHourFormat.parse(data.get(1))
                , Double.parseDouble(data.get(2)), Double.parseDouble(data.get(3)), Double.parseDouble(data.get(4))
                , Double.parseDouble(data.get(5)), Double.parseDouble(data.get(6)), Double.parseDouble(data.get(7)));
    }

    public void CurrentDayPersistence(List<List<String>> data, Date time, String city) throws ParseException {

        List<String> list = data.get(0);
        WeatherData weatherData = creatingWeatherDataObject(list);

        CurrentDayDataModel currentDayDataModel = new CurrentDayDataModel(time, weatherData);
        currentDayModel = new CurrentDayModel();
        currentDayModel.getCurrentDayDataModelList().add(currentDayDataModel);
        currentDayModel.setCity(city);
        ManageData.persistAll(new Model[]{weatherData, currentDayDataModel, currentDayModel});
    }

    public void fiveDayPersistence(List<List<String>> data, Date time, String city) throws ParseException {

        for (List<String> list : data) {
            WeatherData weatherData = creatingWeatherDataObject(list);

            FiveDayDataModel fiveDayDataModel= new FiveDayDataModel(time, weatherData);
            fiveDayModel= new FiveDayModel();
            fiveDayModel.getFiveDayDataModels().add(fiveDayDataModel);
            fiveDayModel.setCity(city);

            ManageData.persistAll(new Model[]{weatherData, fiveDayDataModel, fiveDayModel});
        }
    }

    public void tenDayPersistence(List<List<String>> data, Date time, String city) throws ParseException {

        for (List<String> list : data) {
            WeatherData weatherData = creatingWeatherDataObject(list);

            TenDayDataModel tenDayDataModel= new TenDayDataModel(time, weatherData);
            tenDayModel = new TenDayModel();
            tenDayModel.getTenDayDataModels().add(tenDayDataModel);
            tenDayModel.setCity(city);
            ManageData.persistAll(new Model[]{weatherData, tenDayDataModel, tenDayModel});
        }
    }

    public void weekendPersistence(List<List<String>> data, Date time, String city) throws ParseException {

        for (List<String> list : data) {
            WeatherData weatherData = creatingWeatherDataObject(list);

            WeekendDataModel weekendDataModel = new WeekendDataModel(time, weatherData);
            weekendModel = new WeekendModel();
            weekendModel.getWeekendDataModels().add(weekendDataModel);
            weekendModel.setCity(city);
            ManageData.persistAll(new Model[]{weatherData, weekendDataModel, weekendModel});
        }
    }

    public void hourlyPersistence(List<List<String>> data, Date time, String city) throws ParseException {

        for (List<String> list : data) {
            HourlyWeatherData hourlyWeatherData = creatingHourlyWeatherDataModel(list);

            HourlyDataModel hourlyDataModel = new HourlyDataModel(time);
            hourlyDataModel.getHourlyWeatherData().add(hourlyWeatherData);
            hourlyModel = new HourlyModel();
            hourlyModel.getHourlyDataModels().add(hourlyDataModel);
            hourlyModel.setCity(city);

            ManageData.persistAll(new Model[]{hourlyWeatherData, hourlyDataModel, hourlyModel});
        }
    }

    public void forecastPersistence(){
        ForecastModel forecastModel = new ForecastModel();
        forecastModel.setCountry("Bulgaria");
        forecastModel.setCurrentDayModel(currentDayModel);
        forecastModel.setFiveDayModel(fiveDayModel);
        forecastModel.setTenDayModel(tenDayModel);
        forecastModel.setWeekendModel(weekendModel);
        forecastModel.setHourlyModel(hourlyModel);

        ManageData.persist(forecastModel);
    }
}
