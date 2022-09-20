package SERVICE;

import BASE_CLASSES.Booking;
import BASE_CLASSES.User;
import DAO.UserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static METHODS.CheckUsernameExistance.checkUsername;
import static SERVICE.UserService.userDao;

public class BookingService {


    public static void makeNewBooking(String username, List<User> users, Booking a){
        if(checkUsername(users,username).isPresent()){
            checkUsername(users,username).get().addBooking(a);
            userDao.save(checkUsername(users,username).get());
        }
    }
    public static boolean cancelBooking(String username, List<User> s, int id){
        if(checkUsername(userDao.getAll(),username).isPresent()){
        checkUsername(userDao.getAll(),username).get().setUserBookings(checkUsername(userDao.getAll(),username).get().getUserBookings().stream().filter(x->x.getId()!=id).collect(Collectors.toList()));
        userDao.save(checkUsername(userDao.getAll(),username).get());
        return true;}
        else{return false;}
    }
}
