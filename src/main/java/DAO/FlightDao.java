package DAO;

import BASE_CLASSES.Flight;
import METHODS.GetFromFile;
import METHODS.WriteIntoFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements DAO<Flight>{
    static File flightFile=new File("D:\\ABB tech\\Step_project\\src\\main\\java\\Files\\Flights.txt");
    GetFromFile a=new GetFromFile();
    List<Flight> flights=a.getFromFile(flightFile);
    WriteIntoFile write=new WriteIntoFile();
    @Override
    public void save(Flight flight) {
        int x = flights.indexOf(flight);
        if(x >= 0 && x < flights.size()) {
            flights.set(x,flight);}
        else{
            flights.add(flight);
        }}
    public void writer(){
        write.write(flightFile,flights);
    }

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
