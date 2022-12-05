package exceptions;

import java.util.Objects;

public class CantActException extends RuntimeException{
    public CantActException()
    {
        super();
    }
    public CantActException(String message)
    {
        super("Персонаж "+ message + " не может ничего делать, добавьте ему действия при помощи .addAction()");
    }

    @Override
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoTargetException e)) return false;
        return Objects.equals(getMessage(), e.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getMessage()+getClass().getName());
    }
}
