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
        Optional<Flight> flight=fService.findFlight(series);
        if(flight.isPresent()){
            System.out.println(flight.get().prettyFormat());
        }
        else{
            System.out.println("Flight does not exist");
        }
    }
    public Optional<Flight> flightSelector(String destination, String date, int num){
        Scanner sn=new Scanner(System.in);
        if(fService.compatibleFlights(destination, date, num).isPresent()){
            fService.compatibleFlights(destination, date, num).get().forEach(x->System.out.println(x.prettyFormat()));
            System.out.println("Please select and enter flight id ( o to main menu ): ");
            String id=sn.next();
            if(fService.findFlight(id).isPresent()!=true){
                if(id.equals("o")==false) {
                    System.out.println("Flight is not found");
                }
                return Optional.empty();
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
