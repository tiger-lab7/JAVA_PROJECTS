import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class JAXBUnmarshaller {

    public static Cat readXML(String xmlString) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Cat.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader stringReader = new StringReader(xmlString);
        Cat cat = (Cat) unmarshaller.unmarshal(stringReader);

        return cat;
    }
}
