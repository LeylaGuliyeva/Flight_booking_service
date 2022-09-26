package DAO;

import BASE_CLASSES.Flight;
import BASE_CLASSES.User;
import METHODS.GetFromFile;
import METHODS.WriteIntoFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class UserDao implements DAO<User> {
    File userFile=new File("D:\\ABB tech\\Step_project\\src\\main\\java\\Files\\Users.txt");
    GetFromFile a=new GetFromFile();
    List<User> users=a.getFromFile(userFile);
    WriteIntoFile write=new WriteIntoFile();

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
    public void writer(){
        write.write(userFile,users);
    }
    @Override
    public Optional<User> load(String username) {
        if(checkUsername(username).isPresent()){
            return checkUsername(username);
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
        if(checkUsername(username).isPresent()){
            users.remove(checkUsername(username).get());
            return true;
        }
        else{
            System.out.println("User is not found");
            return false;
        }}
    public Optional<User> checkUsername(String username){
            Optional<User> p= users.stream().filter(x->x.getUserName().equals(username)).findFirst();
            if(p.isPresent()){
                return p;
            }
            else{return p.empty();}
    }}

