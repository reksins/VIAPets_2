package model;

// CustomerList class -- manages a collection of Customer objects, allowing for operations such as adding, removing, editing,
// and searching customers
// it ensures proper organization and retrieval of customer data, supporting efficient integration with other components
// like bookings and pet management.

import java.util.ArrayList;

public class PetList {

    private ArrayList<Pet> pets;

    public PetList() {this.pets = new ArrayList<>();}

    public void addPet(Pet pet) {
        for (Pet p : pets) {
            if (p.getId() == pet.getId()) {
                System.out.println("Pet already in the system.");
                return;
            }
        }
        pets.add(pet);
        System.out.println("Pet added successfully.");
    }

    public void removePet(int id) {
        boolean removed = false;
        for (Pet pet : new ArrayList<>(pets)) {
            if (pet.getId() == id) {
                pets.remove(pet);
                removed = true;
                System.out.println("Pet removal successful.");
            }
        }
        if (!removed) {
            System.out.println("Pet removal unsuccessful.");
        }
    }

    public Pet findPet(int id) {
        for (Pet pet : pets) {
            if (pet.getId() == id ) {return pet;}}
        System.out.println("Pet ID not found.");
        return null;
    }

    public void editPet(int id, int newPrice, int newAge, String newPosition, String newComment) {
        Pet pet = findPet(id);
        if (pet== null) {
            System.out.println("Pet not found.");
            return;}
        pet.setPrice(newPrice);
        pet.setPosition(newPosition);
        pet.setAge(newAge);
        pet.setComment(newComment);
        System.out.println("Editing of pet successful.");
    }

    public ArrayList<Pet> getAllPets() {

        return new ArrayList<>(pets);

    }

    @Override
    public String toString() {return "List of pets " + pets;}
}
