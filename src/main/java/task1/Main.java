package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            names.add(reader.readLine());
        }
        String order = findAlphabetOrder(names);
        System.out.println(order);
    }

    private static String findAlphabetOrder(List<String> names) {
        StringBuilder order = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        boolean[][] swapped = new boolean[26][26]; // keep track of swapped pairs of letters

        for (int i = 0; i < names.size() - 1; i++) {
            String name1 = names.get(i);
            String name2 = names.get(i + 1);
            int minLength = Math.min(name1.length(), name2.length());
            int diffPos = 0;
            while (diffPos < minLength && name1.charAt(diffPos) == name2.charAt(diffPos)) {
                diffPos++;
            }
            if (diffPos < minLength) {
                char c1 = name1.charAt(diffPos);
                char c2 = name2.charAt(diffPos);
                int pos1 = order.indexOf(String.valueOf(c1));
                int pos2 = order.indexOf(String.valueOf(c2));

                if (pos2 < pos1) {
                    if (swapped[c2 - 'a'][c1 - 'a']) { // check if this pair has been swapped before
                        return "Impossible"; // cyclic dependency detected
                    }
                    swapped[c1 - 'a'][c2 - 'a'] = true; // Mark the pair as swapped
                    order.insert(pos1 + 1, c2);
                    order.deleteCharAt(pos2);
                }
            }
        }
        return order.toString();
    }
}