import java.util.HashMap;

public class FindTheDuplicateNumber {

    //method 1: sorting ...check i with i+1
    //using hashmap time and space complexity : 0(n)
    public int findDuplicate1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (int i = 0; i < map.size(); i++) {
            if (map.get(nums[i]) > 1) {
                return nums[i];
            }
        }
        return -1;
    }

    //using slow and fast pointer
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect the cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entry point of the cycle
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // The duplicate number
    }
}