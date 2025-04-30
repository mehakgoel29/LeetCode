public class MiddleOfLinkedList {
    public static class Node {
        Node next;
        int val;
        Node(int val , Node next){
            this.val=val;
            this.next=next;
        }
        Node(int val) {
            this.val = val;
        }
    }
    public static Node middleBruteForce(Node head){
        Node temp=head;
        int length=0;
        while (temp!=null){
            length++;
            temp=temp.next;
        }
        int mid=(length/2)+1;
        int i=1;
        temp=head;
        while(i<mid){
          temp=temp.next;
          i++;
        }
        System.out.println(temp.val);
        return temp;
    }
    public static Node middleTwoPointer(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.val);
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        middleBruteForce(head);
        middleTwoPointer(head);
    }
}
//odd fast==null
//even fast.next==null
