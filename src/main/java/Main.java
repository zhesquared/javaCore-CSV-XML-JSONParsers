import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileNameForCsv = "data.csv";
        String fileNameForJSON = "data.json";
        String fileNameForJSONFromXml = "data2.json";
        String fileNameForXml = "data.xml";

        List<Employee> list = CsvToJson.parseCSV(columnMapping, fileNameForCsv);
        String json = CsvToJson.listToJson(list);
        CsvToJson.writeString(json, fileNameForJSON);

        List<Employee> xmlList = XmlToJson.parseXml(fileNameForXml);
        String xml = CsvToJson.listToJson(xmlList);
        CsvToJson.writeString(xml, fileNameForJSONFromXml);

    }
}
