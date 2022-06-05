import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class JulianDate {

    public static int JGREG = 15 + 31 * (10 + 12 * 1582);

    public static void main(String[] args) {

        // GregorianCalendar gc = new GregorianCalendar();

        //  GregorianCalendar.getInstance();
        // System.out.println(Calendar.);

        Date currentDate = new Date();   // Создаём объект даты

        // Создаём объект формата даты и задаём ему в конструктор шаблон желаемого формата
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        //Преобразуем объект даты в строку заданного формата
        //Строка (String) в Java это ООП обёртка над над массивом примитивов-знаков (char).
        String strCurrentDate = dateFormat.format(currentDate);

        //Передаём строку в массив int для метода вычисления Юлианской даты
        int[] ymd = new int[3];
        ymd[0] = Integer.parseInt(strCurrentDate.substring(0, 4));
        ymd[1] = Integer.parseInt(strCurrentDate.substring(4, 6));
        ymd[2] = Integer.parseInt(strCurrentDate.substring(6, 8));


        double julianDay = toJulian(ymd);
        System.out.println("ТЕКУЩАЯ ЮЛИАНСКАЯ ДАТА: " + (int) julianDay); // Приводим тип double к типу int

        int[] baseYmd;
       // baseYmd = new int[]{1986, 07, 10};
        baseYmd = new int[]{1963, 10, 28};
        double julianDay0 = toJulian(baseYmd);

        System.out.println("ВЫ ПРОЖИЛИ: " + (int) (julianDay - julianDay0) + " дней");


    }


    public static double toJulian(int[] ymd) {

        int year = ymd[0];
        int month = ymd[1]; // jan=1, feb=2,...
        int day = ymd[2];

        int julianYear = year;
        if (year < 0) julianYear++;
        int julianMonth = month;
        if (month > 2) {
            julianMonth++;
        } else {
            julianYear--;
            julianMonth += 13;
        }

        double julian = (java.lang.Math.floor(365.25 * julianYear)
                + java.lang.Math.floor(30.6001 * julianMonth) + day + 1720995.0);
        if (day + 31 * (month + 12 * year) >= JGREG) {
            // change over to Gregorian calendar
            int ja = (int) (0.01 * julianYear);
            julian += 2 - ja + (0.25 * ja);
        }
        return java.lang.Math.floor(julian);
    }
}
