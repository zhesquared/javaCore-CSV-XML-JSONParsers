import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CsvToJson {

    public static List<Employee> parseCSV(String[] columnMapping, String fileName) {
        try (CSVReader scvReader = new CSVReader(new FileReader(fileName))) {
            ColumnPositionMappingStrategy<Employee> strategy =
                    new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columnMapping);

            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(scvReader)
                    .withMappingStrategy(strategy)
                    .build();

            return csv.parse();

        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static String listToJson(List<Employee> staff) {
        Type listType = new TypeToken<List<Employee>>(){}.getType();
        return new Gson().toJson(staff, listType);
    }

    public static void writeString(String record, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(record);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
