import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.util.Map;

public class Jackson_and_XML {
    @SneakyThrows
    public static void main(String[] args) {

        Cat cat = new Cat(2, 4.5,
                Map.of("Morning", "Jumping",
                        "Afternoon", "Eating",
                        "Evening", "Crying",
                        "Night", "Sleeping"),
                "Oliver",
                "{\"hobbie\":\"purr\"}");

        File file = new File("src/main/resources/testxml.xml");

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); // Делает отступы
        xmlMapper.writeValue(file, cat);
    }
}
