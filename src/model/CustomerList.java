package model;

// CustomerList class -- manages a collection of Customer objects, allowing for operations such as adding, removing,
// editing, and searching customers
// it ensures proper organization and retrieval of customer data, supporting efficient integration with other components
// like bookings and pet management.

import java.util.ArrayList;

public class CustomerList {

    private ArrayList<Customer> customers;

    public CustomerList() {this.customers = new ArrayList<>();}

    public void addCustomer(Customer customer) {
        for (Customer c : customers) {
            if (c.getPhone().equals(customer.getPhone())) {
                System.out.println("Customer already in the system."); //when a duplicate is found
                return;
            }
        }
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    public void removeCustomer(String phone) {
        boolean removed= false;
        for (Customer c : new ArrayList<>(customers)) {
            if (c.getPhone().equals(phone)) {
                customers.remove(c);
                removed= true;
                System.out.println("Customer removed successfully.");
                break;
            }}
            if (!removed){System.out.println("Customer removed unsuccessfully.");
            }}

    public Customer findCustomer(String phone) {
        for (Customer c : customers) {
            if (c.getPhone().equals(phone)) {return c;}
            else {
                System.out.println("Customer not found.");
        }
        return null;
    }
        return null;
    }

    public void editCustomer(String phone, String newPhone, String newEmail) {
        Customer customer = findCustomer(phone);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        customer.setPhone(newPhone);
        customer.setEmail(newEmail);
        System.out.println("Customer editing successful.");
    }

    public ArrayList<Customer> getAllCustomers() {return new ArrayList<>(customers);}

    @Override
    public String toString() {return "List of customers: " + customers;}
}
