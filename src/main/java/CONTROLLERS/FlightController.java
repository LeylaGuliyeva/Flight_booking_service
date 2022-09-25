package CONTROLLERS;

import BASE_CLASSES.Flight;
import SERVICE.FlightService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FlightController {
    static FlightService fService=new FlightService();
    public List<Flight> getAll() {
        return fService.getAll();
    }
    public void generateListFlights(int number){
        fService.generateFlight(number);
    }
    public void showFlight(String series){
        System.out.println(fService.findFlight(series).get().prettyFormat());
    }
    public Optional<Flight> flightSelector(String destination, String date, int num){
        System.out.println("2333");
        Scanner sn=new Scanner(System.in);
        if(fService.compatibleFlights(destination, date, num).isPresent()){
            fService.compatibleFlights(destination, date, num).get().forEach(x->System.out.println(x.prettyFormat()));
            System.out.println("Please select and enter flight id : ");
            String id=sn.next();
            System.out.println("2453");
            while(fService.findFlight(id).isPresent()!=true){
                System.out.println("Please enter valid flight id : ");
                id=sn.next();
            }
            return (fService.findFlight(id));
        }
        else{
            System.out.println("There is no flight that meets the requirements");
            return Optional.empty();
        }
    }
    public void decreaseSeat(Flight flight) {
    fService.decreaseSeat(flight);
    }
}
