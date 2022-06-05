public class JavaEnums {

    public static void main(String[] args) {

        Cats cats = Cats.Barsik; // Сначала создаём переменную перечисления

        System.out.println(cats);

        if(cats == Cats.Kotik) System.out.println("Котик!"); // enum можно сравнивать обращаясь через точку к классу
        else System.out.println("Другой котик!");

        //Новая форма switch - case по типу лямбды от JAVA 12

        switch(cats) {    // Здесь не требуется обращения к классу enum через точку
            case Kotik -> {
                System.out.println("Котик!");
                }
            case Barsik -> {
                System.out.println("Барсик");
               // break; тут не нужен, поскольку лямбда гарантирует выход из блока
            }
            case Vasia -> System.out.println("Вася!");
            case Pushok -> System.out.println("Пушок!");
            case Snejok -> System.out.println("Снежок");
            default -> System.out.println("Неизвестный котик!");
        }


        // Старая форма switch - case - break требует break в конце каждого case:
        // для выхода из блока, иначе будет выполнятся всё,что ниже.
        switch(cats) {
            case Kotik:
                System.out.println("Котик!");
                break;
            case Barsik:
                System.out.println("Барсик");
                //break;          : задаёт только точку входа в блок операторов. Дальше идут "проваливания" и выполнение
                // всего кода подряд.

            case Vasia:
                System.out.println("Вася!");
            case Pushok:
                System.out.println("Пушок!");
            case Snejok:
                System.out.println("Снежок");
            default:
                System.out.println("Неизвестный котик!");
        }

        cats = Cats.Snejok;

        // Нововведение JAVA 13: switch возвращает значение переменной через варианты yield

        String outputString = switch (cats) {
            case Vasia:
                yield "ВАСЯ";
            case Pushok:
                yield "Пушок";
            case Snejok:
                yield "Снежок";
            default:
                yield "Неизвестный котик";
        };

        System.out.println(outputString);

    }
}
