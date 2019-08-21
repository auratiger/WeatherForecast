package com.WeatherForecast_new.WeatherDataModels;

import com.WeatherForecast_new.Interfaces.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class HourlyDataModel implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date runDate;
    @Temporal(TemporalType.TIME)
    private Date runTime;

    @OneToMany
    private List<HourlyWeatherData> hourlyWeatherData = new ArrayList<HourlyWeatherData>();

    public HourlyDataModel() {
    }

    public HourlyDataModel(Date date) {
        this.runDate = date;
        this.runTime = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<HourlyWeatherData> getHourlyWeatherData() {
        return hourlyWeatherData;
    }

    public void setHourlyWeatherData(List<HourlyWeatherData> hourlyWeatherData) {
        this.hourlyWeatherData = hourlyWeatherData;
    }
}

