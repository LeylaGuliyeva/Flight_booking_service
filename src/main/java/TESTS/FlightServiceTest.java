package TESTS;

import BASE_CLASSES.Flight;
import DAO.FlightDao;
import ENUM.Airlines;
import ENUM.Cities;
import SERVICE.FlightService;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static METHODS.GenerateFlightDate.generateDate;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlightServiceTest {
    FlightService fs=new FlightService();
    FlightDao fd=new FlightDao();
    @Test
    public void findFlightTest(){
        Flight u=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        fd.save(u);
        fs.setFlightDAo(fd);
        assertTrue(fs.findFlight("AZE34").get().equals(u));
    }
    @Test
    public void compatibleFlightsTest(){
        Flight u=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        fd.save(u);
        fs.setFlightDAo(fd);
        assertTrue(fs.compatibleFlights("BAKU", "2022/09/28", 1).get().contains(u)||fs.compatibleFlights("BAKU", "2022/09/29", 1).get().contains(u));
    }
}
