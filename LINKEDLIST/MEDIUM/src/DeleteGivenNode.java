public class DeleteGivenNode {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


        public static void deleteNode(ListNode node) {
            // Step 1: Copy the value of the next node into the current node.
            node.val = node.next.val;    // Now the current node holds the value of the next node.

            // Step 2: Skip the next node.
            node.next = node.next.next;  // The current node now points to the next of next node, effectively deleting the next node.
        }


        public static void printList(ListNode head) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println(); // New line after printing the list
        }


        public static void main(String[] args) {

            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            System.out.println("Original List:");
            printList(head);


            ListNode node = head.next.next;  // Node with value 3
            deleteNode(node);

            System.out.println("List After Deleting Node 3:");
            printList(head);
        }
    }



