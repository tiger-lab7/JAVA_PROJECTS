import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonRootNameAnnotation {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonRootName(value = "user") // Make json as {"user":{"id":7,"name":"Igor"}}
    class User {
        int id;
        String name;
    }

    @Test
    void testJsonRootNameAnnotation() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String jsonString = objectMapper.writeValueAsString(new User(7, "Igor"));
        System.out.println(jsonString);
        Assertions.assertEquals(jsonString, "{\"user\":{\"id\":7,\"name\":\"Igor\"}}");
    }
}
