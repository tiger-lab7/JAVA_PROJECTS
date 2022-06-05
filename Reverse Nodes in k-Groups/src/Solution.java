import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ArrayList<Reverser> tasks = new ArrayList<>();
        List<Future<FirstLastNodePair>> futures;

        ListNode currentNode = head;

        ListNode tail = null;
        ListNode probablyTail = null;
        ListNode probablyTailNext = null;
        outer:
        while (currentNode != null) {

            probablyTail = currentNode;
            probablyTailNext = currentNode.next;

            Reverser reverser = new Reverser(currentNode, k - 1);
            tasks.add(reverser);


            int iter = 0;
            while (iter < k && currentNode != null) {

                currentNode = currentNode.next;
                iter++;
            }
            System.out.println(iter);
            if(iter < k) {
                tail = probablyTail;
                tail.next = probablyTailNext;
                break outer;
            }
        }

        try {
            futures = executorService.invokeAll(tasks);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        ListNode outputNode = null, lastNode = null;

        try {
            for (int i = 0; i < futures.size(); i++) {

                FirstLastNodePair firstLastNodePair = futures.get(i).get();

                if (i == 0) outputNode = firstLastNodePair.firstNode;
                else lastNode.next = firstLastNodePair.firstNode;
                lastNode = firstLastNodePair.lastNode;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        if(tail == null) lastNode.next = null;
            else lastNode.next = tail;

        executorService.shutdown();
        System.out.println("Completed!");
        return outputNode;
    }


}

class Reverser implements Callable<FirstLastNodePair> {

    private final ListNode head;
    private final int k;

    public Reverser(ListNode head, int k) {
        this.head = head;
        this.k = k;
    }

    @Override
    public FirstLastNodePair call() {
        ListNode node = head;
        ListNode normalOrderNext = head.next;
        ListNode node2 = node.next;

        int iter = 0;
        boolean first = true;
        while (normalOrderNext != null && iter < k) {

            normalOrderNext = normalOrderNext.next;

            node2.next = node;
            if (first) {
                node.next = null;
                first = false;
            }
            node = node2;
            node2 = normalOrderNext;
            iter++;
        }

        return new FirstLastNodePair(node, head);
    }

}


class FirstLastNodePair {
    public ListNode firstNode;
    public ListNode lastNode;

    public FirstLastNodePair(ListNode firstNode, ListNode lastNode) {
        this.firstNode = firstNode;
        this.lastNode = lastNode;
    }
}
