public class KadanesAlgo {
        public static int maxSubArray(int[] nums) {
            int maxSum = Integer.MIN_VALUE;
            int sum = 0;
            int start = 0, tempStart = 0, end = 0;

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];

                if (sum > maxSum) {
                    maxSum = sum;
                    start = tempStart; // Update the starting index of the subarray
                    end = i;           // Update the ending index of the subarray
                }

                if (sum < 0) {
                    sum = 0;          // Reset sum
                    tempStart = i + 1; // Update temporary start index
                }
            }

            // Print the subarray
            System.out.print("Subarray with the maximum sum: [");
            for (int i = start; i <= end; i++) {
                System.out.print(nums[i]);
                if (i < end) System.out.print(", ");
            }
            System.out.println("]");

            return maxSum;
        }

        public static void main(String[] args) {
            int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

            // Call the maxSubArray method and print the result
            int maxSum = maxSubArray(nums);
            System.out.println("Maximum Sum: " + maxSum);
        }
    }


