import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

public class JsonSerializeAnnotation {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    class User {
        int id;
        String name;
        @JsonSerialize(using = CustomDateSerializer.class)
        Date addDate;
    }

    class CustomDateSerializer extends StdSerializer<Date> {

        protected CustomDateSerializer(Class<Date> t) {
            super(t);
        }

        @Override
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                throws IOException {

        }
    }

    @Test
    void testJsonSerializeAnnotation() {

    }
}
