package model;

import java.time.LocalDate;
import java.util.Objects;

public class Booking {

    private LocalDate startDate;
    private LocalDate endDate;
    private final Customer customer;
    private Pet pet;
    private final String bookingId;

    public Booking( LocalDate startDate, LocalDate endDate, Customer customer, Pet pet, String bookingId) {
        if (startDate == null || endDate == null) {
            System.out.println("Start date and end date cannot be null.");
        }
        if (endDate.isBefore(startDate)) {
            System.out.println("End date cannot be before start date.");
        }
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.pet = pet;
        this.bookingId = bookingId;
    }

    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

    public LocalDate getStartDate() {return startDate;}

    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}

    public LocalDate getEndDate() {return endDate;}

    public Customer getCustomer() {return customer;}

    public void setPet(Pet pet) {this.pet = pet;}

    public Pet getPet() {return pet;}

    public String getBookingId() {return bookingId;}

    @Override
    public String toString() {return "Booking start date: " + startDate + ", end date: " + endDate +  ", "+customer + ", pet: " + pet + ", booking ID: " + bookingId + ".";}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(startDate, booking.startDate) && Objects.equals(endDate, booking.endDate)
                && Objects.equals(customer, booking.customer) && Objects.equals(pet, booking.pet)
                && Objects.equals(bookingId, booking.bookingId);}

    @Override
    public int hashCode() {return Objects.hash(startDate, endDate, customer, pet, bookingId);}
}

