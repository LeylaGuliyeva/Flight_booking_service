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
    @Test
    public void flightSelectorTest(){
        Flight u=new Flight("AZE34", Cities.KiEV, Cities.BAKU,23,generateDate(),300, Airlines.PEGASUS);
        FlightService fs=new FlightService();
        FlightDao fd=new FlightDao();
        fd.save(u);
        fs.setFlightDAo(fd);
        fc.setfService(fs);
        assertTrue(fc.flightSelector("Baku","2022/09/28",1).get().equals(u)||fc.flightSelector("Baku","2022/09/29",1).get().equals(u));
    }
}
