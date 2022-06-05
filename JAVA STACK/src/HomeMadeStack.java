public class HomeMadeStack <T> {


        private StackNode currentTopNode;

        public HomeMadeStack() {

            currentTopNode = new StackNode(null, null);
        }

        public void push(T input) {

            StackNode secondStackNode = new StackNode(input, currentTopNode);
            currentTopNode = secondStackNode;
        }

        public T pop() {
            T output = (T)(Integer) 0;
            try {
                output = (T) currentTopNode.getValue();
            }
            catch(java.lang.NullPointerException ex) {
                    System.out.println("STACK IS EMPTY!");
                    return (T)(Integer) 0;
            }
                 currentTopNode = currentTopNode.getReference();

                return output;
        }
    }

class StackNode <T> {

        private final T content;
        private final StackNode prevNode;

        public StackNode(T content, StackNode prevNode) { //Поскольку в Java объекты это ссылочный тип, то передача ссылки на объект требует только имени класса
            this.content = content;
            this.prevNode = prevNode;
        }
        public T getValue() {
            return content;
        }
        public StackNode getReference() {
            return prevNode;
        }
    }


