package conditions;

public enum Feeling implements Condition{
    NONE("себя как обычно"),
    DEJAVU("что где-то видел что-то похожее");

    private final String description;

    Feeling(String description)
    {
        this.description = description;
    }
    @Override
    public String describe()
    {
        return " чувствует " + description;
    }

    @Override
    public String toString() {
        return "Feeling{" +
                "description='" + description + '\'' +
                '}';
    }
}

