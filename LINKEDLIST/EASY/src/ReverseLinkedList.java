public class ReverseLinkedList {
    public static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static Node head;
    static Node prev = null;
    static Node next;
    static Node curr;

    // ITERATION
    public static Node ReverseList() {
        curr = head;  // Initialize curr to head
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;  // Update head to the new head (prev)
        return head;  // Return the new head
    }

    public static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        head = new Node(1);  // Use the static head
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        display();       // Display original list
        ReverseList();   // Reverse the list using iteration
        display();       // Display reversed list
    }
}
