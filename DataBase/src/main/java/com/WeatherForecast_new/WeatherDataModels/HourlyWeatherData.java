package com.WeatherForecast_new.WeatherDataModels;

import com.WeatherForecast_new.Interfaces.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HourlyWeatherData implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.TIME)
    private Date hour;

    private double temp;
    private double wind;
    private double rainLikelihood;
    private double rainAmount;
    private double stormLikelihood;
    private double cloudiness;

    public HourlyWeatherData() {
    }

    public HourlyWeatherData(Date date, Date hour, double temp, double wind, double rainLikelihood,
                             double rainAmount, double stormLikelihood, double cloudiness) {
        this.date = date;
        this.hour = hour;
        this.temp = temp;
        this.wind = wind;
        this.rainLikelihood = rainLikelihood;
        this.rainAmount = rainAmount;
        this.stormLikelihood = stormLikelihood;
        this.cloudiness = cloudiness;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public double getRainLikelihood() {
        return rainLikelihood;
    }

    public void setRainLikelihood(double rainLikelihood) {
        this.rainLikelihood = rainLikelihood;
    }

    public double getRainAmount() {
        return rainAmount;
    }

    public void setRainAmount(double rainAmount) {
        this.rainAmount = rainAmount;
    }

    public double getStormLikelihood() {
        return stormLikelihood;
    }

    public void setStormLikelihood(double stormLikelihood) {
        this.stormLikelihood = stormLikelihood;
    }

    public double getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(double cloudiness) {
        this.cloudiness = cloudiness;
    }

    public String getAll() {
        return String.format("%s %s %s %s %s %s %s %s", date, hour, temp, wind, rainLikelihood, rainAmount,
                stormLikelihood, cloudiness);
    }
}
