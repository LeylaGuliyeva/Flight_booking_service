package SERVICE;

import BASE_CLASSES.User;
import DAO.UserDao;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static METHODS.CheckUsernameExistance.checkUsername;

public class UserService {
    static UserDao userDao=new UserDao();
    public static boolean login(String username,String password){
        if(checkUsername(userDao.getAll(),username).isPresent()){
            return checkUsername(userDao.getAll(),username).get().getPassword().equals(password);
        }
        else{
            return false;
        }
    }
    public static void register(){
        User newUser=new User();
        Scanner sn=new Scanner(System.in);
        System.out.print("Please enter name : ");
        newUser.setName(sn.next());
        System.out.print("Please enter surname : ");
        newUser.setSurname(sn.next());
        System.out.print("Please enter username : ");
        String usern=sn.next();
        while(checkUsername(userDao.getAll(),usern).isPresent()){
            System.out.printf("%s already exits, please enter another username : ");
            usern=sn.next();
        }
        newUser.setUserName(usern);
        System.out.print("Please enter password : ");
        newUser.setPassword(sn.next());
    }

}
