public class NumArray {
    private int[] prefixSum;

    // Constructor to initialize the prefix sum array
    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n + 1];  // Extra space to handle the base case
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];  // Compute prefix sum
        }
    }

    // Method to compute the sum of elements in the range [left, right]
    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];  // O(1) query
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example input
        int[] nums = {-2, 0, 3, -5, 2, -1};  // Array of numbers
        int left = 0;  // Starting index of the range
        int right = 2; // Ending index of the range

        // Create an instance of NumArray
        NumArray obj = new NumArray(nums);

        // Call the sumRange method and print the result
        int param_1 = obj.sumRange(left, right);
        System.out.println("Sum of range [" + left + ", " + right + "] is: " + param_1);
    }
}
