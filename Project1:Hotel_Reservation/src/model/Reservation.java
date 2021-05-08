package model;

import java.util.Date;
import model.Customer;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        super();
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public IRoom getRoom(){
        return room;
    }

    public void setRoom(IRoom room){
        this.room = room;
    }

    public Date getCheckInDate(){
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate){
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate(){
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate){
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString(){
        return "Customer First Name: " + getCustomer().getFirstName() + " Last Name: " + getCustomer().getLastName()
                + " | Room Number: " + getRoom().getRoomNumber() + " | Check in Date: " + getCheckInDate()
                + " | Check out Date: " + getCheckOutDate();
    }

}
