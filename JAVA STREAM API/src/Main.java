import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        List<Node> nodeList = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            nodeList.add(new Node(i, (int) (Math.random() * 1000)));
        }

        Optional<Node> max = nodeList.stream().max((a, b) -> a.getN().compareTo(b.getN()));

        //comparing - дефолтный метод интерфейса Comparator
        Optional<Node> max1 = nodeList.stream().max(Comparator.comparing(Node::getN));

        System.out.println(max.get().getN());

        List<Integer> hhh = nodeList.stream().filter(a -> a.getN() > 500).map(Node::getId).collect(toList());

        /*Stream.map
        Returns a stream consisting of the results of applying the given function to the elements of this stream.
         */

        //hhh.forEach(System.out::println);

        for(Integer list: hhh){
            System.out.println("Номер ядра " + list + " значение " + nodeList.get(list).getN());
        }


    }
}


class Node {
    private int id;
    private int n;

    public Node(int id, int n) {
        this.id = id;
        this.n = n;
    }

    public Integer getN() {
        return (Integer) n;
    }

    public int getId() {
        return id;
    }
}
