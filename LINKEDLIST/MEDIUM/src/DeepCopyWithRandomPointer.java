import java.util.HashMap;

public class DeepCopyWithRandomPointer {

    /*
    METHOD 1
    time comp:o(n)
    space comp:o(n)
    */
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap<>();
        Node temp=head;
        while(temp!=null){
            map.put(temp,new Node(temp.val));
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            Node copyNode = map.get(temp);
            copyNode.next=map.get(temp.next);
            if(temp.random!=null){
                copyNode.random=map.get(temp.random);
            }
            temp=temp.next;
        }
        return map.get(head);
    }

    /* METHOD 2 : OPTIMAL APPROACH */
    public Node copyRandomListOpt(Node head) {
        if (head == null) return null;

        // Step 1: Insert cloned nodes after original nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Set random pointers for cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;  // random.next because random will point to original node and random.next points to the the copied node
            curr = curr.next.next;
        }

        // Step 3: Separate the two lists
        Node dummyHead = new Node(0);
        Node copyCurr = dummyHead;
        curr = head;

        while (curr != null) {
            copyCurr.next = curr.next;
            curr.next = curr.next.next;

            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return dummyHead.next;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
