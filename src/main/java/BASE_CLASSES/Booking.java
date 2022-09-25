package BASE_CLASSES;

import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

public class Booking implements Identifiable {
    public User user;
    public int id;
    public Flight flight;
    public Passenger passenger;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Booking(User user, int id, Flight flight, Passenger passenger) {
        this.user=user;
        this.id = id;
        this.flight = flight;
        this.passenger = passenger;
    }
    public Booking() {
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", flight=" + flight +
                ", passenger=" + passenger +
                '}';
    }
    public String prettyFormat(){
        return String.format( "%d\n%s %s\n%s\n",id,passenger.getName(),passenger.getSurname(),flight.prettyFormat());
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public void write(OutputStream arg0) {

    }
}
