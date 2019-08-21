package com.WeatherForecast_new.WeatherModels;

import com.WeatherForecast_new.Interfaces.Model;
import com.WeatherForecast_new.WeatherDataModels.FiveDayDataModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FiveDayModel implements Model {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    @OneToMany
    private List<FiveDayDataModel> fiveDayDataModels = new ArrayList<FiveDayDataModel>();

    public FiveDayModel() {
    }

    public FiveDayModel(List<FiveDayDataModel> fiveDayDataModels) {
        this.fiveDayDataModels = fiveDayDataModels;
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

    public List<FiveDayDataModel> getFiveDayDataModels() {
        return fiveDayDataModels;
    }

    public void setFiveDayDataModels(List<FiveDayDataModel> fiveDayDataModels) {
        this.fiveDayDataModels = fiveDayDataModels;
    }
}
