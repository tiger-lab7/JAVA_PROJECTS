public class JavaStrings {

    public static void main(String[] args) {

        String string1 = "ПРИВЕТ, Я КОТ БАРСИК";
        String string2 = new String("А Я КОТ ВАСЯ!");
        String string3 = new String(new char[]{'П', 'Р', 'И', 'В', 'Е', 'Е', 'Т', '!'});
        String[] stringArray = new String[]{"ЗИМА", "ВЕСНА", "ЛЕТО", "ОСЕНЬ"};
        String[][] string2DArray = new String[][]{{"ЧЕРНЫЙ", "БЕЛЫЙ"}, {"CЕРЫЙ", "ЗЕЛЁНЫЙ"}};

        System.out.println(string2DArray[1][0]);
        System.out.println(String.join(" + ", string1, string2, string3));
        // Метод String.join() объединяет любое количество строк с разделителем, заданным первым аргументом

        System.out.println(string1.split(" ")[0]);
        // Метод split возращает массив строк, разделённых регулярным выражением, переданным в качестве параметра

        System.out.println(string1.concat(" HELLO!!!"));
        // Метод concat принимает только один аргумент, добавляемый к строке

        System.out.println(string1.charAt(8));
        //Метод возвращает символ в строке по индексу (с 0 как в массиве)

        char[] charString = new char[3];
        string1.getChars(10, 13, charString, 0);
        //Метод передает в массив char[] часть строки. Начало исходной, конец исходной, имя массива, сдвиг с начала массива
        for (char charIter : charString) {
            System.out.println(charIter);
        }

        System.out.println(string1.equals(string2));
        System.out.println(string1.equalsIgnoreCase(string2));
        //В отличие от сравнения числовых и других данных примитивных типов для строк не применяется знак равенства ==.



    }

}


