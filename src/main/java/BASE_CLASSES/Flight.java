package BASE_CLASSES;

import ENUM.Airlines;
import ENUM.Cities;
import com.sun.corba.se.spi.ior.Identifiable;
import org.omg.CORBA_2_3.portable.OutputStream;

import java.util.Date;

import static METHODS.DataConverter.dateToString;

public class Flight implements Identifiable {
    public String series;
    public Cities departureCity;
    public Cities arrivalCity;
    public int seats;
    public Date date;
    public int price;
    Airlines airline;

    public Flight(String series, Cities departureCity, Cities arrivalCity, int seats, Date date, int price, Airlines airline) {
        this.series = series;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.seats = seats;
        this.date = date;
        this.price = price;
        this.airline = airline;
    }

    public Flight() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "series='" + series + '\'' +
                ", departureCity=" + departureCity +
                ", arrivalCity=" + arrivalCity +
                ", seats=" + seats +
                ", date=" + date +
                ", price=" + price +
                ", airline=" + airline +
                '}';
    }

    public Airlines getAirline() {
        return airline;
    }

    public void setAirline(Airlines airline) {
        this.airline = airline;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Cities getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(Cities arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Cities getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(Cities departureCity) {
        this.departureCity = departureCity;
    }
    public String prettyFormat(){
        return String.format("%s | %s -> %s | %s | %d $ | %d seats | %s",getSeries().toString(),getDepartureCity().toString(),getArrivalCity().toString(),dateToString(getDate()),getPrice(),getSeats(),getAirline().toString());
    }

    @Override
    public void write(OutputStream arg0) {

    }
    @Override
    public int getId() {
        return 0;
    }
}
