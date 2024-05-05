package task2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import task2.input.InputJson;
import task2.output.OutputJson;
import task2.output.Problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] files = scanner.nextLine().split(" ");
        Path firstInputPath = Path.of(files[0]);
//        Path secondInputPath = Path.of(files[1]);
        Path firstOutputPath = Path.of(files[2]);
//        Path secondOutputPath = Path.of(files[3]);
//        Path bothOutputPath = Path.of(files[4]);
        Gson gson = new Gson();
        try {
            // read the json file and parse to POJO
            JsonReader reader = new JsonReader(Files.newBufferedReader(firstInputPath));
            InputJson inputJson = gson.fromJson(reader, InputJson.class);

            // retrieve data needed for output
            String hash = inputJson.getProperties().getProblems().getItems().getProperties().getHash().getDescription();
            String[] data = inputJson.getProperties().getProblems().getItems().getProperties().getData().getDescription().split(" ");

            // create POJO output object, convert to json and write to the file
            Problems problems = new Problems(hash, data);
            OutputJson outputJson = new OutputJson(new Problems[]{problems});
            gson.toJson(outputJson, Files.newBufferedWriter(firstOutputPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
