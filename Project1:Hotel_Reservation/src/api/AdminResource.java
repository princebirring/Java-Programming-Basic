package api;

import model.*;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    static CustomerService customerService = new CustomerService();
    static ReservationService reservationService = new ReservationService();

    //Create a method getCustomer to return a customer object
    //Customer Service - param -- email
    public static Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    //Create a method getAllCustomers to return all the customers
    //Customer Service
    public static Collection<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }

    //Create a method addRooms to store room object in the collection
    //Reservation Service - param -- List of room object
    public static void addRooms(List<IRoom> rooms){
        for (IRoom room: rooms){
            reservationService.addRoom(room);
        }
    }

    //Create a method getAllRooms to return all the rooms
    //Reservation Service
    public static Collection<IRoom> getAllRooms(){
        return reservationService.getAllRooms();
    }

    //Create a method getAllReservations to return all the reservations
    //Reservation Service
    public static Collection<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }


}
