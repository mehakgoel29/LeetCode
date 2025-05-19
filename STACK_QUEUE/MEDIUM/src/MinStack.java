import java.util.Stack;

public class MinStack {
        //using single stack
        Stack<Integer> stack = new Stack<>();
        int  min = Integer.MAX_VALUE;;

        public MinStack() {
        }

        public void push(int val) {
            if (val <= min) {
                // Save previous min for o(1) access
                stack.push(min);
                min = val;
            }
            stack.push(val);
        }

        public void pop() {
            int popped = stack.pop();
            if (popped == min) {
                // Restore previous min
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }




        // using 2 stacks
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push2(int val) {
            mainStack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop2() {
            if (mainStack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            mainStack.pop();
        }

        public int top2() {
            return mainStack.peek();
        }

        public int getMin2() {
            return minStack.peek();
        }
}
