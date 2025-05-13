import java.util.ArrayList;

public class SwappingNodesFromKstartAndLast {
    // time comp: O(n) + O(1) + O(n) = O(n)
    //space comp:o(n)
    public ListNode swapNodes(ListNode head, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;

        // Convert linked list to array
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        // Swap k-th node from start and end
        int firstIndex = k - 1;
        int lastIndex = list.size() - k;

        //list.set(index, value)
        int tempVal = list.get(firstIndex);
        list.set(firstIndex, list.get(lastIndex));
        list.set(lastIndex, tempVal);

        // Rebuild linked list from array
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : list) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    // time comp: o(n)
    // space comp: o(1)
    
    public ListNode swapNodesMethod2(ListNode head, int k) {
        ListNode first = head;
        // Step 1: Move to the k-th node from start
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // Step 2: Use two pointers to find the k-th node from end
        ListNode second = head;
        ListNode temp = first;
        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }

        // Step 3: Swap the values
        int val = first.val;
        first.val = second.val;
        second.val = val;

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
