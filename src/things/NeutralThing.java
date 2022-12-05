package things;

import characters.Person;
import conditions.Feeling;

public class NeutralThing extends Thing{
    public NeutralThing(String name) {
        super(name);
    }

    @Override
    public void impress(Person person) {
        person.setFeeling(Feeling.NONE);
    }
}
