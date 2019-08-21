package com.WeatherForecast_new.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/** The purpose of this class (SingleTon) is to connect to the specified website and return a BufferedReader request*/

public class Connection{
    private static URL url;
    private static HttpURLConnection request;
    private static BufferedReader input;

    private static String USER_AGENT = "Mozilla/5.0";

    private Connection(){}

    public static synchronized BufferedReader getConnection(String website, String field){
        createConnection(website, field);

        return input;
    }

    private static void createConnection(String website, String field){
        try {

            sendRequest(website);
            checkResponse();

            String modifiedRequest = request.getURL().toString();
            URL modifiedUrl = new URL(modifiedRequest.substring(0, modifiedRequest.length()-7)+"/"+field);
            HttpURLConnection connection = (HttpURLConnection) modifiedUrl.openConnection();
            input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static void sendRequest(String website) throws IOException{

        url = new URL(website);

        request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("User-Agent", USER_AGENT);
    }

    private static void checkResponse() throws IOException{
        int responseCode = request.getResponseCode();

        if(responseCode != 200){
            throw new IllegalStateException("Expected response code 200 but got: " + responseCode);
        }
    }
}
