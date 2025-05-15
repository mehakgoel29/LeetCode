import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {

        //time comp: m*n where m,n are length of arrays
        //brute force
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length];

            for (int i = 0; i < nums1.length; i++) {
                int current = nums1[i];
                int indexInNums2 = findIndex(nums2, current); // find the index of current in nums2
                boolean found = false;

                for (int j = indexInNums2 + 1; j < nums2.length; j++) {
                    if (nums2[j] > current) {
                        res[i] = nums2[j]; // next greater element found
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    res[i] = -1; // no greater element found
                }
            }

            return res;
        }

        // Helper function to find index of a value in nums2
        public int findIndex(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1; // shouldn't happen if nums1 is a subset of nums2
        }




        //optimal using stack and hashmap
        // Time Complexity: O(n + m), where n = nums1.length, m = nums2.length
        // Space Complexity: O(m + n) for stack, hashmap, and result array


         // algo:
        //if greater ... pop and map
        //else push

        public int[] nextGreaterElementOptimal(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map = new HashMap<>(); // O(m)
            Stack<Integer> stack = new Stack<>(); // O(m)

            // Step 1: Build map of next greater elements for nums2
            for (int i = 0; i < nums2.length; i++) {
                int num = nums2[i];
                // checking !stack.isEmpty() so that checking peek do not throw exception
                while (!stack.isEmpty() && num > stack.peek()) {
                    int smaller = stack.pop();
                    map.put(smaller, num); // Map each popped element to its next greater
                }
                stack.push(num);
            }

            // Step 2: For remaining elements in stack, no greater element exists
            while (!stack.isEmpty()) {
                map.put(stack.pop(), -1);
            }

            // Step 3: Build result for nums1 using the map
            int[] res = new int[nums1.length]; // O(n)
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.get(nums1[i]);
            }

            return res;
        }
}
