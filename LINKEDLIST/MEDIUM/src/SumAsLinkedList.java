public class SumAsLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int carry=0;
        ListNode dummy= new ListNode(-1);
        ListNode temp=dummy;
        // if carry exits that is it is not equal to zero yet then we have to handle it
        while(l1!=null || l2!=null || carry!=0) {
            int val1=0;
            int val2=0;

            if(l1!=null){
                val1=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                val2=l2.val;
                l2=l2.next;
            }
            int sum=val1+val2+carry;
            int digit=sum%10;
            carry=sum/10;

            ListNode node= new ListNode(digit);
            temp.next=node;
            temp=temp.next;
        }
        return  dummy.next;

    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // l1 = [2 -> 4 -> 3], representing number 342
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        // l2 = [5 -> 6 -> 4], representing number 465
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        SumAsLinkedList sol = new SumAsLinkedList();
        ListNode result = sol.addTwoNumbers(l1, l2); // Should return 7 -> 0 -> 8 (i.e., 807)

        System.out.print("Result: ");
        printList(result);
    }
}
