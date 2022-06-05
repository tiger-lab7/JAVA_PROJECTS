import java.util.ArrayList;
import java.util.List;

public class StringBuilderIterable {

    public static void main(String[] args) {

        List<StringBuilder> listStringBuilder = new ArrayList<>();//Объявляем переменную объекта типа List, а инстанцируем уже ArrayList

        listStringBuilder.add(new StringBuilder("КОТ ВАСЯ Т"));
        listStringBuilder.add(new StringBuilder("КОТ БАРСИК Т"));
        listStringBuilder.add(new StringBuilder("КОТ МЯГКИЙ"));

        for(StringBuilder sb : listStringBuilder) {

            sb.append(88); //StringBuilder поддерживает метод добавления в строку.
            //Поскольку StringBuilder является mutable, его можно изменять и в цикле foreach
        }
            System.out.println(listStringBuilder);

        for(StringBuilder sb : listStringBuilder) {
            System.out.println(sb.indexOf("Т")); //Ищет первое вхождение подстроки в строку
        }

        for(StringBuilder sb : listStringBuilder) {
            System.out.println(sb.capacity()); // Возвращает вместимость строки
        }



    }
}
