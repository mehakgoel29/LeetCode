import java.util.Stack;

public class SortAStack {
    public Stack<Integer> sort(Stack<Integer> original) {
        Stack<Integer> sorted = new Stack<>();

        while (!original.isEmpty()) {
            int temp = original.pop();

            // Move elements from sorted to original if they are greater than temp
            while (!sorted.isEmpty() && sorted.peek() > temp) {
                original.push(sorted.pop());
            }

            sorted.push(temp);
        }

        return sorted;
    }
}

