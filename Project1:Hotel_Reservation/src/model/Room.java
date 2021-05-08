package model;

public class Room implements IRoom{
    protected String roomNumber;
    protected Double price;
    protected RoomType roomType;
    protected Boolean isFree;

    public Room(String roomNumber, Double price, RoomType roomType, Boolean isFree){
     super();
     this.roomNumber = roomNumber;
     this.price = price;
     this.roomType = roomType;
     this.isFree = isFree;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }

    @Override
    public String toString(){
        return "Room Number: " + getRoomNumber() +
                " | Price: $ " + price +
                " | Room Type: " + getRoomType();
    }
}
