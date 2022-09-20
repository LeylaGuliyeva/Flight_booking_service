package METHODS;

import BASE_CLASSES.User;
import DAO.UserDao;

import java.util.List;
import java.util.Optional;

public class CheckUsernameExistance {
    public static Optional<User> checkUsername(List<User> d, String username){
    Optional<User> p= d.stream().filter(x->x.getUserName().equals(username)).findFirst();
        if(p.isPresent()){
        return p;
    }
        else{return p.empty();}
}}
