public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode temp=dummy;

        while(list1!=null && list2!=null){
            if(list1.val>=list2.val){
                temp.next=list2;
                list2=list2.next;
            }
            else {
                temp.next=list1;
                list1=list1.next;
            }
            temp=temp.next;
        }
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        return dummy.next;

    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


        public static void main(String[] args) {
            MergeTwoSortedList obj = new MergeTwoSortedList();

            // Create list1: 1 -> 2 -> 3 -> 4 -> 5 -> 6
            MergeTwoSortedList.ListNode list1 = obj.new ListNode(1,
                    obj.new ListNode(2,
                            obj.new ListNode(3,
                                    obj.new ListNode(4,
                                            obj.new ListNode(5,
                                                    obj.new ListNode(6))))));

            // Create list2: 1 -> 2 -> 3
            MergeTwoSortedList.ListNode list2 = obj.new ListNode(1,
                    obj.new ListNode(2,
                            obj.new ListNode(3)));

            // Merge the lists
            MergeTwoSortedList.ListNode merged = obj.mergeTwoLists(list1, list2);

            // Print the merged list
            System.out.print("Merged List: ");
            while (merged != null) {
                System.out.print(merged.val + " ");
                merged = merged.next;
            }
        }
    }


