import java.util.ArrayList;
import java.util.Collections;

public class FlattenLinkedList {
    // Time: O(n log n), Space: O(n) — where n is the total number of nodes
    // n log n for sorting using Collections, and n for storing in ArrayList

    // Approach 1: Using sorting (less optimal)
    public ListNode flattenLinkedListMethod1(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            // Traverse the child list (sorted) of the current head node
            ListNode child = temp;
            while (child != null) {
                list.add(child.val);
                child = child.child;
            }
            temp = temp.next;
        }

        // Sort the collected values
        Collections.sort(list);

        // Rebuild the flattened list using 'child' pointers
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int i=0;i< list.size();i++) {
            current.child = new ListNode(list.get(i));
            current = current.child;
        }

        return dummy.child;
    }

    // Approach 2: Optimal — Recursive merge
    public ListNode flattenLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively flatten the next part
        ListNode mergeHead = flattenLinkedList(head.next);

        // Merge current head’s child list with already flattened next list
        return merge(head, mergeHead);
    }

    // Merge two sorted linked lists using 'child' pointers
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                res.child = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                list2 = list2.child;
            }
            res = res.child;
        }

        if (list1 != null) res.child = list1;
        if (list2 != null) res.child = list2;

        return dummy.child;
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode child;

        ListNode() {
            val = 0;
            next = null;
            child = null;
        }

        ListNode(int data1) {
            val = data1;
            next = null;
            child = null;
        }

        ListNode(int data1, ListNode next1, ListNode next2) {
            val = data1;
            next = next1;
            child = next2;
        }
    }
}
