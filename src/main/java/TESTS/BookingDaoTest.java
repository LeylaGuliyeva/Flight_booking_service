package TESTS;

import BASE_CLASSES.Booking;
import BASE_CLASSES.Flight;
import BASE_CLASSES.Passenger;
import BASE_CLASSES.User;
import DAO.BookingDao;
import ENUM.Airlines;
import ENUM.Cities;
import org.junit.jupiter.api.Test;

import static METHODS.GenerateFlightDate.generateDate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import Exception.UnacceptableInputError;

public class BookingDaoTest {
    BookingDao d=new BookingDao();
    @Test
    public void saveTest(){
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        Flight f=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        Passenger p=new Passenger("Leyla","Guliyeva",f);
        Booking b=new Booking(u,0,f,p);
        d.save(b);
        assertTrue(d.getAll().contains(b));
    }
    @Test
    public void loadTest() {
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        Flight f=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        Passenger p=new Passenger("Leyla","Guliyeva",f);
        Booking b=new Booking(u,0,f,p);
        d.save(b);
        assertTrue(d.getAll().contains(b));
        System.out.println(d.load("0").get());
        System.out.println(b);
        assertTrue(d.load("0").get().equals(b));
    }
    @Test
    public void deleteTest1() throws UnacceptableInputError {
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        Flight f=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        Passenger p=new Passenger("Leyla","Guliyeva",f);
        Booking b=new Booking(u,0,f,p);
        d.save(b);
        assertTrue(d.getAll().contains(b));
        d.delete(b);
        assertFalse(d.getAll().contains(b));
    }
    @Test
    public void deleteTest2() throws UnacceptableInputError {
        User u=new User("Leyla","Guliyeva","leyla1","12345");
        Flight f=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        Passenger p=new Passenger("Leyla","Guliyeva",f);
        Booking b=new Booking(u,0,f,p);
        d.save(b);
        assertTrue(d.getAll().contains(b));
        d.delete("0");
        assertFalse(d.getAll().contains(b));
    }
}
