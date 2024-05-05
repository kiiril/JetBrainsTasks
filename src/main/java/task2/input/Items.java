package task2.input;
import java.util.Arrays;

public class Items {
    private String type;
    private AnotherProperties properties;
    private String[] required;
    private Boolean additionalProperties;

    public String getType() {
        return type;
    }

    public AnotherProperties getProperties() {
        return properties;
    }

    public String[] getRequired() {
        return required;
    }

    public Boolean getAdditionalProperties() {
        return additionalProperties;
    }

    @Override
    public String toString() {
        return "Items{" +
                "type='" + type + '\'' +
                ", properties=" + properties +
                ", required=" + Arrays.toString(required) +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
