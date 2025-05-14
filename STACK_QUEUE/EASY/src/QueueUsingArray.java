public class QueueUsingArray {
    // Indices to track the front (start) and rear (end) of the queue
    int start = -1;
    int end = -1;

    // To keep track of the current number of elements in the queue
    int currSize = 0;

    // Maximum size of the queue
    int maxSize = 1000;

    // Array to store the queue elements
    int[] arr = new int[maxSize];

    // Method to insert an element into the queue
    public void push(int x) {
        // If the queue is full, do not insert
        if (currSize == maxSize) {
            System.out.print("queue is full");
            return;
        }

        // If queue is empty, initialize start and end to 0
        if (end == -1) {
            start = 0;
            end = 0;
        } else {
            // Move end pointer circularly
            end = (end + 1) % maxSize;
        }

        // Insert the new element at the end and update size
        arr[end] = x;
        currSize++;
    }

    // Method to remove and return the front element of the queue
    public int pop() {
        // If queue is empty, return -1
        if (isEmpty()) {
            return -1;
        }

        // Get the front element
        int x = arr[start];

        // If it was the last element, reset pointers
        if (currSize == 1) {
            start = -1;
            end = -1;
        } else {
            // Move start pointer circularly
            start = (start + 1) % maxSize;
        }

        // Decrease the size and return the removed element
        currSize--;
        return x;
    }

    // Method to get the front element without removing it
    public int peek() {
        if (!isEmpty()) {
            return arr[start];
        } else {
            return -1;
        }
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return start == -1;
    }

    // Method to get the current size of the queue
    public int size() {
        return currSize;
    }
}
