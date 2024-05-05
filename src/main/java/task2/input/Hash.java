package task2.input;

public class Hash {
    private String type;
    private String description;

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Hash{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
