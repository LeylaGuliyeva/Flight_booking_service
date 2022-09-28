package CONTROLLERS;

import BASE_CLASSES.Booking;
import BASE_CLASSES.Flight;
import BASE_CLASSES.Passenger;
import BASE_CLASSES.User;
import SERVICE.BookingService;
import SERVICE.FlightService;
import SERVICE.UserService;
import java.util.List;
import java.util.Scanner;
import Exception.UnacceptableInputError;

public class BookingController {
    BookingService bookingService=new BookingService();
    public void makeNewBooking(User a,Flight myFlight,Passenger b){
            bookingService.makeNewBooking(new Booking(a,bookingService.getLastId(),myFlight,b));}
    public void cancelBooking(String id) throws UnacceptableInputError {
        bookingService.cancelBooking(id);}
    public void writer(){
        bookingService.writer();
    }
    public List<Booking> myFlights(String name, String surname){
        return bookingService.myFlights(name,surname);
    }
    public int getLastId(){
        return bookingService.getLastId();

    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }
}





