package com.WeatherForecast_new.Scraper;

import com.WeatherForecast_new.Controller.ModelCreationIterator;
import com.WeatherForecast_new.Controller.PropertiesDistributor;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scraper {
    private static final Logger logger = Logger.getLogger(Scraper.class);

    private List<String> cities = PropertiesDistributor.getCities();

    public void scrape() throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(cities.size());

        for (String city : cities) {
            Runnable worker = new Worker(city);
            executor.execute(worker);
        }
        executor.shutdown();
    }

    private class Worker implements Runnable{
        String city;

        public Worker(String city){
            this.city = city;
        }

        public void run(){
            while (true){
                logger.info(Thread.currentThread());

                Date time = new Date();

                ModelCreationIterator modelCreationIterator = new ModelCreationIterator(city, "Bulgaria", time);
                modelCreationIterator.ModelIterator();

                logger.info(Thread.currentThread() + "--Finished--");
                try {
                    //this is a 59.06 minute wait period for all the Threads until their next scrape
                    //59.06 minutes so as to compensate for the slight delay of the process.
                    Thread.sleep(3546000);
                }catch (InterruptedException e){
                    logger.error("Thread failed to go to sleep" + e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scraper s = new Scraper();
        try {
            s.scrape();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
