package model;// pet class -- serves as the base representation of a pet in the system;
// it defines the common attributes and behaviors that all pets share and acts as a foundation for specific types of pets,
// like dogs, cats, fish, birds, and rodents, which can extend the pet class

import java.util.Objects;

public class Pet {

    private final String name;
    private double price;
    private final String colour;
    private final String gender;
    private double age;
    private String position; //kennel or shop
    private String comment;
    private final int id;

    public Pet (String name, double price, String colour, String gender, double age, String position, String comment, int id) {

        this.name = name;
        this.price = price;
        this.age = age;
        this.colour = colour;
        this.gender = gender;
        this.position = position;
        this.comment = comment;
        this.id = id;
    }

    public String getColour() {return colour;}

    public String getName() {return name;}

    public double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public String getComment() {return comment;}

    public void setComment(String comment) {this.comment = comment;}

    public String getGender() {return gender;}

    public String getPosition() {return position;}

    public void setPosition(String position) {this.position = position;}

    public int getId() {return id;}

    public void setAge(double age) {this.age = age;}

    public double getAge() {return age;}

    @Override
    public String toString() {return "Name of pet: " + name + ", price: " + price + "DKK, colour: " + colour + ", gender: " +
            gender + ", position: " + position + ", comment: " + comment + ", id: " + id + ", age: " + age + " years." ;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Double.compare(price, pet.price) == 0 && Objects.equals(name, pet.name) && Objects.equals(colour, pet.colour)
                && Objects.equals(gender, pet.gender) && Objects.equals(position, pet.position) && Objects.equals(comment,
                pet.comment) && Objects.equals(id, pet.id) && Objects.equals(age, pet.age);}

    @Override
    public int hashCode() {return Objects.hash(name, price, colour, gender, age ,position, comment, id);}
}
