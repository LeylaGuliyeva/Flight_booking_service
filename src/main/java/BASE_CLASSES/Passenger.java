package BASE_CLASSES;

import java.io.Serializable;

public class Passenger implements Serializable {
    public String name;
    public String surname;
    Flight flight;

    public Passenger(String name, String surname, Flight flight) {
        this.name = name;
        this.surname = surname;
        this.flight = flight;
    }
    public Passenger() {
    }
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
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
}
