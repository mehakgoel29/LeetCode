import java.util.Stack;

public class LargestRectangleInHistogram {
    // brute force
    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public int largestRectangleAreaBrute(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        int i = 0;
        while (i < n) {
            int height = heights[i];
            // Expand to the left
            int left = i;
            while (left >= 0 && heights[left] >= height) {
                left--;
            }
            // Expand to the right
            int right = i;
            while (right < n && heights[right] >= height) {
                right++;
            }
            // Width = (right - 1) - (left + 1) + 1 = right - left - 1
            int width = right - left - 1;
            int area = height * width;
            if (area > maxArea) {
                maxArea = area;
            }
            i++;
        }

        return maxArea;
    }


    //optimal using stack
    // time comp and space comp: o(n)

    // Function to get Previous Smaller Index for each bar
    public int[] getPrevSmaller(int[] heights) {
        int n = heights.length;
        int[] prev = new int[n];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                prev[i] = -1;
            } else {
                prev[i] = stack.peek();
            }

            stack.push(i);
        }

        return prev;
    }

    // Function to get Next Smaller Index for each bar
    public int[] getNextSmaller(int[] heights) {
        int n = heights.length;
        int[] next = new int[n];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                next[i] = -1;
            } else {
                next[i] = stack.peek();
            }
            stack.push(i);
        }

        return next;
    }

    // Main function to compute largest rectangle area
    public int largestRectangleArea(int[] heights) {
        int[] prevSmaller = getPrevSmaller(heights);
        int[] nextSmaller = getNextSmaller(heights);

        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            if(nextSmaller[i]==-1){
                nextSmaller[i]=n;
            }
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = heights[i] * width;

            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}
