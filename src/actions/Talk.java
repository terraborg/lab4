package actions;

import characters.Person;
import exceptions.NoTargetException;
import places.Place;

import java.util.Arrays;
import java.util.Objects;

final public class Talk extends AbstractTalk{

    private final Person person;

    private Person lastTarget;

    private final Replics replics;

    public Talk(Person person, boolean isReplicsHasEnd, String... replics) {
        this.person = person;
        this.replics = new Replics(isReplicsHasEnd, replics);
    }

    @Override
    public boolean act() throws NoTargetException {
        Place place = person.getPlace();
        if(place.getCharacters().size() <=1)
            throw new NoTargetException();
        if(!replics.hasReplics())
            return false;
        int i = (int) (place.getCharacters().size()*Math.random());
        Person target = place.getCharacters().get(i);
        while(target.equals(person)) {
            i++;
            target = place.getCharacters().get(i%place.getCharacters().size());
            if(i > place.getCharacters().size() * 2)
                return false;
        }
        replics.getReplic();
        lastTarget = target;
        return true;
    }
    @Override
    public String describe() {
        return  " сказал " + replics.getLastReplic() + " персонажу " + lastTarget.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Talk talk)) return false;
        return Objects.equals(person, talk.person) && Objects.equals(replics, talk.replics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person.toString() + getClass().getName());
    }

    @Override
    public String toString() {
        return "Talk{" +
                "person=" + person.getName() +
                ", replics=" + replics +
                '}';
    }

    static final private class Replics {
        private final String[] replics;
        private final boolean isReplicsHasEnd;

        private int curReplic;

        private String lastReplic;

        public Replics(boolean isReplicsHasEnd,String... replics) {
            this.replics = replics;
            this.isReplicsHasEnd = isReplicsHasEnd;
            curReplic = 0;
        }

        public boolean hasReplics()
        {
            return curReplic != replics.length;
        }

        public String getReplic() {
            String replic = replics[curReplic];
            curReplic++;
            if(!isReplicsHasEnd)
                curReplic%=replics.length;
            lastReplic = replic;
            return replic;
        }

        public String getLastReplic() {
            return lastReplic;
        }

        @Override
        public String toString() {
            return "Replics{" +
                    "replics=" + Arrays.toString(replics) +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Replics replics1)) return false;
            return isReplicsHasEnd == replics1.isReplicsHasEnd && Arrays.equals(replics, replics1.replics);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Arrays.hashCode(replics), isReplicsHasEnd);
        }
    }
}
