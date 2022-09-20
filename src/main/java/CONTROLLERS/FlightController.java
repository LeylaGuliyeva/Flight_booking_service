package CONTROLLERS;

import BASE_CLASSES.Flight;
import SERVICE.FlightService;

import java.util.List;

public class FlightController {
    static FlightService fService=new FlightService();
    public static void generateListFlights(int number){
        List<Flight> lf=fService.generateFlight(number);
        for(Flight x:lf){
            System.out.println(x);
        }
    }
    public static void showFlight(String series){
        System.out.println(fService.findFlight(series).get());
    }


}
