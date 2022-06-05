public class HomeMadeQueue <T> {

    private QueueNode firstQueueNode;
    private QueueNode currentTopNode;

    public HomeMadeQueue() {

        currentTopNode = new QueueNode(null, null);
        firstQueueNode = currentTopNode;
    }

    public void push(T input) {

        currentTopNode.setValue(input);
        QueueNode secondQueueNode = new QueueNode(null, null);
        currentTopNode.setReference(secondQueueNode);
        currentTopNode = secondQueueNode;
    }

    public T pop() {
        T output= (T) firstQueueNode.getValue();
        if (firstQueueNode.getReference() == null) {
            System.out.println("QUEUE IS EMPTY!");
        }
        else firstQueueNode = firstQueueNode.getReference();

        return output;
    }

}

class QueueNode <T> {

    private T content;
    private QueueNode nextNode;

    public QueueNode(T content, QueueNode nextNode) { //Поскольку в Java объекты это ссылочный тип, то передача ссылки на объект требует только имени класса
        this.content = content;
        this.nextNode = nextNode;
    }

    public void setValue(T input) {
        this.content = input;
    }
    public void setReference(QueueNode nextNode) {
        this.nextNode = nextNode;
    }
    public T getValue() {
        return this.content;
    }
    public QueueNode getReference() {
        return this.nextNode;
    }
}
