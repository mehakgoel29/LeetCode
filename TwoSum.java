import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Add the current number and its index to the map
            map.put(nums[i], i);
        }

        // If no solution, return an empty array (though the problem guarantees a solution)
        return new int[] {};
    }
}


/*
Time Complexity: O(n), where n is the length of the nums array.
Space Complexity: O(n), due to the HashMap storing up to n elements in the worst case.
 */