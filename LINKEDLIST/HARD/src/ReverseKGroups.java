public class ReverseKGroups {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head; // Attach a dummy node in front to handle head node easily
        ListNode prevGroupTail = dummy; // This will point to the tail of the previous group after reversal
        ListNode curr = head;

        while (hasKNodes(curr, k)) {
            ListNode groupStart = curr; // Store the start of the current group
            ListNode prev = null; // Initialize `prev` to null to start reversing

            // Reverse the next `k` nodes
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;  // Temporarily store the next node
                curr.next = prev;           // Reverse the current node
                prev = curr;                // Move prev to the current node
                curr = next;                // Move curr to the next node
            }

            // Connect the previous group's tail to the new reversed group
            prevGroupTail.next = prev;  // prev now points to the new head of the reversed group

            // Connect the current group’s original start node to the next group
            groupStart.next = curr;  // groupStart points to the next node after the reversed group

            // Move prevGroupTail to the end of the reversed group
            prevGroupTail = groupStart;
        }

        return dummy.next;  // Return the head of the modified list
    }

    private boolean hasKNodes(ListNode curr, int k) {
        ListNode temp = curr;
        int count = 0;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        return count == k;
    }

    // Utility method to print the linked list
    public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseKGroups solution = new ReverseKGroups();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 3;
        System.out.println("Original list:");
        solution.printList(head);

        head = solution.reverseKGroup(head, k);

        System.out.println("Reversed list in groups of " + k + ":");
        solution.printList(head);
    }
}
