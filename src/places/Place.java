package places;

import characters.Person;
import entity.Entity;
import things.Sightable;
import things.Thing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

abstract public class Place extends Entity {
    public ArrayList<Person> getCharacters() {
        return characters;
    }

    ArrayList<Person> characters = new ArrayList<>();

    public Sightable[] getSightables() {
        return things;
    }

    private final Thing[] things;

    public Place[] getNearPlaces() {
        return nearPlaces;
    }

    private Place[] nearPlaces;

    public Place(String name, Thing... things)
    {
        super(name);
        this.things = things;
        nearPlaces = new Place[0];
    }

    public void setNearPlaces(Place... places)
    {
        nearPlaces = places;
    }

    public void removeCharacter(Person character)
    {
        characters.remove(character);
    }

    public void addCharacter(Person character) {
        characters.add(character);
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                ", characters=" + Arrays.toString(new ArrayList[]{characters}) +
                ", things=" + Arrays.toString(things) +
                ", name='" + getName() + '\'' +
                '}';
    }
}
