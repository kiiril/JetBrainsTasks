package task2.input;

public class Data {
    private String type;
    private String description;
    private AnotherItems items;

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public AnotherItems getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Data{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", items=" + items +
                '}';
    }
}
