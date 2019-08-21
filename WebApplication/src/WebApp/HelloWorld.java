package WebApp;

import com.WeatherForecast_new.Queries.dataDtoHandler;

import javax.ws.rs.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Path("/")
public class HelloWorld
{
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    @Path("/tutorial")
    public List<List<Double>> helloworld(@FormParam("city") String city, @FormParam("field") String field,
                                         @FormParam("date") String date, @FormParam("value") String value)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss", Locale.ENGLISH);
        List<Double> r = new ArrayList<>();
        List<Double> rr = new ArrayList<>();
        List<List<Double>> rrr = new ArrayList<>();

//        String[] hours = hour.split(" - ");

        try{
            r = dataDtoHandler.getTemp(city, new Date[] {dateFormat.parse(date),
                    timeFormat.parse("00:00:00"), timeFormat.parse("23:59:00")}, field, value);
            rr = dataDtoHandler.getHourlyTemp(city, new Date[] {dateFormat.parse(date),
                    timeFormat.parse("00:00:00"), timeFormat.parse("01:00:00")}, field);
        }catch (ParseException e){
            e.getErrorOffset();
        }
        rrr.add(r);
        rrr.add(rr);

        return rrr;
    }
}
