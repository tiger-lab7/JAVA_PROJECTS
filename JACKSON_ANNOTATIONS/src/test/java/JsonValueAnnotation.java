import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class JsonValueAnnotation {

    enum MyEnum {
        TYPE1(1, "Type 1"), TYPE2(2, "Type 2");
        private int id;
        private String name;
        MyEnum(int i, String s) {
            this.id = i;
            this.name = s;
        }


        @JsonValue // Сериализует возврат данного метода как единственное значение в итоговом JSON
        public String getName() {
           return name;
        }
    }

    @Test
    public void whenSerializingUsingJsonValue_thenCorrect() throws IOException {

        String enumAsString = new ObjectMapper()
                .writeValueAsString(MyEnum.TYPE1);
        System.out.println(enumAsString);
        Assertions.assertEquals(enumAsString, "\"Type 1\"");
    }
}
