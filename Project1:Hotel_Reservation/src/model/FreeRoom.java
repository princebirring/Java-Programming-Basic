package model;

public class FreeRoom extends Room{

    public FreeRoom(String roomNumber, Double price, RoomType roomType, Boolean isFree) {
        super(roomNumber, price, roomType, isFree);
        super.price = 0.00;
    }

    public String toString(){
        return "Room Number: " + super.getRoomNumber() +
                " | Price: $" + super.getRoomPrice() +
                " | Room Type: " + super.getRoomType();
    }
}
