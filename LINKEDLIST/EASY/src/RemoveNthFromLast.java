public class RemoveNthFromLast {
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int length = 0;
            ListNode temp = head;

            // 1. Find length of list
            while (temp != null) {
                length++;
                temp = temp.next;
            }

            // 2. If deleting head node
            if (n == length) {
                return head.next;
            }

            // 3. Move to the node just before the one to be deleted
            temp = head;
            for (int i = 1; i < length - n; i++) {
                temp = temp.next;
            }

            // 4. Remove nth node from end
            temp.next = temp.next.next;

            return head;
        }
        public ListNode twoPointer(ListNode head,int n)
        {
            ListNode fast= head;
            ListNode slow=head;
            for(int i=0;i<n;i++){
                fast=fast.next;
            }
            if (fast == null) {
                return head.next;
            }
            while(fast.next!=null){
                fast=fast.next;
                slow=slow.next;
            }
            slow.next=slow.next.next;
            return head;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {
        // Create the linked list: 10 -> 20 -> 30 -> 40 -> 50
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);

        int n = 2; // Remove the 2nd node from the end

        System.out.println("Original list:");
        display(head);

        Solution solution = new Solution();
        head = solution.removeNthFromEnd(head, n);
        head = solution.twoPointer(head, n);

        System.out.println("After removing " + n + "th node from end:");
        display(head);
    }

    public static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
