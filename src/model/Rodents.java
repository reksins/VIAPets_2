package model;

import java.util.Objects;

public class Rodents extends Pet {

    private final String species;
    private final boolean ifBite;

    public Rodents (String name, double price, String colour, String gender, double age, String position, String comment, int id, boolean ifBite, String species) {

        super (name, price, colour, gender, age, position, comment, id);
        this.ifBite = ifBite;
        this.species = species;
    }

    public String getSpecies() {return species;}

    public boolean getIfBite() {return ifBite;}

    @Override
    public String toString() {return "Species= " + species + ", does it bite= " + ifBite ;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rodents rodents = (Rodents) o;
        return ifBite == rodents.ifBite && Objects.equals(species, rodents.species);
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), species, ifBite);}
}
