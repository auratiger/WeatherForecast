package com.WeatherForecast_new.WeatherModels;

import com.WeatherForecast_new.Interfaces.Model;
import com.WeatherForecast_new.WeatherDataModels.WeekendDataModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WeekendModel implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String city;

    @OneToMany
    private List<WeekendDataModel> weekendDataModels = new ArrayList<WeekendDataModel>();

    public WeekendModel() {
    }

    public WeekendModel(List<WeekendDataModel> weekendDataModels) {
        this.weekendDataModels = weekendDataModels;
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

    public List<WeekendDataModel> getWeekendDataModels() {
        return weekendDataModels;
    }

    public void setWeekendDataModels(List<WeekendDataModel> weekendDataModels) {
        this.weekendDataModels = weekendDataModels;
    }
}
