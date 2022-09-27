package DAO;

import BASE_CLASSES.Booking;
import BASE_CLASSES.Flight;
import BASE_CLASSES.User;
import METHODS.GetFromFile;
import METHODS.WriteIntoFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import Exception.UnacceptableInputError;

public class BookingDao implements DAO<Booking> {
    static File bookingFile=new File("D:\\ABB tech\\Step_project\\src\\main\\java\\Files\\Bookings.txt");
    GetFromFile a=new GetFromFile();
    List<Booking> bookings=a.getFromFile(bookingFile);
    WriteIntoFile write=new WriteIntoFile();

    @Override
    public List<Booking> getAll() {
        return bookings;
    }

    @Override
    public void save(Booking booking) {
        int x = bookings.indexOf(booking);
        if(x >= 0 && x < bookings.size()) {
            bookings.set(x,booking);}
        else{
            bookings.add(booking);
        }
    }
    @Override
    public Optional<Booking> load(String id) {
        int a=Integer.parseInt(id);
        Optional<Booking> p= bookings.stream().filter(x->x.getId()==a).findFirst();
        if(p.isPresent()){
            return p;
        }
        else{ return Optional.empty();}
    }

    @Override
    public boolean delete(Booking booking) throws UnacceptableInputError {
        try{if(bookings.contains(booking)){
            bookings.remove(booking);
            return true;
        }
        else{ throw new UnacceptableInputError();
    }} catch (UnacceptableInputError e) {
            System.out.println("Booking does not exist");
            return false;
        }}

        public void writer(){
        write.write(bookingFile,bookings);
    }
    @Override
    public boolean delete(String id) throws UnacceptableInputError {
        int a=Integer.parseInt(id);
        Optional<Booking> p= bookings.stream().filter(x->x.getId()==a).findFirst();
        try{if(p.isPresent()){
            bookings.remove(p.get());
            return true;
        }
        else{
            throw new UnacceptableInputError();
        }}
        catch (UnacceptableInputError e) {
            System.out.println("Booking does not exist");
            return false;
        }}
    }

