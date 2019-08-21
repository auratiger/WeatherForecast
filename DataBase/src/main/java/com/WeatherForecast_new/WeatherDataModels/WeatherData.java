package com.WeatherForecast_new.WeatherDataModels;

import com.WeatherForecast_new.Interfaces.Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "WeatherData")

public class WeatherData implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date date;
    private double maxTemp;
    private double minTemp;
    private double wind;
    private double rainLikelihood;
    private double rainAmount;
    private double stormLikelihood;
    private double cloudiness;

    public WeatherData() {
    }

    public WeatherData(Date date, double minTemp, double maxTemp, double wind, double rainLikelihood,
                       double rainAmount, double stormLikelihood, double cloudiness) {
        this.date = date;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
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

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString() {
        return String.format("%s %s %s %s %s %s %s %s", date, maxTemp, minTemp, wind, rainLikelihood, rainAmount, stormLikelihood, cloudiness);
    }

    public Double[] getAll() {
        return new Double[]{maxTemp, minTemp, wind, rainLikelihood, rainAmount, stormLikelihood, cloudiness};
    }
}
