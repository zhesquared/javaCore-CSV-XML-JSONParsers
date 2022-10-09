import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JsonParser {
    public static String readString(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String nextItem;
            StringBuilder result = new StringBuilder();

            while ((nextItem = reader.readLine()) != null) {
                result.append(nextItem.trim());
            }
            return result.toString();
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static List<Employee> jsonToList(String json) {
        return new Gson().fromJson(json, new TypeToken<List<Employee>>() {}.getType());
    }
}
