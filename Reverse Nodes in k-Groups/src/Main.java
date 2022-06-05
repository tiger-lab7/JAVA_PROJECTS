public class Main {

    public static void main(String... args) {
        //Solution solution = new Solution();
        Solution0 solution0 = new Solution0();

       // ListNode firstList = generateListOfNodes(10);
       // ListNode outputList = solution.reverseKGroup(firstList, 3);
       // printListOfNodes(outputList);

        ListNode firstList = generateListOfNodes(1);
        ListNode outputList = solution0.reverseKGroup(firstList, 2);
        printListOfNodes(outputList);

    }

    private static ListNode generateListOfNodes(int len) {
        ListNode firstList = new ListNode();
        ListNode currentNode = firstList;

        for (int i = 0; i < len; ++i) {
            currentNode.val = i + 1;
            currentNode.next = new ListNode();
            currentNode = currentNode.next;

        }
        currentNode.val = len + 1;
        return firstList;
    }
    private static void printListOfNodes(ListNode ln) {
        int n = 0;
        int limit = 0;
        while(ln != null && limit++ < 5500) {
            System.out.println(ln.val);

            n++;
            ln = ln.next;
        }
    }
}
