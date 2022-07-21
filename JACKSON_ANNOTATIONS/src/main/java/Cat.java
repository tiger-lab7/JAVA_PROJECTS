import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
// Устанавливает порядок сериализации по имени полей в кавычках
@JsonPropertyOrder({"name", "age", "weight", "doings", "hobbies"})
public class Cat {
    @JsonProperty("возраст") // Меняет имя ключа
    int age;

    double weight;
    @JsonGetter("вес") // Меняет имя ключа, заставляет использовать геттер для получения занчения
    double getWeight() {
        return this.weight;
    }

    @JsonAnyGetter // Добавляет содержимое Map как ключ-значение плюсом к самой Map
    Map<String, String> doings;

    String name;

    @JsonRawValue // Воспринимать значение как сырую строку
    String hobbies;
}
