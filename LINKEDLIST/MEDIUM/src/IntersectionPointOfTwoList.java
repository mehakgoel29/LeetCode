import java.util.HashSet;

public class IntersectionPointOfTwoList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set= new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeMethod2(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;

            ListNode a = headA;
            ListNode b = headB;

            while (a != b) {
                if (a == null) {
                    a = headB;
                } else {
                    a = a.next;
                }

                if (b == null) {
                    b = headA;
                } else {
                    b = b.next;
                }
            }

            return a; // This could be the intersection node or null
    }


    public static void main(String[] args) {
        // Common part (intersection)
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(10);

        // List A: 1 -> 2 -> 8 -> 10
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = intersect;

        // List B: 4 -> 5 -> 8 -> 10
        ListNode headB = new ListNode(4);
        headB.next = new ListNode(5);
        headB.next.next = intersect;

        IntersectionPointOfTwoList solution = new IntersectionPointOfTwoList();
        ListNode result = solution.getIntersectionNodeMethod2(headA, headB);

        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection.");
        }
    }

}
