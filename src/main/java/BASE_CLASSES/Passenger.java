package BASE_CLASSES;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return name.equals(passenger.name) && surname.equals(passenger.surname) && flight.equals(passenger.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, flight);
    }
}
