public class RotateLL {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // Step 1: Length
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // Step 2: Circular list bnao
        curr.next = head;

        // Step 3: k mod length
        k = k % length;
        int stepsToNewHead = length - k;

        // Step 4: New tail find kro
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break the cycle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
