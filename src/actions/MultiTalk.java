package actions;

import characters.Person;
import exceptions.NoTargetException;

import java.util.Arrays;

final public class MultiTalk extends AbstractTalk{

    private final AbstractTalk[] talks;

    private int curTalk = 0;

    public MultiTalk(AbstractTalk... talks) {
        this.talks = talks;
    }

    @Override
    public boolean act() {
        try {
            while (curTalk < talks.length && !talks[curTalk].act())
                curTalk++;
        }catch (NoTargetException e)
        {
            return false;
        }
        if(curTalk >= talks.length) {
            return false;
        }
        return true;
    }

    @Override
    public String describe() {
        return talks[curTalk].describe();
    }

    @Override
    public String toString() {
        return "MultiTalk{" +
                "talks=" + Arrays.toString(talks) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MultiTalk multiTalk)) return false;
        return Arrays.equals(talks, multiTalk.talks);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(talks);
    }
}
