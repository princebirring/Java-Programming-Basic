package service;

import java.util.ArrayList;
import java.util.Collection;
import model.Customer;

public class CustomerService {
    //Create an empty Collection to store customer objects.
    public static Collection<Customer> customers = new ArrayList<>();

    //Create a method addCustomer to add customers to the Collection.
    public static void addCustomer(String email, String firstName, String lastName){
        Customer customer = new Customer(firstName, lastName, email);
        customers.add(customer);
        System.out.println(customers);
    }

    //Create a method getCustomer to retrieve the customer object from Collection using email.
    public static Customer getCustomer(String customerEmail){
        for (Customer customer: customers){
            if (customer.getEmail().equals(customerEmail)){
                return customer;
            }
        }
        return null;
    }

    //Create a method getAllCustomer to return all the objects stored in the Collection
    public static Collection<Customer> getAllCustomers(){
        return customers;
    }
}
