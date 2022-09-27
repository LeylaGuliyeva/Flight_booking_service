package SERVICE;

import BASE_CLASSES.Booking;
import BASE_CLASSES.Flight;
import BASE_CLASSES.User;
import DAO.BookingDao;
import DAO.UserDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import Exception.UnacceptableInputError;

public class BookingService {
    BookingDao bookingDao=new BookingDao();
    public void writer(){
        bookingDao.writer();
    }
    public int getLastId(){
        return bookingDao.getAll().size()+1;
    }
    public void makeNewBooking(Booking a){
        bookingDao.save(a);
        }
    public boolean cancelBooking(String id) throws UnacceptableInputError {
        return bookingDao.delete(id);
    }
    public List<Booking> myFlights(String name, String surname){
        return bookingDao.getAll().stream().filter(x->(x.getUser().getName().equals(name)&&x.getUser().getSurname().equals(surname))||(x.getPassenger().getName().equals(name)&&x.getPassenger().getSurname().equals(surname))).collect(Collectors.toList());
    }
}
