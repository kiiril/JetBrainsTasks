package task2;

import com.google.gson.Gson;
import task2.json.AnalysisResult;
import task2.json.Problem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    private final static Gson gson;
    static {
        gson = new Gson();
    }
    public static void main(String[] args) {
        // read file paths from console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path[] inputFiles = new Path[2];
        Path[] outputFiles = new Path[3];
        try {
            for (int i = 0; i < inputFiles.length; i++) {
                inputFiles[i] = Path.of(reader.readLine());
            }
            for (int i = 0; i < outputFiles.length; i++) {
                outputFiles[i] = Path.of(reader.readLine());
            }
            // retrieve json from the first analysis file
            AnalysisResult analysisResult1 = gson.fromJson(Files.newBufferedReader(inputFiles[0]), AnalysisResult.class);
            // retrieve json from the second analysis file
            AnalysisResult analysisResult2 = gson.fromJson(Files.newBufferedReader(inputFiles[1]), AnalysisResult.class);
            // remove duplicated problems
            Set<Problem> distinctProblems = new HashSet<>();
            distinctProblems.addAll(Arrays.stream(analysisResult1.getProblems()).toList());
            distinctProblems.addAll(Arrays.stream(analysisResult2.getProblems()).toList());
            AnalysisResult analysisResult3 = new AnalysisResult(distinctProblems.toArray(new Problem[]{}));

            // write all results to output files
            writeToFile(analysisResult1, outputFiles[0]);
            writeToFile(analysisResult2, outputFiles[1]);
            writeToFile(analysisResult3, outputFiles[2]);
        } catch (IOException e) {
            System.out.println("Cannot read from specified file: " + e.getMessage());
        }
    }

    private static void writeToFile(AnalysisResult analysisResult, Path path) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            gson.toJson(analysisResult, writer);
        } catch (IOException e) {
            System.out.println("Cannot write to specified file: " + e.getMessage());
        }
    }
 }
