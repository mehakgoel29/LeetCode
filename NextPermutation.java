public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int gola_index = -1;

        // Find the first decreasing element from the end or basically the gola index
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                gola_index = i - 1;
                break;
            }
        }

        int swap_index = gola_index ; //can take any value not necessarily gola_index becuase it is going to be updated
        if (gola_index != -1) { // If there is a valid `gola_index`
            // Find the next largest element to swap with `nums[gola_index]`
            for (int i = gola_index + 1; i < n; i++) {
                if (nums[i] > nums[gola_index]) {
                    swap_index = i;
                }
            }

            // Swap `nums[gola_index]` and `nums[swap_index]`
            int temp = nums[gola_index];
            nums[gola_index] = nums[swap_index];
            nums[swap_index] = temp;
        }

        // Reverse the suffix starting from `gola_index + 1`
        int start = gola_index + 1;
        int end = n - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
