package com.WeatherForecast_new.WeatherDataModels;

import com.WeatherForecast_new.Interfaces.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class WeekendDataModel implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date runDate;
    @Temporal(TemporalType.TIME)
    private Date runTime;

    @OneToOne
    private WeatherData weatherData;

    public WeekendDataModel() {
    }

    public WeekendDataModel(Date date, WeatherData weatherData) {
        this.runDate = date;
        this.runTime = date;
        this.weatherData = weatherData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

    public Date getRunTime() {
        return runTime;
    }

    public void setRunTime(Date runTime) {
        this.runTime = runTime;
    }
}
