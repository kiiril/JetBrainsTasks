package task2.json;

import java.util.Arrays;

public class AnalysisResult {
    private Problem[] problems;

    public AnalysisResult(Problem[] problems) {
        this.problems = problems;
    }

    public Problem[] getProblems() {
        return problems;
    }

    public void setProblems(Problem[] problems) {
        this.problems = problems;
    }

    @Override
    public String toString() {
        return "AnalysisResult{" +
                "problems=" + Arrays.toString(problems) +
                '}';
    }
}
