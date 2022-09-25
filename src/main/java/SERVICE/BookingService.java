package SERVICE;

import BASE_CLASSES.Booking;
import BASE_CLASSES.Flight;
import BASE_CLASSES.User;
import DAO.BookingDao;
import DAO.UserDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingService {
    BookingDao bookingDao=new BookingDao();
    public int getLastId(){
        return bookingDao.getAll().size();

    }
    public void makeNewBooking(Booking a){
        bookingDao.save(a);
        }
    public boolean cancelBooking(String id){
        return bookingDao.delete(id);
    }

    public List<Booking> myFlights(String name, String surname){
        System.out.println(name);
        System.out.println(surname);
        return bookingDao.getAll().stream().filter(x->x.getUser().getName().equals(name)&&x.getUser().getSurname().equals(surname)).collect(Collectors.toList());


    }
}
