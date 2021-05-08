import api.HotelResource;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MainMenu {
    static HotelResource hotelResource = new HotelResource();
    private static final CustomerService customerService = new CustomerService();
    private static final ReservationService reservationService = new ReservationService();

    //Create a method findAReservation
    public static void findAReservation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer Email Id");
        String email = scanner.next();
        System.out.println(HotelResource.getCustomersReservations(email));
    }

    //Create a method to Format Date
    public static Date dateFormatter(String dateString){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            return simpleDateFormat.parse(dateString);
        }catch (ParseException e){
            throw new IllegalArgumentException("Pass Date in DD/MM/YYYY Format");
        }
    }

    //Create a method findAndReserveARoom
    public static void findAndReserveARoom(){
        Scanner scanner = new Scanner(System.in);
        Date checkInDate = new Date();
        Date checkOutDate = new Date();
        System.out.println("Enter your arrival date[DD/MM/YYYY]:");
        String checkInDateString = scanner.next();
        checkInDate = dateFormatter(checkInDateString);
        System.out.println("Enter your check date[DD/MM/YYYY]:");
        String checkOutDateString = scanner.next();
        checkOutDate = dateFormatter(checkOutDateString);
        System.out.println("Available Rooms: ");
        System.out.println(HotelResource.findARoom(checkInDate, checkOutDate));
        System.out.println("Enter a Room Number: ");
        String roomNumber = scanner.next();
        IRoom room = HotelResource.getRoom(roomNumber);
        System.out.println("Enter Customer email: ");
        String email = scanner.next();

        HotelResource.bookARoom(email, room, checkInDate, checkOutDate);
        System.out.println("Your Reservation for room number" + roomNumber + "has been booked from " + checkInDateString + " to " + checkOutDate);
    }

    //Create a method to createAccount
    public static void createAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name: ");
        String firstName = scanner.next();
        System.out.println("Enter Last Name: ");
        String lastName = scanner.next();
        System.out.println("Enter Email: ");
        String email = scanner.next();
        HotelResource.createACustomer(email, firstName, lastName);
        System.out.println("Account Created!");
    }

    //
    public static void Menu(){
        System.out.println("Welcome Hotel Reservation System");
        System.out.println("1 - Find and reserve a room");
        System.out.println("2 - See my reservations");
        System.out.println("3 - Create an account");
        System.out.println("4 - Admin");
        System.out.println("5 - Exit");
    }

    public static void mainMenu() {
        Menu();
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        while (selection != 5) {
            switch (selection) {
                case 1:
                    System.out.println("Make a new Reservation");
                    findAndReserveARoom();
                    break;
                case 2:
                    System.out.println("View your Reservations");
                    findAReservation();
                    break;
                case 3:
                    System.out.println("Create a new Account");
                    createAccount();
                    break;
                case 4:
                    System.out.println("Admin Menu");
                    AdminMenu.startAdmin();
                    return;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Incorrect Input");
                    break;
            }
            Menu();
            selection = scanner.nextInt();
        }
    }
    public static void main(String[] args) {
        mainMenu();
    }
}
