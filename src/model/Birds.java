package model;

import java.util.Objects;

public class Birds extends Pet {

    private final String species;
    private final String food; // changeable

    public Birds (String name, double price, String colour, String gender, double age,String position, String comment, int id, String food, String species) {

        super (name, price, colour, gender, age, position, comment, id);
        this.food = food;
        this.species = species;
    }

    public String getSpecies() {return species;}

    public String getFood() {return food;}

    @Override
    public String toString() {return "Species= " + species + ", food= " + food;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Birds birds = (Birds) o;
        return Objects.equals(species, birds.species) && Objects.equals(food, birds.food);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), species, food);
    }
}
