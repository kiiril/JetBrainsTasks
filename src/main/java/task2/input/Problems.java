package task2.input;
public class Problems {
    private String type;
    private Items items;

    public String getType() {
        return type;
    }

    public Items getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Problems{" +
                "type='" + type + '\'' +
                ", items=" + items +
                '}';
    }
}
