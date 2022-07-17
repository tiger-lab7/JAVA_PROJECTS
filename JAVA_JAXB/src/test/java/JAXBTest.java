import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JAXBTest {

    @SneakyThrows
    @Test
    public void jaxBTesting() {
        Cat cat = Cat.getCat("OLIVER", 2, 4.5,
                new String[] {"MEAT", "FISH", "MILK"});

        String xmlString = JAXBMarshaller.doXML(cat);
        Cat catResult = JAXBUnmarshaller.readXML(xmlString);

        Assertions.assertEquals(cat, catResult);

        System.out.println(xmlString);
    }
}
