package TESTS;

import BASE_CLASSES.Flight;
import BASE_CLASSES.User;
import DAO.FlightDao;
import ENUM.Airlines;
import ENUM.Cities;
import org.junit.Test;

import static METHODS.GenerateFlightDate.generateDate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlightDaoTest {
    FlightDao d=new FlightDao();
    @Test
    public void saveTest(){
        Flight u=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        d.save(u);
        assertTrue(d.getAll().contains(u));
    }
    @Test
    public void loadTest() {
        Flight u=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        d.save(u);
        assertTrue(d.getAll().contains(u));
        assertTrue(d.load("AZE34").get().equals(u));
    }
    @Test
    public void deleteTest1(){
        Flight u=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        d.save(u);
        assertTrue(d.getAll().contains(u));
        d.delete(u);
        assertFalse(d.getAll().contains(u));
    }
    @Test
    public void deleteTest2(){
        Flight u=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        d.save(u);
        assertTrue(d.getAll().contains(u));
        d.delete("AZE34");
        assertFalse(d.getAll().contains(u));
    }
    @Test
    public void decreaseSeatTest(){
        Flight u=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        d.save(u);
        assertTrue(d.getAll().contains(u));
        d.decreaseSeat(u);
        assertTrue(u.getSeats()==22);
    }

}
