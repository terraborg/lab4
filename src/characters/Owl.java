package characters;

import actions.AbstractTalk;
import actions.Move;
import actions.MultiTalk;
import actions.Talk;
import conditions.Condition;
import conditions.Feeling;
import places.Place;

import java.util.ArrayList;

public class Owl extends TalkingPerson{
    public Owl(Place place) {
        super("Сова", place, Feeling.NONE);
        addAction(new Move(this));
    }

    @Override
    protected MultiTalk createTalkAction() {
        ArrayList<String> replics = new ArrayList<>();
        int countOfReplics = (int) (Math.random()*4 + 3);
        int lengthOfWords = 10 + (int)(Math.random()*5);
        for(int i = 0; i < countOfReplics; i++) {
            replics.add("очень длинное слово из " + lengthOfWords + " букв");
            lengthOfWords+= (int)(Math.random()*2+1);
        }
        Talk talk1 = new Talk(this, true, replics.toArray(new String[replics.size()]));

        replics.clear();

        class ChristopherRobin extends Person{
            public ChristopherRobin() {
                super("Кристофер Робин", null, Feeling.NONE);
            }

            @Override
            public Condition[] getCondition() {
                return new Condition[]{() -> " должен написать это объявление"};
            }
        }

        ChristopherRobin christopherRobin = new ChristopherRobin();

        Talk talk2 = new Talk(this, true, "что " + christopherRobin.getName()  + christopherRobin.getCondition()[0].describe());
        Talk talk3 = new Talk(this,false,"что-то");

        return new MultiTalk(talk1,talk2,talk3);
    }
}
