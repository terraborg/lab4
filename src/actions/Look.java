package actions;

import characters.Person;
import things.Sightable;

import java.util.ArrayList;
import java.util.Objects;

final public class Look implements Action{

    private Sightable sight;
    private final Person person;

    private ArrayList<Sightable> used = new ArrayList<>();

    public Look(Person person) {
        this.person = person;
    }

    @Override
    public boolean act() {
        var sightables = person.getPlace().getSightables();
        if(sightables.length == 0 || sightables.length == used.size())
            return false;
        int i = (int) (Math.random()* sightables.length);
        while(used.contains(sightables[i]))
            i = (i+1)%sightables.length;
        var sight = sightables[i];
        sight.impress(person);
        this.sight = sight;
        used.add(sight);
        return true;
    }
    @Override
    public String describe() {
        return " посмотрел на " + sight.getName();
    }

    @Override
    public String toString() {
        return "Look{" +
                "person=" + person +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Look look)) return false;
        return Objects.equals(sight, look.sight) && Objects.equals(person, look.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sight, person);
    }
}
