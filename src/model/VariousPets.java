package model;

import java.util.Objects;

public class VariousPets extends Pet
{

    private String species;

    public VariousPets (String name, double price, String colour, String gender, double age, String position, String comment, int id, String species) {

        super (name, price, colour, gender, age, position, comment, id);
        this.species = species;
    }

    public String getSpecies() {return species;}

    public void setSpecies(String species) {this.species = species;}

    @Override
    public String toString() {return "Species= " + species ;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VariousPets that = (VariousPets) o;
        return Objects.equals(species, that.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), species);
    }
}
