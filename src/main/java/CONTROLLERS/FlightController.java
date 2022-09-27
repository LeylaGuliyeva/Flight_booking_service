package CONTROLLERS;

import BASE_CLASSES.Flight;
import SERVICE.FlightService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import Exception.UnacceptableInputError;

public class FlightController {
    static FlightService fService=new FlightService();
    public List<Flight> getAll() {
        return fService.getAll();
    }
    public void generateListFlights(int number){
        fService.generateFlight(number);
    }
    public void writer(){
        fService.writer();
    }
    public Optional<Flight> findFlight(String series){
        return fService.findFlight(series);
    }
    public void showFlight(String series) throws UnacceptableInputError {
        Optional<Flight> flight = fService.findFlight(series);
        try{if (flight.isPresent()) {
            System.out.println(flight.get().prettyFormat());
        }
        else{
            throw new UnacceptableInputError();
        }}
        catch (UnacceptableInputError e) {
            System.out.println("Flight id is not valid!");
        }}
        public Optional<Flight> flightSelector(String destination, String date, int num){
        Scanner sn=new Scanner(System.in);
        if(fService.compatibleFlights(destination, date, num).isPresent()){
            fService.compatibleFlights(destination, date, num).get().forEach(x->System.out.println(x.prettyFormat()));
            System.out.println("Please select and enter flight id ( o to main menu ): ");
            String id=sn.next();
            if(fService.findFlight(id).isPresent()!=true){
                try{
                if(id.equals("o")==false) {
                    throw new UnacceptableInputError();
                }
                return Optional.empty();}
                catch(UnacceptableInputError a){
                System.out.println("Flight id is not valid!");
                return Optional.empty();
            }}
            else{return (fService.findFlight(id));}}
        else{
            System.out.println("There is no flight that meets the requirements");
            return Optional.empty();
        }
    }
    public void decreaseSeat(Flight flight) {
    fService.decreaseSeat(flight);
    }

}
