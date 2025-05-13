import java.util.Stack;

public class CheckPalindrome {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
		Find the middle of the list using slow and fast pointers.
		Reverse the second half of the list.
		Compare the first and second halves node by node.*/

    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalf=reverse(slow);
        ListNode temp1=head;
        ListNode temp2=secondHalf;
        while(temp1!=null && temp2!=null){
            if(temp1.val!=temp2.val){
                return false;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    // using stack
    public boolean isPalindromeStack(ListNode head) {
        Stack<Integer> stk=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            stk.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.val!=stk.pop()){
                return false;
            }
            temp=temp.next;
        }
        return true;
    }


    public static void main(String[] args) {
        CheckPalindrome.ListNode head = new CheckPalindrome.ListNode(1);
        head.next = new CheckPalindrome.ListNode(2);
        head.next.next = new CheckPalindrome.ListNode(2);
        head.next.next.next = new CheckPalindrome.ListNode(1);

        CheckPalindrome checker = new CheckPalindrome();

        // Test using reverse half technique
        boolean result1 = checker.isPalindrome(head);
        System.out.println("Is Palindrome (using reverse half method)? " + result1);

        // Recreate list for second method because previous method modifies it
        CheckPalindrome.ListNode head2 = new CheckPalindrome.ListNode(1);
        head2.next = new CheckPalindrome.ListNode(2);
        head2.next.next = new CheckPalindrome.ListNode(2);
        head2.next.next.next = new CheckPalindrome.ListNode(1);

        // Test using stack
        boolean result2 = checker.isPalindromeStack(head2);
        System.out.println("Is Palindrome (using stack)? " + result2);
    }
}
