package model;

import java.time.LocalDate;
import java.util.Objects;

public class VIAPets {

    private CustomerList customerList;
    private PetList petList;
    private BookingList bookingList;

    public VIAPets () {
        this.customerList = new CustomerList();
        this.petList = new PetList();
        this.bookingList = new BookingList();
    }

    public void addCustomer (Customer customer) {customerList.addCustomer(customer);}

    public void removeCustomer (String phone) {customerList.removeCustomer(phone);}

    public void editCustomer(String phone, String newPhone, String newEmail) {
        customerList.editCustomer(phone, newPhone, newEmail);}

    public Customer findCustomer(String phone) {return customerList.findCustomer(phone);}

    public void addBooking (Booking booking) {bookingList.addBooking(booking);}

    public void cancelBooking (String bookingId) {bookingList.cancelBooking(bookingId);}

    public void editBooking (String bookingId, LocalDate newStartDate, LocalDate newEndDate, Pet newPet) {
        bookingList.editBooking(bookingId, newStartDate, newEndDate, newPet);}

    public Booking findBooking (String id) {return bookingList.findBooking(id);}

    public void addPet (Pet pet) {petList.addPet(pet);}

    public void removePet (int id) {petList.removePet(id);}

    public void editPet (int id, int newPrice, int newAge, String newPosition, String newComment) {
        petList.editPet(id, newPrice, newAge, newPosition, newComment);}

    public Pet findPet (int id) {return petList.findPet(id);}


    @Override
    public String toString() {return "List of customers=" + customerList + ", List of pets=" + petList + ", List of bookings=" + bookingList;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VIAPets viaPets = (VIAPets) o;
        return Objects.equals(customerList, viaPets.customerList) && Objects.equals(petList, viaPets.petList)
                && Objects.equals(bookingList, viaPets.bookingList);}

    @Override
    public int hashCode() {return Objects.hash(customerList, petList, bookingList);}
}
