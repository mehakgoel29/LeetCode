public class DetectCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;   //cycle detected
            }
        }
        return false;        // no cycle
    }

    public static void main(String[] args) {
        DetectCycle solution = new DetectCycle();

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        // Creating a cycle: 6 -> 3 (cycle starts at node3)
        node6.next = node3;

        // Test cycle detection
        if (solution.hasCycle(node1)) {
            System.out.println("Cycle detected.");
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
