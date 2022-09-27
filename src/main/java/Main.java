import BASE_CLASSES.Flight;
import DAO.FlightDao;
import METHODS.GenerateFlightDate;
import Exception.UnacceptableInputError;


public class Main {
    public static void main(String arg[]) throws UnacceptableInputError {
        Console console=new Console();
        console.consoleApplication();
    }
}
