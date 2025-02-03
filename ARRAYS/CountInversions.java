public class CountInversions {

        public static long getInversions(long arr[], int n) {
            // Create a single temporary array
            long[] temp = new long[n];
            return mergeSort(0, n - 1, arr, temp);
        }

        public static long mergeSort(int start, int end, long[] arr, long[] temp) {
            long count = 0;
            if (start >= end) {
                return 0;
            }

            int mid = start + (end - start) / 2;

            // Count inversions in the left and right halves
            count += mergeSort(start, mid, arr, temp);
            count += mergeSort(mid + 1, end, arr, temp);

            // Count inversions during the merge step
            count += merge(start, mid, end, arr, temp);

            return count;
        }

        public static long merge(int start, int mid, int end, long[] arr, long[] temp) {
            int i = start, j = mid + 1, k = start;
            long count = 0;

            // Merge the two halves while counting inversions
            while (i <= mid && j <= end) {
                if (arr[i] <= arr[j]) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                    count += (mid - i + 1); // Count inversions
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
    }

