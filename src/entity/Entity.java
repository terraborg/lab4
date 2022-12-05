package entity;

import java.util.Objects;

public abstract class Entity implements Named {
    protected Entity(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    private final String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity entity)) return false;
        if (o.getClass() != getClass()) return false;
        return Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "name='" + getName() + '\'' +
                '}';
    }
}
