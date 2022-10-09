import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class XmlToJson {
    public static List<Employee> parseXml(String fileName) {
        try {
            List<Employee> staffList = new ArrayList<>();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fileName);

            Node root = doc.getDocumentElement();
            NodeList staff = root.getChildNodes();

            for (int i = 0; i < staff.getLength(); i++) {
                Node node = staff.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    Element element = (Element) node;
                    Employee employee = new Employee();
                    employee.id = Long.parseLong(element.getElementsByTagName("id").item(0).getTextContent());
                    employee.firstName = element.getElementsByTagName("firstName").item(0).getTextContent();
                    employee.lastName = element.getElementsByTagName("lastName").item(0).getTextContent();
                    employee.country = element.getElementsByTagName("country").item(0).getTextContent();
                    employee.age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());
                    staffList.add(employee);
                }
            }
            return staffList;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

}
