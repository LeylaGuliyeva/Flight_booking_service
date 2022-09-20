package BASE_CLASSES;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

import java.util.List;

public class User implements Identifiable {
    public String name;
    public String surname;
    public String userName;
    private String password;
    public static List<Booking> userBookings;

    public User(String name, String surname, String userName, String password, List<Booking> userBookings) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.password = password;
        this.userBookings = userBookings;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userBookings=" + userBookings +
                '}';
    }
    public void addBooking(Booking a){
        this.userBookings.add(a);
    }
    public List<Booking> getUserBookings() {
        return userBookings;
    }

    public void setUserBookings(List<Booking> userBookings) {
        this.userBookings = userBookings;
    }

    public User() {
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String passowrd) {
        this.password = passowrd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void write(OutputStream arg0) {

    }
}
