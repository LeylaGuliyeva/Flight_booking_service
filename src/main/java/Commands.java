import BASE_CLASSES.Booking;
import BASE_CLASSES.Flight;
import BASE_CLASSES.Passenger;
import BASE_CLASSES.User;
import CONTROLLERS.BookingController;
import CONTROLLERS.FlightController;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Commands {
    BookingController bookingController=new BookingController();
    FlightController flightController=new FlightController();

    public void displayMainMenuWithoutUser(){
        System.out.println("*************************************************************\n" +
                           "*************************************************************\n"+
                           "                   Flight Booking Service                    \n"+
                           "*************************************************************\n"+
                           "*************************************************************\n"+
                           "                         1. Login                            \n"+
                           "                         2. Register                         \n"+
                           "                         3. Online board                     \n"+
                           "                         4. Show flight                      \n"+
                           "                         Exit                                \n"+
                           "*************************************************************\n"+
                           "*************************************************************\n");}
    public void displayMainMenuWithUser(){
        System.out.println("*************************************************************\n" +
                "*************************************************************\n"+
                "                   Flight Booking Service                    \n"+
                "*************************************************************\n"+
                "*************************************************************\n"+
                "                      1. Online board                        \n"+
                "                      2. Show flight                         \n"+
                "                      3. Search and book a flight            \n"+
                "                      4. Cancel booking                      \n"+
                "                      5. My flights                          \n"+
                "                      6. Log out                             \n"+
                "                      Exit                                   \n"+
                "*************************************************************\n"+
                "*************************************************************\n");}

    public void generateListFlights(int number){
        flightController.generateListFlights(number);
    }
    public void onlineBoard(){
        flightController.getAll().stream().forEach(x->System.out.println(x.prettyFormat()));
        System.out.println();
    }
    public void showFlightInfo(String id){
        flightController.showFlight(id);
    }
    public void cancelBooking(String id){
        bookingController.cancelBooking(id);
    }
    public void myFlights(String name,String surname){
        if(bookingController.myFlights(name,surname).isEmpty()){
            System.out.println("You have no recorded bookings");
        }
        else{
            bookingController.myFlights(name,surname).forEach(x->System.out.println(x.prettyFormat()));
        }
    }
    public void searchBookFlight(User a){
        Scanner sn=new Scanner(System.in);
        System.out.println("Please add flight destination : ");
        String destination=sn.next().toUpperCase();
        System.out.println("Please add flight date(yyyy/MM/dd) : ");
        String date=sn.next();
        System.out.println("Please enter number of passengers");
        int pass_num=sn.nextInt();
        Optional<Flight> flight=flightController.flightSelector(destination,date,pass_num);
        if(flight.isPresent()){
        System.out.println("Please enter number of passengers : ");
        int number=sn.nextInt();
        for(int i=0;i<number;i++){
            System.out.println("Please enter the name of passenger : ");
            String name=sn.next();
            System.out.println("Please enter the surname of passenger : ");
            String surname=sn.next();
            bookingController.makeNewBooking(a,flight.get(),new Passenger(name,surname,flight.get()));
            flightController.decreaseSeat(flight.get());
        }
    }
}}

