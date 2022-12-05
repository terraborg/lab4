package actions;

import conditions.Condition;
import exceptions.NoTargetException;

public interface Action extends Condition {
    boolean act() throws NoTargetException;
}
