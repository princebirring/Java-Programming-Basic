package model;

public class Driver {
    public static void main(String args[]){
        //Test Case: 1
        System.out.println("Test Case: 1");
        Customer customer1 = new Customer("first", "last", "j@domain.com");
        System.out.println(customer1);

        //Test Case: 2
        System.out.println("Test Case: 2");
        Customer customer2 = new Customer("first", "last", "email");
        System.out.println(customer2);
    }
}
