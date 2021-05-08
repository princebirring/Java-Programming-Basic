import model.*;
import service.*;
import api.AdminResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.List;

public class AdminMenu {
    static AdminResource adminResource = new AdminResource();
    static int navigateToMainMenu = 6;

    //Create a method getAllCustomer to return all the customer stored in the collection
    public static void getAllCustomers(){
        Collection<Customer> customers = adminResource.getAllCustomers();
        if (!customers.isEmpty()){
            for (Customer customer: customers){
                System.out.println(customer.toString());
            }
        }else{
            System.out.println("No Customer is stored in the Collection!");
        }
    }

    //Create a method getAllRooms to return all the rooms stored in the collection
    public static void getAllRooms(){
        Collection<IRoom> rooms = adminResource.getAllRooms();
        if (!rooms.isEmpty()){
            for (IRoom room: rooms){
                System.out.println(room.toString());
            }
        }else{
            System.out.println("No Room is stored in the Collection!");
        }
    }

    //Create a method getAllReservations to return all the reservation stored in the collection
    public static void getAllReservations(){
        Collection<Reservation> reservations = adminResource.getAllReservations();
        for (Reservation reservation: reservations){
            System.out.println(reservation.toString());
        }
    }

    //Create a method addARoom to store a room in the collection
    public static void addARoom(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the room number: ");
        String roomNumber = scanner.next();
        RoomType roomType = null;
        Integer type;
        do {
            System.out.println("Enter Room Type: 1 - Single and 2 - Double ");
            type = scanner.nextInt();
            if (type == 1) {
                roomType = RoomType.SINGLE;
            } else if (type == 2) {
                roomType = RoomType.DOUBLE;
            } else {
                System.out.println("Invalid Input");
            }
        }while(type != 1 && type != 2);
        System.out.println("Enter the room price: $ ");
        Double price = scanner.nextDouble();
        Boolean isFree = true;
        IRoom room = new Room(roomNumber, price, roomType, isFree);
        List<IRoom> rooms = new ArrayList<>();
        rooms.add(room);
        adminResource.addRooms(rooms);
    }

    public static void startAdmin() {
        Scanner scanner = new Scanner(System.in);
        int selection = 0;
        while (selection != navigateToMainMenu) {
            switch (selection) {
                case 1:
                    System.out.println("Request All Customers");
                    getAllCustomers();
                    break;
                case 2:
                    System.out.println("Request All Rooms");
                    getAllRooms();
                    break;
                case 3:
                    System.out.println("Request All Reservations");
                    getAllReservations();
                    break;
                case 4:
                    System.out.println("Add a room");
                    addARoom();
                case 5:
                    MainMenu.mainMenu();
                    return;
            }
            System.out.println("Admin Menu");
            System.out.println("1 - All Customer List");
            System.out.println("2 - All Room List");
            System.out.println("3 - All Reservations");
            System.out.println("4 - Add a Room");
            System.out.println("5 - Return to Main");
            selection = scanner.nextInt();
        }
    }



}