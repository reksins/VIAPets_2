package model;

import java.util.Objects;

public class DogsAndCats extends Pet
{

    private final String breed;
    private final String breeder;

    public DogsAndCats (String name, double price, String colour, String gender, double age, String position, String comment, int id, String breed, String breeder) {

        super (name, price, colour, gender,age, position, comment, id);
        this.breed = breed;
        this.breeder = breeder;
    }

    public String getBreed() {return breed;}

    public String getBreeder() {return breeder;}

    @Override
    public String toString() {return " Breed= " + breed + ", breeder= " + breeder ;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DogsAndCats that = (DogsAndCats) o;
        return Objects.equals(breed, that.breed) && Objects.equals(breeder, that.breeder);
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), breed, breeder);}
}
