package SERVICE;

import BASE_CLASSES.Flight;
import DAO.FlightDao;
import ENUM.Airlines;
import ENUM.Cities;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

import static METHODS.GenerateFlightDate.generateDate;

public class FlightService {
    static FlightDao flightDAo=new FlightDao();
    public static List<Flight> generateFlight(int num){
        Random s=new Random();
        IntStream.rangeClosed(1,num).forEach(x->{
            Cities cty=Cities.randomCity();
            flightDAo.save(new Flight(cty.getLabel()+String.valueOf(317+x),Cities.KiEV,cty,s.nextInt(50),generateDate(),(s.nextInt(500-150+1)+150), Airlines.randomAirline()));
        });

        return flightDAo.getAll();
    }
    public static Optional<Flight> findFlight(String series){
        Optional<Flight> p= flightDAo.getAll().stream().filter(x->x.getSeries().equals(series)).findFirst();
        if(p.isPresent()){
            return p;
        }
        return Optional.empty();
    }
}
