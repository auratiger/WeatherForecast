package com.WeatherForecast_new.WeatherModels;

import com.WeatherForecast_new.Interfaces.Model;
import com.WeatherForecast_new.WeatherDataModels.HourlyDataModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HourlyModel implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    @OneToMany
    private List<HourlyDataModel> hourlyDataModels = new ArrayList<HourlyDataModel>();

    public HourlyModel() {
    }

    public HourlyModel(List<HourlyDataModel> hourlyDataModels) {
        this.hourlyDataModels = hourlyDataModels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<HourlyDataModel> getHourlyDataModels() {
        return hourlyDataModels;
    }

    public void setHourlyDataModels(List<HourlyDataModel> hourlyDataModels) {
        this.hourlyDataModels = hourlyDataModels;
    }
}
