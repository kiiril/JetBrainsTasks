package task2.json;

import java.util.*;
import java.util.stream.Collectors;

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

        if (!Objects.equals(hash, problem.hash)) return false;
        List<String> l1 = new ArrayList<>(Arrays.asList(data));
        List<String> l2 = new ArrayList<>(Arrays.asList(problem.data));

        Collections.sort(l1);
        Collections.sort(l2);

        return l1.equals(l2);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "hash='" + hash + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
