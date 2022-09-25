package DAO;

import BASE_CLASSES.Flight;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements DAO<Flight>{
    List<Flight> flights=new ArrayList<>();
    static File flightFile=new File("flightFile");
    @Override
    public void save(Flight flight) {
        int x = flights.indexOf(flight);
        if(x >= 0 && x < flights.size()) {
            flights.set(x,flight);}
        else{
            flights.add(flight);
        }}

    @Override
    public Optional<Flight> load(String series) {
        Optional<Flight> p= flights.stream().filter(x->x.getSeries().equals(series)).findFirst();
        if(p.isPresent()){
            return p;
        }
        else{ return Optional.empty();}}


    @Override
    public boolean delete(Flight flight) {
        if(flights.contains(flight)){
            flights.remove(flight);
            return true;
        }
        else{System.out.println("Flight is not found");
        return false;}
    }

    @Override
    public List<Flight> getAll() {
        return flights;
    }

    @Override
    public boolean delete(String series) {
        Optional<Flight> p= flights.stream().filter(x->x.getSeries().equals(series)).findFirst();
        if(p.isPresent()){
            flights.remove(p.get());
            return true;
        }
        else{
            System.out.println("Flight is not found");
            return false;
        }
    }
    public void decreaseSeat(Flight flight) {
        for(Flight x:flights){
            if(x.equals(flight)) x.seats--;
        }
    }
}
