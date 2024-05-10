package task2.json;

import java.util.Arrays;
import java.util.Objects;

public class Problem {
    private String hash;
    private String[] data;

    public Problem(String hash, String[] data) {
        this.hash = hash;
        this.data = data;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    // needed to distinguish between same and different problems
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Problem problem = (Problem) object;

        return Objects.equals(hash, problem.hash);
    }

    @Override
    public int hashCode() {
        return hash != null ? hash.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "hash='" + hash + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}