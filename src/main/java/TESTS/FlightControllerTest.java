package TESTS;

import BASE_CLASSES.Flight;
import CONTROLLERS.FlightController;
import DAO.FlightDao;
import ENUM.Airlines;
import ENUM.Cities;
import SERVICE.FlightService;
import org.junit.Test;

import static METHODS.GenerateFlightDate.generateDate;
import static junit.framework.TestCase.assertTrue;

public class FlightControllerTest {
    FlightController fc=new FlightController();
    FlightService fs=new FlightService();
    FlightDao fd=new FlightDao();
    @Test
    public void getAllTest(){
        fs.setFlightDAo(fd);
        fc.setfService(fs);
        Flight u=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        fd.save(u);
        assertTrue(fc.getAll().get(0).equals(u)&&fc.getAll().size()==1);
    }
    @Test
    public void generateListFlightsTest(){
        fs.setFlightDAo(fd);
        fc.setfService(fs);
        assertTrue(fd.getAll().size()==0);
        fc.generateListFlights(10);
        assertTrue(fd.getAll().size()==10);
    }
}
