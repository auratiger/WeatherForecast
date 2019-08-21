package com.WeatherForecast_new.Parsers;

public class DayParser extends Parser {

    private static DayParser instance = new DayParser();

    private DayParser() {
    }

    public static DayParser getParser(){
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
//            while ((line = connection.readLine()) != null){
//                source.append(line + "\r\n");
//            }
//            connection.close();
//        }catch (IOException e){
//            logger.error("Error parsing page source: " + e);
//        }
//    }
//
//    private void scrapeSource(Pattern pattern){
//        Matcher matcher = pattern.matcher(source);
//
//        while (matcher.find()){
//            List<String> day = new ArrayList<String>();
//
//            for (int i = 1; i < matcher.groupCount() + 1; i++) {
//                day.add(matcher.group(i));
//            }
//            data.add(day);
//        }
//    }
}
