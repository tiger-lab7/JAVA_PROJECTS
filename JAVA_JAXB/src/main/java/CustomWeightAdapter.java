/* Example of a custom JAXB type adapter for marshalling and unmarshalling values of
fields in Java objects
* */

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CustomWeightAdapter extends XmlAdapter<String, Double> {

    @Override
    public Double unmarshal(String s) throws Exception {
        return Double.parseDouble(s.substring(0, s.length() - 3));
    }

    @Override
    public String marshal(Double aDouble) throws Exception {
        return aDouble.toString() + " kg";
    }
}
