package SERVICE;

import BASE_CLASSES.Flight;
import DAO.FlightDao;
import ENUM.Airlines;
import ENUM.Cities;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static METHODS.DataConverter.dateToString;
import static METHODS.DataConverter.within24Hours;
import static METHODS.GenerateFlightDate.generateDate;

public class FlightService {
    static FlightDao flightDAo=new FlightDao();
    public List<Flight> getAll() {
        return flightDAo.getAll();
    }
    public Optional<List<Flight>> compatibleFlights(String destination, String date, int num){
        List<Flight> p=flightDAo.getAll().stream().filter(x->x.getArrivalCity().toString().equals(destination.toUpperCase())&&x.getSeats()>=num&&date.equals(dateToString(x.getDate()).substring(0,10))&&within24Hours(x)).collect(Collectors.toList());
        if(p.isEmpty()){
            return Optional.empty();
        }
        else{
            return Optional.of(p);
        }
    }
    public void writer(){
        flightDAo.writer();
    }
    public void generateFlight(int num){
        Random s=new Random();
        IntStream.rangeClosed(1,num).forEach(x->{
            Cities cty=Cities.randomCity();
            while(cty.toString().equals("KIEV")==true){
                cty=Cities.randomCity();
            }
            flightDAo.save(new Flight(cty.getLabel()+String.valueOf(317+x),Cities.KiEV,cty,(1+s.nextInt(50)),generateDate(),(s.nextInt(500-150+1)+150), Airlines.randomAirline()));
        });
    }

    public FlightDao getFlightDAo() {
        return flightDAo;
    }

    public void setFlightDAo(FlightDao flightDAo) {
        FlightService.flightDAo = flightDAo;
    }

    public Optional<Flight> findFlight(String series){
        Optional<Flight> p= flightDAo.getAll().stream().filter(x->x.getSeries().equals(series)).findFirst();
        if(p.isPresent()){
            return p;
        }
        return Optional.empty();
    }
    public void decreaseSeat(Flight flight) {
        flightDAo.decreaseSeat(flight);
    }


}
