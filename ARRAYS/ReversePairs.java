public class ReversePairs {
        public static void reversePairs(int[] nums) {
            int n = nums.length;
            int[] temp = new int[n];
            mergeSort(0, n - 1, nums, temp);
        }

        private static int mergeSort(int start, int end, int[] arr, int[] temp) {
            int count = 0;
            if (start >= end) {
                return 0;
            }
//            An inversion in an array is a pair of indices (i, j) such that:
//            i<j
//            arr[i]>arr[j]
//            If the subarray has only one element or no elements (when start >= end),
//            there are no pairs of indices to compare, and thus there are zero inversions

            int mid = start + (end - start) / 2;

            // Count reverse pairs in the left and right halves
            count += mergeSort(start, mid, arr, temp);
            count += mergeSort(mid + 1, end, arr, temp);

            // Count reverse pairs during the merge step
            count += merge(start, mid, end, arr, temp);

            return count;
        }

        private static int merge(int start, int mid, int end, int[] arr, int[] temp) {
            int count = 0;
            int i = start, j = mid + 1, k = start;

            // Count reverse pairs during merging
            for (int x = start; x <= mid; x++) {
                while (j <= end && arr[x] > 2L * arr[j]) {
                    j++;
                }
                count += (j - (mid + 1));
            }

            // Merge the two halves
            i = start; j = mid + 1; k = start;
            while (i <= mid && j <= end) {
                if (arr[i] <= arr[j]) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            }

            // Copy remaining elements from the left half
            while (i <= mid) {
                temp[k++] = arr[i++];
            }

            // Copy remaining elements from the right half
            while (j <= end) {
                temp[k++] = arr[j++];
            }

            // Copy the merged elements back into the original array
            for (i = start; i <= end; i++) {
                arr[i] = temp[i];
            }

            return count;
        }

    public static void main(String[] args) {
        int [] arr={2,1,5,6,8};
        reversePairs(arr);
    }
    }

