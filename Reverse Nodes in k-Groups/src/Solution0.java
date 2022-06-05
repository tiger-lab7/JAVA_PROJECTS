public class Solution0 {

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null) return null;
        if(k == 1) return head;

        ListNode node1 = head;
        ListNode node2 = head.next;

        if(node2 == null) return head;

        ListNode outputFirstNode = null;
        ListNode lastCommonNode = null;
        ListNode lastNode = null;
        ListNode node3;

        int lengthLN = measureLength(head);
        int repeating = lengthLN / k;
        int tail = lengthLN % k;

        for(int i = 0; i < repeating; ++i) {

            int iter = 1;

            while (iter < k) {

                node3 = node2.next;
                node2.next = node1;
                if (iter == 1) { node1.next = null; lastNode = node1; }

                node1 = node2;
                node2 = node3;
                iter++;
            }

            if (i == 0) outputFirstNode = node1;
                else lastCommonNode.next = node1;

            lastCommonNode = lastNode;

            if(node2 != null) {node1 = node2; node2 = node1.next;}
        }

        if(tail != 0) lastCommonNode.next = node1;

        return outputFirstNode;
    }

    private int measureLength(ListNode ln) {
        int i = 0;
        while(ln != null) {
            ln = ln.next;
            i++;
        }
        return i;
    }

}
