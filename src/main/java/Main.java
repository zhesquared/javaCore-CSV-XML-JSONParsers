import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        String fileNameForJSON = "data.json";

        List<Employee> list = CsvToJson.parseCSV(columnMapping, fileName);
        String json = CsvToJson.listToJson(list);
        CsvToJson.writeString(json, fileNameForJSON);

    }
}
