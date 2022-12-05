package characters;

import actions.Action;
import conditions.Condition;
import conditions.Feeling;
import entity.Entity;
import exceptions.CantActException;
import exceptions.NoTargetException;
import places.Place;

import java.util.ArrayList;
import java.util.Objects;

abstract public class Person extends Entity {

    public void addAction(Action action)
    {
        actions.add(action);
    }

    private final ArrayList<Action> actions;

    public Action getLastAction() {
        return lastAction;
    }

    private Action lastAction;

    public Place getPlace() {
        return place;
    }

    private Place place;

    public void setFeeling(Feeling feeling) {
        this.feeling = feeling;
    }

    protected Feeling getFeeling() {
        return feeling;
    }

    private Feeling feeling;

    private final ConditionChecker checker;

    public Person(String name, Place place, Feeling feeling) {
        super(name);
        this.place = place;
        if(!Objects.equals(place,null))
            place.addCharacter(this);
        this.feeling = feeling;
        actions = new ArrayList<>();
        checker = new ConditionChecker();
    }

    public Condition[] getCondition()
    {
        return new Condition[]{lastAction};
    }

    public boolean act()
    {
        if (actions.size() == 0) {
            throw new CantActException(getName());
        }
        int i = (int) (Math.random() * actions.size());
        var action = actions.get(i);
        while(true)
        {
            try {
                if (action.act()) break;
            } catch (NoTargetException ignored) {}
            i++;
            action = actions.get(i%actions.size());
            if(i > actions.size() * 3)
                return false;
        }
        lastAction = action;
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "name='" + getName() + '\'' +
                ", place=" + place.getName() +
                ", feeling=" + feeling +
                '}';
    }

    public void setPlace(Place nextPlace) {
        this.place = nextPlace;
    }

    public ConditionChecker getConditionChecker() {
        return checker;
    }

    public class ConditionChecker {

        public void checkCondition()
        {
            Condition[] condition = Person.this.getCondition();
            for (Condition value : condition) System.out.println("Персонаж " + Person.this.getName() + value.describe());
            System.out.println();
        }

        @Override
        public String toString() {
            return "ConditionChecker[]";
        }

        @Override
        public boolean equals(Object obj) {
            return true;
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

}
