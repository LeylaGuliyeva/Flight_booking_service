package DAO;

import BASE_CLASSES.Flight;
import BASE_CLASSES.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static METHODS.CheckUsernameExistance.checkUsername;

public class UserDao implements DAO<User> {

    List<User> users=new ArrayList<>();

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void save(User user) {
        int x = users.indexOf(user);
        if(x >= 0 && x < users.size()) {
            users.set(x,user);}
        else{
            users.add(user);
        }
    }

    @Override
    public Optional<User> load(String username) {
        if(checkUsername(users,username).isPresent()){
            return checkUsername(users,username);
        }
        else{ return Optional.empty();}
    }

    @Override
    public boolean delete(User user) {
        if(users.contains(user)){
            users.remove(user);
            return true;
        }
        else{System.out.println("User is not found");
            return false;}
    }

    @Override
    public boolean delete(String username) {
        if(checkUsername(users,username).isPresent()){
            users.remove(checkUsername(users,username).get());
            return true;
        }
        else{
            System.out.println("User is not found");
            return false;
        }
    }
}
