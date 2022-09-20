package DAO;

import BASE_CLASSES.Booking;
import BASE_CLASSES.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static BASE_CLASSES.User.userBookings;

public class BookingDao implements DAO<Booking> {

    static List<Booking> bookings=new ArrayList<>();

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
    public boolean delete(Booking booking) {
        if(bookings.contains(booking)){
            bookings.remove(booking);
            return true;
        }
        else{System.out.println("Booking is not found");
            return false;}
    }

    @Override
    public boolean delete(String id) {
        int a=Integer.parseInt(id);
        Optional<Booking> p= bookings.stream().filter(x->x.getId()==a).findFirst();
        if(p.isPresent()){
            bookings.remove(p.get());
            return true;
        }
        else{
            System.out.println("Booking is not found");
            return false;
        }
    }
}
