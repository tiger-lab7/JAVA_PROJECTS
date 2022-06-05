import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        /*Map<PhoneNumber, String> phoneNumbers = new HashMap<>(){{ // Создание анон. класса с блоком инициализации
            put(new PhoneNumber(8, 905, 8534928), "Igor");
            put(new PhoneNumber(8, 905, 7777777), "Cat Vasya");
            put(new PhoneNumber(8, 905, 6786594), "Cat Barsik");
            put(new PhoneNumber(8, 905, 6786594), "Cat Barsik");
        }};
        phoneNumbers.forEach((number, name) -> {
            String result = name + " : " + number.toString();
            System.out.println(result);
        });*/

        Map<PhoneNumber, String> phoneNumbers = new HashMap<>(){{ // Создание анон. класса с блоком инициализации

            PhoneType mobile = new PhoneType("mobile");
            PhoneType landLine = new PhoneType("landLine");

            put(new PhoneNumberAdvanced(8, 905, 8534928, mobile, 0.5), "Igor");
            put(new PhoneNumberAdvanced(8, 905, 7777777, landLine,1.45), "Cat Vasya");
            put(new PhoneNumberAdvanced(8, 905, 6786594, mobile, 0.44), "Cat Barsik");
            put(new PhoneNumberAdvanced(8, 905, 6786594, mobile, 0.44), "Cat Barsik");
        }};
        phoneNumbers.forEach((number, name) -> {
            String result = name + " : " + number.toString();
            System.out.println(result);
        });
    }
}


