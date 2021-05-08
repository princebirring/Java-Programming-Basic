package api;

import model.*;
import service.*;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    static CustomerService customerService = new CustomerService();
    static ReservationService reservationService = new ReservationService();

    //Create a method getCustomer to retrieve the customer from the collection using email.
    //Customer Service
    public static Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    //Create a method createACustomer to add the customer object to the Customer Collection
    //Customer Service
    public static void createACustomer(String email, String firstName, String lastName){
        customerService.addCustomer(email, firstName, lastName);
    }

    //Create a method getRoom to get the room object from the collections using roomNumber.
    //Reservation Service
    public static IRoom getRoom(String roomNumber){
        return reservationService.getARoom(roomNumber);
    }

    //Create a method bookARoom to reserve a room
    //Customer Service - Retrieve customer object using getCustomer() - param -- email
    //Reservation Service - Store reservation object - param -- customer, room, checkInDate, checkOutDate
    public static Reservation bookARoom(String customerEmail, IRoom room,
                                        Date checkInDate, Date checkOutDate){
        Customer customer = customerService.getCustomer(customerEmail);
        return reservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    //Create a method getCustomerReservations to return customer reservation
    //Customer Service - Retrieve customer object using getCustomer() - param -- email
    //Reservation Service - Retrieve Reservation collection by customer
    public static Collection<Reservation> getCustomersReservations(String customerEmail){
        Customer customer = customerService.getCustomer(customerEmail);
        return reservationService.getCustomersReservation(customer);
    }

    //Create a method findARoom to return all the available rooms
    //Reservation Service - param -- checkInDate, checkOutDate
    public static Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate){
        return reservationService.findRooms(checkInDate, checkOutDate);
    }



}
