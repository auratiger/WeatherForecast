package com.WeatherForecast_new.Parsers;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Parser {
    protected static Logger logger = Logger.getLogger(HourParser.class);

    protected List<List<String>> data;
    protected StringBuilder source = new StringBuilder();

    public synchronized List<List<String>> scrapeData(BufferedReader conn, Pattern patt){
        data  = new ArrayList<List<String>>();

        parseSourceToString(conn);
        scrapeSource(patt);

        return data;
    }

    protected void parseSourceToString(BufferedReader connection){
        String line;
        source = new StringBuilder();

        try {
            while ((line = connection.readLine()) != null){
                source.append(line + "\r\n");
            }
            connection.close();
        }catch (IOException e){
            logger.error("Error parsing page source: " + e);
        }
    }

    protected void scrapeSource(Pattern pattern){
        Matcher matcher = pattern.matcher(source);

        while (matcher.find()){
            List<String> day = new ArrayList<String>();

            for (int i = 1; i < matcher.groupCount() + 1; i++) {
                day.add(matcher.group(i));
            }
            data.add(day);
        }
    }

}
