public class CountInversions {
    public static long getInversions(long arr[], int n) {
        return mergeSortAndCount(arr, 0, n - 1);
    }

    private static long mergeSortAndCount(long[] arr, int start, int end) {
        if (start >= end) {
            return 0;
        }

        long count = 0;
        int mid = start + (end - start) / 2;

        // Count inversions in left and right halves
        count += mergeSortAndCount(arr, start, mid);
        count += mergeSortAndCount(arr, mid + 1, end);

        // Count cross inversions and merge the two halves
        count += mergeAndCount(arr, start, mid, end);

        return count;
    }

    private static long mergeAndCount(long[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        // Create temporary arrays
        long[] left = new long[n1];
        long[] right = new long[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            left[i] = arr[start + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = start;
        long count = 0;

        // Merge the two halves and count inversions
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                count += (n1 - i); // All remaining elements in left form inversions
            }
        }

        // Copy remaining elements from left half
        while (i < n1) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements from right half
        while (j < n2) {
            arr[k++] = right[j++];
        }

        return count;
    }
}