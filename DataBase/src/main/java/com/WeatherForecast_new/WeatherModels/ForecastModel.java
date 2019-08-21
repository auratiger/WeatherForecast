package com.WeatherForecast_new.WeatherModels;

import com.WeatherForecast_new.Interfaces.Model;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "ForecastModel.GET_TODAY_ALL",
                query = "select c.weatherData from ForecastModel a right join a.currentDayModel b " +
                        "right join b.currentDayDataModelList c where b.city = :city and c.runDate = :date"),
        @NamedQuery(
                name = "ForecastModel.GET_FIVEDAY_ALL",
                query = "select d from ForecastModel a right join a.fiveDayModel b " +
                        "right join b.fiveDayDataModels c right join c.weatherData d where b.city = :city"),
        @NamedQuery(
                name = "ForecastModel.GET_TENDAY_ALL",
                query = "select c.weatherData from ForecastModel a right join a.tenDayModel b " +
                        "right join b.tenDayDataModels c where b.city = :city and c.runDate = :date"),
        @NamedQuery(
                name = "ForecastModel.GET_WEEKEND_ALL",
                query = "select c.weatherData from ForecastModel a right join a.weekendModel b " +
                        "right join b.weekendDataModels c where b.city = :city"),
        @NamedQuery(
                name = "ForecastModel.GET_HOURLY_ALL",
                query = "select d from ForecastModel a right join a.hourlyModel b " +
                        "right join b.hourlyDataModels c right join c.hourlyWeatherData d where b.city = :city"),
        @NamedQuery(
                name = "ForecastModel.GET_TODAY_BY_TIME",
                query = "select c.weatherData from ForecastModel a right join a.currentDayModel b " +
                        "right join b.currentDayDataModelList c on c.runDate = :date right join c.weatherData d " +
                        "where b.city = :city and c.runTime > :from_time and c.runTime < :end_time"),
        @NamedQuery(
                name = "ForecastModel.GET_FIVEDAY_BY_TIME",
                query = "select d from ForecastModel a right join a.fiveDayModel b " +
                        "right join b.fiveDayDataModels c on c.runDate = :date right join c.weatherData d " +
                        "where b.city = :city and c.runTime between :from_time and :end_time"),
        @NamedQuery(
                name = "ForecastModel.GET_TENDAY_BY_TIME",
                query = "select d from ForecastModel a right join a.tenDayModel b " +
                        "right join b.tenDayDataModels c on c.runDate = :date right join c.weatherData d " +
                        "where b.city = :city and c.runTime > :from_time and c.runTime < :end_time"),
        @NamedQuery(
                name = "ForecastModel.GET_WEEKEND_BY_TIME",
                query = "select d from ForecastModel a right join a.weekendModel b " +
                        "right join b.weekendDataModels c on c.runDate = :date right join c.weatherData d " +
                        "where b.city = :city and c.runTime > :from_time and c.runTime < :end_time"),
        @NamedQuery(
                name = "ForecastModel.GET_HOURLY_BY_TIME",
                query = "select d from ForecastModel a right join a.hourlyModel b " +
                        "right join b.hourlyDataModels c on c.runDate = :date right join c.hourlyWeatherData d " +
                        "where b.city = :city and c.runTime > :from_time and c.runTime < :end_time")
})

@Entity
public class ForecastModel implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String country;

    @OneToOne
    private CurrentDayModel currentDayModel;
    @OneToOne
    private FiveDayModel fiveDayModel;
    @OneToOne
    private TenDayModel tenDayModel;
    @OneToOne
    private WeekendModel weekendModel;
    @OneToOne
    private HourlyModel hourlyModel;

    public ForecastModel() {
    }

    public ForecastModel(CurrentDayModel currentDayModel, FiveDayModel fiveDayModel, TenDayModel tenDayModel, WeekendModel weekendModel, HourlyModel hourlyModel) {
        this.currentDayModel = currentDayModel;
        this.fiveDayModel = fiveDayModel;
        this.tenDayModel = tenDayModel;
        this.weekendModel = weekendModel;
        this.hourlyModel = hourlyModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CurrentDayModel getCurrentDayModel() {
        return currentDayModel;
    }

    public void setCurrentDayModel(CurrentDayModel currentDayModel) {
        this.currentDayModel = currentDayModel;
    }

    public FiveDayModel getFiveDayModel() {
        return fiveDayModel;
    }

    public void setFiveDayModel(FiveDayModel fiveDayModel) {
        this.fiveDayModel = fiveDayModel;
    }

    public TenDayModel getTenDayModel() {
        return tenDayModel;
    }

    public void setTenDayModel(TenDayModel tenDayModel) {
        this.tenDayModel = tenDayModel;
    }

    public WeekendModel getWeekendModel() {
        return weekendModel;
    }

    public void setWeekendModel(WeekendModel weekendModel) {
        this.weekendModel = weekendModel;
    }

    public HourlyModel getHourlyModel() {
        return hourlyModel;
    }

    public void setHourlyModel(HourlyModel hourlyModel) {
        this.hourlyModel = hourlyModel;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
