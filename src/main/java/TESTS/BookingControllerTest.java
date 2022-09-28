package TESTS;

import BASE_CLASSES.Booking;
import BASE_CLASSES.Flight;
import BASE_CLASSES.Passenger;
import BASE_CLASSES.User;
import CONTROLLERS.BookingController;
import DAO.BookingDao;
import ENUM.Airlines;
import ENUM.Cities;
import SERVICE.BookingService;
import org.junit.Test;

import static METHODS.GenerateFlightDate.generateDate;
import static org.junit.jupiter.api.Assertions.assertTrue;
import Exception.UnacceptableInputError;

public class BookingControllerTest {
    BookingController bc=new BookingController();
    BookingService bs=new BookingService();
    BookingDao bd=new BookingDao();
    @Test
    public void makeNewBookingTest(){
        bs.setBookingDao(bd);
        bc.setBookingService(bs);
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        Flight f=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        Passenger p=new Passenger("Leyla","Guliyeva",f);
        Booking b=new Booking(u,1,f,p);
        bc.makeNewBooking(u,f,p);
        assertTrue(bd.getAll().get(0).equals(b));
    }
    @Test
    public void getLastIdTest(){
        bs.setBookingDao(bd);
        bc.setBookingService(bs);
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        Flight f=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        Passenger p=new Passenger("Leyla","Guliyeva",f);
        bc.makeNewBooking(u,f,p);
        assertTrue(bc.getLastId()==2);
    }


}
