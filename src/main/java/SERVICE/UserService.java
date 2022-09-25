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
//    public static void register(){
//        User newUser=new User();
//        Scanner sn=new Scanner(System.in);
//        System.out.print("Please enter name : ");
//        newUser.setName(sn.next());
//        System.out.print("Please enter surname : ");
//        newUser.setSurname(sn.next());
//        System.out.print("Please enter username : ");
//        String usern=sn.next();
//        while(checkUsername(userDao.getAll(),usern).isPresent()){
//            System.out.printf("%s already exits, please enter another username : ");
//            usern=sn.next();
//        }
//        newUser.setUserName(usern);
//        System.out.print("Please enter password : ");
//        newUser.setPassword(sn.next());
//    }

}
