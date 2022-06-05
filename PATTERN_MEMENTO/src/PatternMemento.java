import org.jetbrains.annotations.NotNull;

import java.util.Stack;

interface IMemento {
    long getDollars();

    long getEuro();
}

class ExchangeMemento implements IMemento {
    private final long dollars;
    private final long euro;

    ExchangeMemento(final long d, final long e) {
        dollars = d;
        euro = e;
    }

    @Override
    public long getDollars() {
        return dollars;
    }

    @Override
    public long getEuro() {
        return euro;
    }
}

class Exchange {
    private long dollars;
    private long euro;

    Exchange() {
        dollars = new java.util.Random().nextInt(100);
        euro = new java.util.Random().nextInt(100);;
    }

    public void sellDollar() {
        if (dollars > 0) {
            --dollars;
        }
    }

    public void buyEuro() {
        ++euro;
    }

    public void getDollars() {
        System.out.println("Dollars: " + dollars);
    }

    public void getEuro() {
        System.out.println("Euro " + euro);
    }

    public @NotNull ExchangeMemento saveState() {
        return new ExchangeMemento(dollars, euro);
    }

    public void restoreState(final @NotNull IMemento iMemento) {
        dollars = iMemento.getDollars();
        euro = iMemento.getEuro();
    }
}

class Memory {
    private final @NotNull Stack<IMemento> iMementoStack;
    private final Exchange exchange;

    Memory(final Exchange e) {
        exchange = e;
        iMementoStack = new Stack<IMemento>();
    }

    public void backup() {
        iMementoStack.push(exchange.saveState());
    }

    public void undo() {
        if (iMementoStack.empty()) return;
        exchange.restoreState(iMementoStack.pop());
    }
}


public final class PatternMemento {
    private PatternMemento() {
    }

    public static void main(final String[] args) {

        Exchange exchange = new Exchange();
        Memory memory = new Memory(exchange);

        exchange.getDollars();
        exchange.getEuro();

        System.out.println("-------Продаем 1 доллар. Покупаем 1 евро.-------");
        exchange.sellDollar();
        exchange.buyEuro();

        exchange.getDollars();
        exchange.getEuro();

        System.out.println("--------Сохранение состояния.--------------");
        memory.backup();

        System.out.println("-------Продаем 1 доллар. Покупаем 1 евро.-------");
        exchange.sellDollar();
        exchange.buyEuro();

        exchange.getDollars();
        exchange.getEuro();

        System.out.println("--------Восстановление состояния.--------------");
        memory.undo();

        exchange.getDollars();
        exchange.getEuro();

    }
}
