package com.WeatherForecast_new.Controller;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesDistributor {
    private static Properties properties = new Properties();
    private static Logger logger = Logger.getLogger(PropertiesDistributor.class);
    private static PropertiesDistributor instance = new PropertiesDistributor();

    private PropertiesDistributor(){
        try {
            properties.load(new FileInputStream(
                    "/home/auratiger/IdeaProjects/WeatherForecast_new/HtmlScrapper/src/main/resources/props.properties"
            ));
        } catch (IOException e) {
            logger.warn("Trouble loading properties file: " + e);
        }
    }

    public static String getUrl(String city, String country){
        String request = properties.getProperty("weather.request");
        return String.format("%s%s,+%s/", request, city, country);
    }

    public static String getPattern(String field) {
        return properties.getProperty(String.format("pattern.%s", field));
    }

    public static List<String> getCities(){
        return new ArrayList<String>(Arrays.asList(properties.getProperty("cities").toLowerCase().split(", ")));
    }
}





