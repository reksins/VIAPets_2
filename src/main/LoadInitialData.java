/*package main;// import all models and utilities

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*public class LoadInitialData
{
   public static void main(String[] args)
   {
      bookingList bookings = new bookingList(); // creates bookings list from model class
      ArrayList<Object> bookingsArrayList; // initializes a new bookings Array

      try
      {
         bookingsArrayList = null; // replace this with our file handler utility reading from text file function
                      
         for(int i = 0; i< bookingsArrayList.length; i++)
         {
            String temp = (String) bookingsArrayList.get(i); // gets value from bookings array list
            ArrayList<Object> tempArr = new ArrayList<>(Arrays.asList(temp.split(",")));; // creates temporary arraylist for storing specific booking data from the text file, the array instances are separated by ","
            Customer Customer = (Customer) tempArr.get(0); // need a costumer, pet, booking model class
            bookings.add(new booking());
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File was not found, or could not be opened");
      }
     
      try
      {
         MyFileHandler.writeToBinaryFile("bookings.bin", bookings); // writes the bookings added in the loop to a bin file (faster in performance than txt)
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Error opening file ");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file ");
      }
      
      System.out.println("Done");
   }

      petList pets = new petList(); // creates pets list from model class
      String[] petsArray = null; // initializes a new pets Array

         try
      {
         petsArray = null; // replace this with our file handler utility reading from text file function

         for(int i = 0; i<petsArray.length; i++)
         {
            String temp = petsArray[i];
            String[] tempArr = temp.split(","); // creates temporary array for storing specific pet data from the text file
               /* we should divide if can the pets between types (dogscats, fish, etc)
               so we could sort them and the specific attributes they need already in the model class instead of main method */
            /*String name = tempArr[0];
            String species = tempArr[1];
            String age = tempArr[2];
            String storepet = tempArr[3];
            String gender = tempArr[4];
            String comment = tempArr[5];
               /* pets.add(new pet(whatever attributes we decide to store));
               here we create a new pet for each instance of pet the text file
                */
       /*  }
      }
         catch (FileNotFoundException e)
      {
         System.out.println("File was not found, or could not be opened");
      }

         try
      {
         MyFileHandler.writeToBinaryFile("pets.bin", pets); // writes the pets added in the loop to a bin file (faster in performance than txt)
      }
         catch (FileNotFoundException e)
      {
         System.out.println("Error opening file ");
      }
         catch (IOException e)
      {
         System.out.println("IO Error writing to file ");
      }

         System.out.println("Done");
   }
}
*/