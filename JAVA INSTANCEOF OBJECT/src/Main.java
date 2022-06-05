import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Object[] objectArray = {"КОТ", 327, 456.34, 'g'}; //Autoboxing авт. преобразует этип типы в универс. объекты

        for(Object o : objectArray) {System.out.println(o + " ИМЕЕТ ТИП: " + o.getClass().getName());}

        Object o = new Scanner(System.in);
        Scanner console = (Scanner) o;

        while (console.hasNext()) {
            try {
            int x = console.nextInt();
            System.out.println(x);} catch(Exception ex) {break;}
        }

        Object o1 = "ВАСИЛИЙ";
        if (o1 instanceof String){
                String s = (String) o1;
                System.out.println(s);
        }

        Object o2 = 2323.45454;
        double d = (Double) o2;
        System.out.println(d);

    }
}
