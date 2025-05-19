import java.util.HashMap;

class LRUCache {
    Node head = new Node(0, 0), tail = new Node(0, 0);
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    static class Node {
        Node prev, next;
        int key, val;
        Node(int key, int value) {
            this.key=key;
            this.val=value;
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev; // least recently used node
                deleteNode(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insertAfterHead(newNode);
            map.put(key, newNode);
        }
    }

    public void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void insertAfterHead(Node node) {
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }
}
