package com.WeatherForecast_new.WeatherDataModels;

import com.WeatherForecast_new.Queries.QueryController;
import com.WeatherForecast_new.Queries.dataDtoHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public class test {
    public static void main(String[] args) throws ParseException, IOException, InterruptedException {

//
//        HourlyWeatherData hourlyWeatherData = new HourlyWeatherData(ft.parse("15.07.2019"), time.parse("11:00"), 20, 0.9, 30, 0.0, 0, 79);
//        HourlyDataModel hour = new HourlyDataModel();
//        hour.getHourlyData().add(hourlyWeatherData);
//        HourlyModel hourlyModel = new HourlyModel();
//        hourlyModel.getHourlyDataModels().add(hour);
//
//        WeatherData day = new WeatherData(ft.parse("12.07.2019"), 12, 23, 2.1, 9, 0.1, 0, 52);
//        WeatherData day1 = new WeatherData(ft.parse("13.07.2019"), 15, 23, 3.1, 2, 0.1, 0, 52);
//        WeatherData day2 = new WeatherData(ft.parse("14.07.2019"), 17, 28, 2.1, 2, 0.1, 0, 52);
//        CurrentDayDataModel now = new CurrentDayDataModel(day);
//        CurrentDayDataModel now1 = new CurrentDayDataModel(day1);
//        CurrentDayDataModel now2 = new CurrentDayDataModel(day2);
//
//        CurrentDayModel arr = new CurrentDayModel();
//        arr.getCurrentDayDataModelList().add(now);
//        arr.getCurrentDayDataModelList().add(now1);
//        arr.getCurrentDayDataModelList().add(now2);
//
//        ForecastModel forecast = new ForecastModel();
//        forecast.setCurrentDayModel(arr);
//        forecast.setHourlyModel(hourlyModel);
//
//        EntityManager entityManager = Persistence.createEntityManagerFactory("user-unit").createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        entityTransaction.begin();

//        entityManager.persist(hourlyWeatherData);
//        entityManager.persist(hour);
//        entityManager.persist(hourlyModel);
//        entityManager.persist(day);
//        entityManager.persist(day1);
//        entityManager.persist(day2);
//        entityManager.persist(now);
//        entityManager.persist(now1);
//        entityManager.persist(now2);
//        entityManager.persist(arr);
//        entityManager.persist(forecast);

//
//        List<WeatherData> l = entityManager.createNamedQuery("ForecastModel.GET_FIVEDAY_BY_TIME", WeatherData.class).
//                setParameter("time1", time.parse("10:00:00")).
//                setParameter("time2", time.parse("15:00:00")).getResultList();
//
//        for (WeatherData d : l) {
//            System.out.println(d.getRainLikelihood() + " " + d.getWind());
//        }

//        List<WeatherData> weatherData = entityManager.createNamedQuery
//                ("ForecastModel.GET_TODAY_ALL", WeatherData.class)
//                .setParameter("city", "varna")
//                .getResultList();
//
//        System.out.println(weatherData);
//        for (int i = 0; i < weatherData.size(); i++) {
//            System.out.println(weatherData.get(i).getAll());
//        }

//
//        List<CurrentDayDataModel> l = entityManager.createNamedQuery("ForecastModel.GET_TODAY").setParameter("city", "sofia").getResultList();
//        for (CurrentDayDataModel model : l) {
//            WeatherData data = model.getWeatherData();
//            System.out.println(data.getDate() +"--"+ data.getMaxTemp() +"--"+ data.getMinTemp());
//        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss", Locale.ENGLISH);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");



//        System.out.println(QueryController.getFiveDayDataByTime("sofia", dateFormat.parse("28-07-2019"),
//                timeFormat.parse("18:00:00"), timeFormat.parse("19:00:00")));
//
//        System.out.println( QueryController.getYears("sofia"));
//        List<Date> h = QueryController.getHours(dateFormat.parse("29-07-2019"), "sofia");
//        System.out.println(h);

//        List<HourlyWeatherData> l = (QueryController.getHourlyDataByTime("sofia", new Date[]{dateFormat.parse("30-07-2019"),
//                timeFormat.parse("00:00:00"), timeFormat.parse("01:00:00")}));
//        for (HourlyWeatherData w : l) {
//            System.out.println(w.getAll());
//        }
//========================================================
//        String url = "https://weather.sinoptik.bg/search?q=Santa+Sofia,+Colombia ";
//
//        URL obj = new URL(url);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//        // optional default is GET
//        con.setRequestMethod("GET");
//
//        //add request header
//        con.setRequestProperty("User-Agent", "Mozilla/5.0");
//
//        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);
//
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        in.close();
//        //print result
//        System.out.println(con.getURL());
//        String shit = con.getURL().toString();
//
//        URL fuck = new URL(shit.substring(0,shit.length()-7)+"/5-days");
//        HttpURLConnection httpURLConnection = (HttpURLConnection) fuck.openConnection();
//        BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
//        System.out.println(httpURLConnection.getURL());
//==================================================

//
//        entityTransaction.commit();
//        entityManager.close();
    }
}
