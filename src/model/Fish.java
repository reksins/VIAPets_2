package model;

import java.util.Objects;

public class Fish extends Pet
{

    private final String typeFish;
    private final boolean ifPredator;
    private final String species;


    public Fish (String name, double price, String colour, String gender, double age, String position, String comment,int id, String typeFish, boolean ifPredator, String species) {

        super (name, price, colour, gender, age, position, comment, id);
        this.typeFish = typeFish;
        this.ifPredator = ifPredator;
        this.species = species;
    }

    public String getTypeFish() {return typeFish;}

    public boolean getIfPredator() {return ifPredator;}

    public String getSpecies() {return species;}

    @Override
    public String toString() {return "Fish type= " + typeFish + ", is it a predator= " + ifPredator + ", species= " + species;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fish fish = (Fish) o;
        return ifPredator == fish.ifPredator && Objects.equals(typeFish, fish.typeFish) && Objects.equals(species, fish.species);
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), typeFish, ifPredator, species);}
}
