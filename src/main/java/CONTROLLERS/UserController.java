package CONTROLLERS;

import BASE_CLASSES.User;
import SERVICE.UserService;

import java.util.Optional;


public class UserController {
    UserService userService=new UserService();
    public Optional<User> checkUsername(String username){
        return userService.checkUsername(username);
    }
    public void writerToFile(){
        userService.writer();
    }
    public Optional<User> login(String username,String password){
        return userService.login(username,password);
    }
    public boolean register(String name,String surname,String username,String password){
        return userService.register(name,surname,username,password);
    }
    public Optional<User> getUserByName(String username){
        return userService.getUserFromName(username);
    }

}
