package things;

import characters.Person;
import entity.Named;

public interface Sightable extends Named {
    void impress(Person person);
}
