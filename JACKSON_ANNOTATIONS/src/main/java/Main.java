import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.SneakyThrows;

import java.io.StringWriter;
import java.util.Map;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        Cat cat = new Cat(2, 4.5,
                Map.of("Morning", "Jumping",
                        "Afternoon", "Eating",
                        "Evening", "Crying",
                        "Night", "Sleeping"),
                "Oliver",
                "{\"hobbie\":\"purr\"}");

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerFor(Cat.class);
        StringWriter stringWriter = new StringWriter();
        objectWriter.writeValue(stringWriter, cat);

        System.out.println(stringWriter);
    }
}
