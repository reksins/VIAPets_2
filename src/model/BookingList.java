package model;// BookingList class -- manages a collection of Booking objects, allowing for operations such as adding, cancelling,
// editing, and searching bookings
// it ensures proper organization and retrieval of booking info, supporting efficient integration with other components

import java.time.LocalDate;
import java.util.ArrayList;

public class BookingList {

    private ArrayList<Booking> bookings;

    public BookingList() {this.bookings = new ArrayList<>();}

    public boolean validDates(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            return false;
        }
        return !endDate.isBefore(startDate);
    }

    public void addBooking(Booking booking) {
        if (booking == null) {
            System.out.println("Booking cannot be null.");
            return;
        }
        for (Booking b : bookings) {
            if (b.getBookingId().equals(booking.getBookingId())) {
                System.out.println("Booking already exists.");
                return;
            }}
        bookings.add(booking);
        System.out.println("Booking added successfully.");
    }

    public void cancelBooking(String bookingId) {
        boolean removed = false;
        for (Booking b : new ArrayList<>(bookings)) {
            if (b.getBookingId().equals(bookingId)) {
                bookings.remove(b);
                removed = true;
                System.out.println("Booking removed.");
                break;
            }}
        if (!removed) {
            System.out.println("Booking not found.");
        }}

    public Booking findBooking(String bookingId) {
        for (Booking b : bookings) {
            if (b.getBookingId().equals(bookingId)) {return b;}
            }
        System.out.println("Booking not found.");
        return null;
    }

    public void editBooking(String bookingId, LocalDate newStartDate, LocalDate newEndDate, Pet newPet ) {
        Booking booking = findBooking(bookingId);

        if (booking== null) {
            System.out.println("Booking not found.");
            return;}

        if (!validDates(newStartDate, newEndDate)) {
            System.out.println("Invalid dates.");
            return;}

        if ("kennel".equalsIgnoreCase(newPet.getPosition()) && numberOfBookings(newStartDate, newEndDate) >= 10) {
            System.out.println("Dates are unavailable.");
            return;}

        booking.setStartDate(newStartDate);
        booking.setEndDate(newEndDate);
        booking.setPet(newPet);
        System.out.println("Editing successful.");
    }

    public int numberOfBookings(LocalDate startDate, LocalDate endDate) {
        int count = 0;
        for (Booking booking : bookings) {
            if ("kennel".equalsIgnoreCase(booking.getPet().getPosition()) &&
                    !(endDate.isBefore(booking.getStartDate()) || startDate.isAfter(booking.getEndDate()))) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<Booking> getAllBookings() {return new ArrayList<>(bookings);}

    @Override
    public String toString() {return "List of bookings " + bookings;}
}
