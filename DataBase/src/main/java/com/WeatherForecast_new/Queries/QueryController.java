package com.WeatherForecast_new.Queries;

import com.WeatherForecast_new.WeatherDataModels.HourlyWeatherData;
import com.WeatherForecast_new.WeatherDataModels.WeatherData;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class QueryController {
    private static Properties props;
    private static QueryController instance = new QueryController();
    private static EntityManager entityManager =
            Persistence.createEntityManagerFactory("user-unit").createEntityManager();
    private static EntityTransaction entityTransaction = entityManager.getTransaction();

    private QueryController() {
        props = new Properties();
        try {
            props.load(new FileInputStream(
                    "/home/auratiger/IdeaProjects/WeatherForecast_new/DataBase/src/main/resources/props.properties"
            ));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // Date[] 'dt' contains: ("date"), ("from") the start time from which to query from and ("to") it's end time
    public static List<WeatherData> getData(String city, Date[] dt, String field) {
        String name = props.getProperty(field);
        return entityManager.createNamedQuery(name, WeatherData.class)
                .setParameter("city", city).setParameter("date", dt[0]).setParameter("from_time", dt[1])
                .setParameter("end_time", dt[2]).getResultList();
    }

    public static List<WeatherData> getDay(String city, Date[] dt, String field) {
        String name = props.getProperty(field);
        return entityManager.createNamedQuery(name, WeatherData.class)
                .setParameter("city", city).setParameter("date", dt[0]).getResultList();
    }

    public static List<HourlyWeatherData> getHourlyDataByTime(String city, Date[] dt, String field) {
        return entityManager.createNamedQuery
                ("ForecastModel.GET_HOURLY_BY_TIME", HourlyWeatherData.class).setParameter("city", city)
                .setParameter("date", dt[0]).setParameter("from_time", dt[1])
                .setParameter("end_time", dt[2]).getResultList();
    }
}
