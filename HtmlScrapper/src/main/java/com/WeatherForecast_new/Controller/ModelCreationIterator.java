package com.WeatherForecast_new.Controller;

import com.WeatherForecast_new.Parsers.DayParser;
import com.WeatherForecast_new.Parsers.HourParser;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/** This class gathers data using specified patterns through all the specified connections*/

public class ModelCreationIterator {
    private static Logger logger = Logger.getLogger(ModelCreationIterator.class);

    private String city;
    private String country;
    private Date time;

    List<String> fields = Arrays.asList("", "5-days", "10-days", "weekend", "hourly");

    private DayParser dayParser = DayParser.getParser();
    private HourParser hourParser = HourParser.getParser();

    public ModelCreationIterator(String city, String country, Date time) {
        this.city = city;
        this.country = country;
        this.time = time;
    }

    private List<List<String>> scrapeWeatherData(String field) {
        return dayParser.scrapeData(Connection.getConnection(PropertiesDistributor.getUrl(city, country), field),
                Pattern.compile(PropertiesDistributor.getPattern(field)));
    }

    private List<List<String>> scrapeHourlyWeatherData(String field){
        return hourParser.scrapeData(Connection.getConnection(PropertiesDistributor.getUrl(city, country), field),
                Pattern.compile(PropertiesDistributor.getPattern(field)));
    }

    public void ModelIterator() {

        DataObjectPersistenceFacade facade = new DataObjectPersistenceFacade();
        CreationalDataObjectFactory factory = new CreationalDataObjectFactory(facade);

        for (String field : fields) {
            try {
                if (field != "hourly"){
                    factory.getPersistence(field, scrapeWeatherData(field), time, city);
                }else {
                    factory.getPersistence(field, scrapeHourlyWeatherData(field), time, city);
                }
            } catch (ParseException e) {
                logger.error("Error while creating model: " + e);
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        facade.forecastPersistence();
    }
}

















