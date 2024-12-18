package model;// customer class -- represents a customer in the system, storing their details

import java.util.ArrayList;
import java.util.Objects;

public class Customer {

    private final String name;
    private String email;
    private String phone;
    private ArrayList<Pet> pets;


    public Customer (String name, String email, String phone, Pet pet) {

        pets = new ArrayList<>();
        this.name = name;
        this.email = email;
        this.phone = phone;
        pets.add(pet);
    }

    public Customer (String name, String email, String phone) {

        pets = new ArrayList<>();
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {return name;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public void addPet (Pet pet) {
        if (pet ==null) {
            System.out.println("Pet cannot be null.");
            return;
        }
        if (!pets.contains(pet)) {
            pets.add(pet);
            System.out.println("Pet added to customer.");
        }
        else {System.out.println("Pet already exists for the customer.");}
    }

    public void removePet(int petID) {
        pets.removeIf(pet -> pet.getId() == petID);
        System.out.println("Pet removed from customer.");}

    @Override
    public String toString() {return "Name of customer: " + name + ", email: " + email + ", phone: " + phone + ", pets: " + pets;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(phone, customer.phone)
                && Objects.equals(pets, customer.pets);
    }

    @Override
    public int hashCode() {return Objects.hash(name, email, phone, pets);}
}
