package actions;

import characters.Person;
import places.Place;

import java.util.Objects;

final public class Move implements Action{

    private final Person person;
    private Place lastPlace;

    public Move(Person person) {
        this.person = person;
    }

    @Override
    public boolean act() {
        Place place = person.getPlace();
        if(place.getNearPlaces().length == 0)
            return false;
        Place nextPlace = place.getNearPlaces()[(int) (Math.random()*place.getNearPlaces().length)];
        place.removeCharacter(person);
        nextPlace.addCharacter(person);
        person.setPlace(nextPlace);
        lastPlace = place;
        return true;
    }
    @Override
    public String describe() {
        return " перешел из " + lastPlace.getName() + " в " + person.getPlace().getName();
    }



    @Override
    public String toString() {
        return "Move{" +
                "person=" + person +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Move move)) return false;
        return Objects.equals(person, move.person) && Objects.equals(lastPlace, move.lastPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person,getClass().getName());
    }
}
