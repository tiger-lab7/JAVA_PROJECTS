public class HomeMadeArrayList {

}

class ArrayListNode<E> {
    private int size = 0;
    private int defaultSize = 10;
    private Object[] container;
//Поскольку массив generic'ов в Java не допускается, то создаём массив универсальных Объектов

    public ArrayListNode() {
        size = 0;
        container = new Object[defaultSize];
    }

    public void add(E input) {
        if (size > defaultSize - 1) {
            maximizer();
        }
        container[size] = input;
        // Фактически generic'и - это объекты в общем смысле и такое присвоение допустимо
        size++;
    }

    public E get(int index) {
        return (E) container[index];
    }

    private void maximizer() {
        System.out.println("MAXIMIZE!");
        defaultSize *= 1.5;
        Object[] newcontainer = new Object[(int) (defaultSize)];
        if (size >= 0) System.arraycopy(container, 0, newcontainer, 0, size);
        container = newcontainer;
    }


}


