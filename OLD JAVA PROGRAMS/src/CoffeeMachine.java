public class CoffeeMachine {

    String [] drinkNames;
    int [] drinkPrices;

    public CoffeeMachine (String [] drinkNames, int [] drinkPrices) {

        this.drinkNames = drinkNames;
        this.drinkPrices = drinkPrices;
    }

    public void checkMoney (int Money) {

        boolean lowMoney = true;

        for (int i = 0; i < drinkPrices.length; i++) {

            if (Money > drinkPrices [i]) {
                System.out.println("ВЫ МОЖЕТЕ КУПИТЬ " + drinkNames[i]);
                lowMoney = false;
            }
        }
        if (lowMoney) System.out.println("У ВАС НЕТ НА ЭТО ДЕНЕГ! ИЗУЧАЙТЕ JAVA И ЗАРАБАТЫВАЙТЕ БОЛЬШЕ!");

    }





}
