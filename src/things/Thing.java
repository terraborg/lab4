package things;

import characters.Person;
import conditions.Feeling;
import entity.Entity;

abstract public class Thing extends Entity implements Sightable {

    protected Thing(String name) {
        super(name);
    }

}
