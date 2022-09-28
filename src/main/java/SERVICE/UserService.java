package SERVICE;

import BASE_CLASSES.User;
import DAO.UserDao;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;



public class UserService {
    static UserDao userDao=new UserDao();
    public boolean register(String name,String surname,String username,String password){
        boolean flag=false;
        User user=new User(name,surname,username,password);
        userDao.save(user);
        flag=true;
        return true;
    }

    public static UserDao getUserDao() {
        return userDao;
    }

    public static void setUserDao(UserDao userDao) {
        UserService.userDao = userDao;
    }

    public void save(User u) {
        userDao.save(u);
    }
    public Optional<User> checkUsername(String username){
        return userDao.checkUsername(username);
    }
    public void writer(){
        userDao.writer();
    }
    public Optional<User> getUserFromName(String username){
        return userDao.checkUsername(username);
    }
    public Optional<User> login(String username,String password){
        if(userDao.checkUsername(username).isPresent()&&userDao.checkUsername(username).get().getPassword().equals(password)){
        return userDao.checkUsername(username);
    }
        else{
            return Optional.empty();
        }
    }

}
