import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class JAXBMarshaller {

    public static String doXML(Cat cat) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Cat.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // just insert line breaks

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(cat, stringWriter);

        return stringWriter.toString();
    }
}
