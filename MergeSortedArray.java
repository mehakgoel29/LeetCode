public class MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
           int i = m - 1; // Pointer for the last element in the first m elements of nums1
            int j = n - 1; // Pointer for the last element in nums2
            int k = m + n - 1; // Pointer for the last position in nums1
            
            // Merge nums1 and nums2 from the back
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[k] = nums1[i];
                    i--;
                } else {
                    nums1[k] = nums2[j];
                    j--;
                }
                k--;
            }
            
            // Copy any remaining elements from nums2
            while (j >= 0) {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
            
            // No need to copy remaining elements from nums1 because they are already in place
        }
    }
}
