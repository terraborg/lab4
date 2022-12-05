package places;

import characters.Person;
import conditions.Feeling;
import things.*;

final public class OutDoor extends Place{
    public OutDoor() {
        super("Улица", new NeutralThing("звонок"), new NeutralThing("объявление"),
                new NeutralThing("колокольчик"),
                new Thing("шнурок") {
                    @Override
                    public void impress(Person person) {
                        person.setFeeling(Feeling.DEJAVU);
                    }
                });
    }
}
