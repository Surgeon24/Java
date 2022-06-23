package m.ermolaev.findWord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class findWord {

    public static Map<String, String> fileToMap(String filePath) {
        Map<String, String> map = new HashMap<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                String[] keyValuePair = line.split("\\|");
                if (keyValuePair.length == 2) {
                    String key = keyValuePair[0];
                    String value = keyValuePair[1];
                    map.put(key, value);
                } else {
                    throw new IOException();
                }
            }
        } catch (IOException e) {
            System.err.print("Dictionary doesn't exist: " + filePath + "\n");
            return null;
        }
        return map;
    }

    public String findWord(String input, String from, String to){
        if (from.equals(to)){
            return "*choose different dictionaries*";
        }
        String link = "src/m/ermolaev/dictionary/" + from + "-" + to + ".dsv";
        Map<String, String> map = new HashMap<>();
        map = fileToMap(link);
        if (map == null)
            return "";

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (input.equals(entry.getKey())){
                return entry.getValue();
            }
        }
        return "*Word not found*";
    }
}
