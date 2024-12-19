/* package model;

public class ModeManager {

    public static final String customerManagement = "CUSTOMER_MANAGEMENT";
    public static final String petManagement = "PET_MANAGEMENT";
    public static final String bookingManagement = "BOOKING_MANAGEMENT";

    private String currentMode;

    public ModeManager() {this.currentMode = customerManagement; }

    public String getCurrentMode() {return currentMode;}

    public void setMode(String mode) {
        if (!mode.equals(customerManagement) && !mode.equals(petManagement) && !mode.equals(bookingManagement)) {
            System.out.println("Invalid mode. Staying in " + currentMode + " mode.");
            return;
        }
        this.currentMode = mode;
        System.out.println("Switched to " + mode + " mode.");
    }

}
*/

package model; // handles the reading and writing the specific lists to a file, used to store and update information

import utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ModeManager
{
    private String fileName;

    public ModeManager(String fileName)
    {
        this.fileName = fileName;
    }

    // Use the utils.MyFileHandler class to retrieve a model.StudentList object with all Students
    public PetList getAllPetsFile()
    {
        PetList allPets = new PetList();

        try
        {
            allPets = (PetList) MyFileHandler.readFromBinaryFile(fileName);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("IO Error reading file");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class Not Found");
        }
        return allPets;
    }

    public BookingList getAllBookings()
    {
        BookingList allBookings = new BookingList();

        try
        {
            allBookings = (BookingList) MyFileHandler.readFromBinaryFile(fileName);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("IO Error reading file");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class Not Found");
        }
        return allBookings;
    }

    public CustomerList getAllCustomers()
    {
        CustomerList allCustomers = new CustomerList();

        try
        {
            allCustomers = (CustomerList) MyFileHandler.readFromBinaryFile(fileName);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("IO Error reading file");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class Not Found");
        }
        return allCustomers;
    }

    /* Return pets from a set species or if they are a store or kennel pet
    public PetList getStorePets(String position)
    {
        PetList PetsForSale = new PetList();
        PetList allPets = getAllPetsFile();

        for(int i = 0; i < allPets.getAllPetsFile().size(); i++)
        {
            if(allPets.(i).getCountry().equals(fromCountry))
            {
                studentsFromCountry.add(allStudents.get(i));
            }
        }

        return studentsFromCountry;
    } */

    // Use the utils.MyFileHandler class to save all Students in the model.StudentList object
    public void savePets(PetList pets)
    {
        try
        {
            MyFileHandler.writeToBinaryFile(fileName, pets);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("IO Error writing to file");
        }
    }

    public void saveCustomers(CustomerList customers)
    {
        try
        {
            MyFileHandler.writeToBinaryFile(fileName, customers);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("IO Error writing to file");
        }
    }

    public void saveBookings(BookingList bookings)
    {
        try
        {
            MyFileHandler.writeToBinaryFile(fileName, bookings);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            System.out.println("IO Error writing to file");
        }
    }

    // Change the country of the model.Student with the given firstname and lastname

 /*   public void changeCountry(String firstName, String lastName, String country)
    {
        StudentList allStudents = getAllStudents();

        for (int i = 0; i < allStudents.size(); i++)
        {
            Student student = allStudents.get(i);

            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
            {
                student.setCountry(country);
            }
        }

        savePets(allStudents);
    } */

    // Add more methods to the model manager depending on what you wish to do
}
