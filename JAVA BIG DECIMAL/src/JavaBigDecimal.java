import java.math.BigDecimal;
import java.math.RoundingMode;

public class JavaBigDecimal {

    public static void main(String...args) {

        String numbersString = "777777777777777777777777777777777777777777777777777777777777777777777777777777777";
        BigDecimal bigDecimal = new BigDecimal(numbersString);
        bigDecimal = bigDecimal.divide(BigDecimal.valueOf(7));
        bigDecimal = bigDecimal.multiply(bigDecimal);
        bigDecimal= bigDecimal.add(BigDecimal.TEN);
        bigDecimal = bigDecimal.subtract(BigDecimal.valueOf(999999999999999999L));
        bigDecimal.plus();

        BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(bigDecimal.negate()));
        System.out.println(bigDecimal.min(bigDecimal2));


        /*При делении BigDecimal всегда нужно указывать количество цифр после запятой (параметр scale) и
        режим округления RoundingMode, иначе будет выброшено исключение, если результат дробный! */
        bigDecimal = bigDecimal.divide(BigDecimal
                .valueOf(Double.parseDouble("123456789.7877")), 8, RoundingMode.HALF_UP);
       // bigDecimal = bigDecimal.setScale(5, RoundingMode.HALF_DOWN);

        bigDecimal.
        System.out.println(bigDecimal);
    }
}
