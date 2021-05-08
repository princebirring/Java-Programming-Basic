package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {

    //Create a empty Collection to store room objects and reserve objects.
    public static Set<IRoom> rooms = new HashSet<>();
    public static Set<Reservation> reservations = new HashSet<>();

    //Create a method addRoom to add a room object to the Collection.
    public static void addRoom(IRoom room){
        rooms.add(room);
    }

    //Create a method getARoom to retrieve the room object from the Collection using roomNumber.
    public static IRoom getARoom(String roomId){
        for (IRoom room: rooms){
            if (room.getRoomNumber().equals(roomId))
                return room;
        }
        return null;
    }

    //Create a method reserveARoom to reserve a room.
    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    //Create a method findRooms to find the available rooms
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        if (reservations.isEmpty()){
            return rooms;
        }else{
            List<IRoom> availableRooms = new ArrayList<>();
            for (Reservation reservation: reservations){
                if(!reservation.getCheckInDate().after(checkInDate) && !reservation.getCheckOutDate().before(checkOutDate)){
                    for (IRoom room: rooms){
                        if(! reservation.getRoom().equals(room)){
                            availableRooms.add(room);
                        }
                    }
                }
            }
            return availableRooms;

        }
    }

    //Create a method getAllRooms to return all the rooms
    public static Collection<IRoom> getAllRooms(){
        return rooms;
    }

    //Create a method getCustomersReservation to retrieve customers reservation
    public static Collection<Reservation> getCustomersReservation(Customer customer){
        List<Reservation> reservationsByCustomer = new ArrayList<>();
        for (Reservation reservation: reservations){
            if (reservation.getCustomer().equals(customer)){
                reservationsByCustomer.add(reservation);
            }
        }
        return reservationsByCustomer;
    }

    //Create a method to return all the reservations
    public static Set<Reservation> getAllReservations(){
        return reservations;
    }
}
