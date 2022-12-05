package exceptions;

import entity.Entity;

import java.util.Objects;

public class NoTargetException extends Exception {
    public NoTargetException(String message)
    {
        super(message);
    }
    public NoTargetException()
    {
        super();
    }

    @Override
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoTargetException e)) return false;
        if (o.getClass() != getClass()) return false;
        return Objects.equals(getMessage(), e.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getMessage()+getClass().getName());
    }
}
