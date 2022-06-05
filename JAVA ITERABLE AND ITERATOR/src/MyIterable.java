import java.util.Iterator;
import java.util.function.Consumer;

// Iterable имеет только метод iterator, возвращающий Итератор по данному объекту,
// а также метод forEach
public class MyIterable <T> implements Iterable<T> {
    public int size, currentPosition = 0;
    public Object[] values;
    MyIterable(int size) {
        this.size = size;
        values = new Object[size];
    }
    public void add(T input) {
        values[currentPosition++] = (Object) input;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(this);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

}



/* Итератор - вспомогательный объект, умеющий итерироваться по объекту,
   возратившему его посредством метода iterator
   В объекте iterator должны быть определены методы boolean hasNext и E Next,
   а также remove и forEachRemaining (лямбда Consumer для каждого оставшегося элемента) */
class MyIterator <E> implements Iterator<E> {
    private MyIterable<E> iterableObject;
    private int currentPosition = 0;
    MyIterator(MyIterable<E> iterableObject) {
        this.iterableObject = iterableObject;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < iterableObject.size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E next() {
        return (E) iterableObject.values[currentPosition++];
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super E> action) {
        Iterator.super.forEachRemaining(action);
    }
}

