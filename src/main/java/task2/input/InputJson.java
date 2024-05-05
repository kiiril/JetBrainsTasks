package task2.input;

import java.util.Arrays;

public class InputJson {
    private String type;
    private Properties properties;
    private String[] required;
    private Boolean additionalProperties;

    public String getType() {
        return type;
    }

    public Properties getProperties() {
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
        return "InputJson{" +
                "type='" + type + '\'' +
                ", properties=" + properties +
                ", required=" + Arrays.toString(required) +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
