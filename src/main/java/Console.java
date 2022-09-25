import BASE_CLASSES.User;
import CONTROLLERS.UserController;

import java.util.Scanner;

public class Console {
    UserController userController=new UserController();
    Commands commands=new Commands();
    String str=new String();
    User a=new User();
    Scanner sn=new Scanner(System.in);
    public void consoleApplication(){
        commands.generateListFlights(50);
        do{
            if(a.getName()==null){
            commands.displayMainMenuWithoutUser();
            System.out.println("Please enter command : ");
            String str=sn.next();
            switch (str){
                case "1":
                    System.out.println("Please enter username : ");
                    String username=sn.next();
                    System.out.println("Please enter password : ");
                    String password=sn.next();
                    if(userController.login(username,password).isPresent())
                        a=userController.login(username,password).get();
                    else{
                        System.out.println("Username or password incorrect");
                    }
                    break;
                case "2":
                    System.out.println("Please enter name : ");
                    String name=sn.next();
                    System.out.println("Please enter surname : ");
                    String surname=sn.next();
                    System.out.println("Please enter username : ");
                    username=sn.next();
                    System.out.println("Please enter password : ");
                    password=sn.next();
                    if(userController.register(name,surname,username,password)) System.out.println("Your registration is successful.");
                    else{System.out.println("Your registration is unsuccessful.");}
                    break;
                case "3":
                    commands.onlineBoard();
                    break;
                case "4":
                    System.out.println("Please enter flight id : ");
                    commands.showFlightInfo(sn.next());
                    break;
                case "exit":
                case "Exit":
                    break;
                default:
                    System.out.println("Enter a valid command! (1-9) ");
                    break;}}
            if(a.getName()!=null){
                commands.displayMainMenuWithUser();
                System.out.println("Please enter command : ");
                String str=sn.next();
                switch (str){
                    case "1":
                        commands.onlineBoard();
                        break;
                    case "2":
                        System.out.println("Please enter flight id : ");
                        commands.showFlightInfo(sn.next());
                        break;
                    case "3":
                        commands.searchBookFlight(a);
                        break;
                    case "4":
                        System.out.println("Please enter id to cancel booking : ");
                        commands.cancelBooking(sn.next());
                        break;
                    case "5":
                        System.out.println("Please enter name and surname : ");
                        String name=sn.next();
                        String surname=sn.next();
                        commands.myFlights(name,surname);
                        break;
                    case "6":
                        a=null;
                        break;
                    case "exit":
                    case "Exit":
                        break;
                    default:
                        System.out.println("Enter a valid command! (1-9) ");
                        break;}}

        }while(str.equals("exit")!=true||str.equals("Exit")!=true);


    }}