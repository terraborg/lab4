package characters;

import actions.AbstractTalk;
import actions.Talk;
import conditions.Feeling;
import places.Place;

abstract public class TalkingPerson extends Person{
    public TalkingPerson(String name, Place place, Feeling feeling) {
        super(name, place, feeling);
        AbstractTalk talk = createTalkAction();
        for(int i = 0; i < 10; i++)
            addAction(talk);
    }
    abstract protected AbstractTalk createTalkAction();
}
