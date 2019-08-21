package com.WeatherForecast_new.Controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class CreationalDataObjectFactory {
    private DataObjectPersistenceFacade facade;

    public CreationalDataObjectFactory(DataObjectPersistenceFacade facade){
        this.facade = facade;
    }

    public void getPersistence(String field, List<List<String>> data, Date time, String city) throws ParseException {

        city = city.replace("+", " ");

        if (field == ""){
            facade.CurrentDayPersistence(data, time, city);
        }
        if (field == "5-days"){
            facade.fiveDayPersistence(data, time, city);
        }
        if (field == "10-days"){
            facade.tenDayPersistence(data, time, city);
        }
        if (field == "weekend"){
            facade.weekendPersistence(data, time, city);
        }
        if (field == "hourly"){
            facade.hourlyPersistence(data, time, city);
        }
    }
}
