public class RemoveDupFromSortedArr {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int k = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[k]) {
                    k++; 
                    nums[k] = nums[i];
                }
            }
            return k + 1; 
        }
        }
}

/*
 * Time Complexity: O(n), where n is the length of the nums array.
Space Complexity: O(1), since the algorithm uses a constant amount of extra space.
 */