/* public class Solution00 {

    private ListNode listN;
    private ListNode listNForReverser;
    private int k;
    private boolean firstCommonTraverse = true;
    private ListNode outputNode;
    private MergedNode mergedNode = new MergedNode();

    public ListNode reverseKGroup(ListNode head, int k) {
        listN = head;
        listNForReverser = head;
        this.k = k;

        ListNode node = head;
        int iter = 1;
        while(node.next != null) {
            if (iter == k) {reverser(node);}

            node = node.next;
            iter++;
        }

    return outputNode;
    }

    private MergedNode reverser(ListNode pointN) {
        ListNode node = listNForReverser;
        boolean firstPass = true;
        while(node == pointN) {

            ListNode node2 = node.next;
            node2.next = node;
            if(firstPass) {node.next = null; mergedNode.previous = node; firstPass = false;}
            node = node2;
        }
        listNForReverser = node.next;
        if(firstCommonTraverse) {outputNode = node; firstCommonTraverse = false;}
    }
}

class MergedNode {
    ListNode previous;
    ListNode next;
}
*/