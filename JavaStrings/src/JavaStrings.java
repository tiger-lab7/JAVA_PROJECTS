public class JavaStrings {


    public static void main(String[] args) throws CloneNotSupportedException {

        String str1 = "КОТ";
        String str2 = new String("ВАСЯ");
        String str3 = new String(new char[]  {'С','Е','Р','Ы','Й'}, 0, 3);

        String str4 = "";

        String str5 = new String(); //Создаем пустую строку

        if (str4.equals(str5)) System.out.println(str5.getClass() + " Объекты равны!");
        //Метод boolean equal универсален для всех объектов в Java

        str4 = null; // Строка не указывает на объект
        if (str4 == null || str5 == null) System.out.println(" Строка равна null!");
            else System.out.println(" Строка не равна null!");
        //Значение null не эквивалентно пустой строке.


        System.out.println(str1 + str2 + str3);
        System.out.println(str1.length());

        //После создания строки неизменяемы!
        char[] charArray = str2.toCharArray(); //Преобразуем строку в массив char
        charArray[0] = 'М'; //Меняем символ в массиве
        System.out.println(charArray);


        Java1 obj = new Java1("КОТ СЕРЫЙ");
        obj.cloning();

    }

    private static class Java1 implements Cloneable {

        private String inputString;
        private String outputString;

        public Java1  (String str)  {

           inputString = str;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private void cloning() throws CloneNotSupportedException {

           this.outputString = (String) clone();
           System.out.println(this.outputString);
        }



    }

}
