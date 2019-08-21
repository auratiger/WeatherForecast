package com.WeatherForecast_new.WeatherModels;

import com.WeatherForecast_new.Interfaces.Model;
import com.WeatherForecast_new.WeatherDataModels.TenDayDataModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TenDayModel implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    @OneToMany
    private List<TenDayDataModel> tenDayDataModels = new ArrayList<TenDayDataModel>();

    public TenDayModel() {
    }

    public TenDayModel(List<TenDayDataModel> tenDayDataModels) {
        this.tenDayDataModels = tenDayDataModels;
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

    public List<TenDayDataModel> getTenDayDataModels() {
        return tenDayDataModels;
    }

    public void setTenDayDataModels(List<TenDayDataModel> tenDayDataModels) {
        this.tenDayDataModels = tenDayDataModels;
    }
}
