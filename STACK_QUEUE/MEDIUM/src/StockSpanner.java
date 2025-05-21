import java.util.Stack;

class StockSpanner {
    Stack<int[]> stack; // Each element is [price, span]

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        // Pop all prices from stack that are <= current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        // Push current price and its calculated span
        stack.push(new int[]{price, span});

        return span;
    }
}

