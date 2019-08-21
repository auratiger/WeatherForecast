package com.WeatherForecast_new.WeatherModels;

import com.WeatherForecast_new.Interfaces.Model;
import com.WeatherForecast_new.WeatherDataModels.CurrentDayDataModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CurrentDayModel implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    @OneToMany
    private List<CurrentDayDataModel> currentDayDataModelList = new ArrayList<CurrentDayDataModel>();

    public CurrentDayModel() {
    }

    public CurrentDayModel(List<CurrentDayDataModel> currentDayDataModelList) {
        this.currentDayDataModelList = currentDayDataModelList;
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

    public List<CurrentDayDataModel> getCurrentDayDataModelList() {
        return currentDayDataModelList;
    }

    public void setCurrentDayDataModelList(List<CurrentDayDataModel> currentDayDataModelList) {
        this.currentDayDataModelList = currentDayDataModelList;
    }
}
