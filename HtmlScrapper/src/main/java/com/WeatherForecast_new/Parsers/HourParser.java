package com.WeatherForecast_new.Parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HourParser extends Parser{

    private static HourParser instance = new HourParser();

    private HourParser(){}

    public static HourParser getParser(){
        return instance;
    }
//
//    public List<List<String>> scrapeData(BufferedReader conn, Pattern patt){
//        data = new ArrayList<List<String>>();
//
//        parseSourceToString(conn);
//        scrapeSource(patt);
//
//        return data;
//    }
//
//    private void parseSourceToString(BufferedReader connection){
//        String line;
//        source = new StringBuilder();
//
//        try {
//            while((line = connection.readLine()) != null){
//                source.append(line + "\r\n");
//            }
//        }catch (IOException e){
//            logger.error("Error parsing page source: " + e);
//        }
//    }

    protected void scrapeSource(Pattern pattern){
        Matcher matcher = pattern.matcher(source);
        String date = "";
        String line;

        while (matcher.find()){
            List<String> hour = new ArrayList<String>();

            if ((line = matcher.group(1)) != null){
                date = line;
            }
            hour.add(date);

            for (int i = 2; i < matcher.groupCount() + 1; i++) {

                hour.add(matcher.group(i));
            }
            data.add(hour);
        }
    }
}











