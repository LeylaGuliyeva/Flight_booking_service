package TESTS;

import BASE_CLASSES.Booking;
import BASE_CLASSES.Flight;
import BASE_CLASSES.Passenger;
import BASE_CLASSES.User;
import DAO.BookingDao;
import ENUM.Airlines;
import ENUM.Cities;
import SERVICE.BookingService;
import org.junit.Test;

import static METHODS.GenerateFlightDate.generateDate;
import static org.junit.jupiter.api.Assertions.assertTrue;
import Exception.UnacceptableInputError;
public class BookingServiceTest {
    BookingService bs=new BookingService();
    BookingDao bd=new BookingDao();
    @Test
    public void makeNewBookingTest(){
        bs.setBookingDao(bd);
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        Flight f=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        Passenger p=new Passenger("Leyla","Guliyeva",f);
        Booking b=new Booking(u,0,f,p);
        bs.makeNewBooking(b);
        assertTrue(bd.getAll().contains(b));
    }
    @Test
    public void cancelBookingTest() throws UnacceptableInputError {
        bs.setBookingDao(bd);
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        Flight f=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        Passenger p=new Passenger("Leyla","Guliyeva",f);
        Booking b=new Booking(u,0,f,p);
        bs.makeNewBooking(b);
        assertTrue(bd.getAll().contains(b));
        bs.cancelBooking("0");
        assertTrue(bd.getAll().size()==0);
    }
    @Test
    public void myFlightsTest(){
        bs.setBookingDao(bd);
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        Flight f=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        Passenger p=new Passenger("Leyla","Guliyeva",f);
        Booking b=new Booking(u,0,f,p);
        bs.makeNewBooking(b);
        assertTrue(bd.getAll().contains(b));
        assertTrue(bs.myFlights("Leyla","Guliyeva").get(0).equals(b)&&bs.myFlights("Leyla","Guliyeva").size()==1);
    }
}
