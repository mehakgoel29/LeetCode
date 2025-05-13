public class DeleteMiddleNode {
    public static  ListNode deleteMiddle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        if (head == null || head.next == null) return null;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }

        ListNode temp=head;
        //traverse till one node before slow because slow is the middle and we have to delete it
        while(temp.next!=slow){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }

    public ListNode deleteMiddleMethod2(ListNode head) {
            ListNode slow=head;
            ListNode fast=head;
            ListNode temp = null; // To keep track of the node before `slow`

            if (head == null || head.next == null) return null;

            while(fast!=null && fast.next!=null){
                temp=slow;
                slow=slow.next;
                fast=fast.next.next;

            }

            if (temp != null) {
                temp.next = slow.next;
            }

            return head;
        }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
