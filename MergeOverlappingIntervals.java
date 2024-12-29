import java.util.Arrays;

public class MergeOverlappingIntervals {
        public static int[][] merge(int[][] intervals) {
            // Sort intervals by the starting point
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            // We will use a variable `index` to keep track of where to insert the merged intervals
            int index = 0;

            // Traverse through the sorted intervals
            for (int i = 1; i < intervals.length; i++) {
                // If current interval can be merged with the last merged interval
                if (intervals[index][1] >= intervals[i][0]) {
                    // Merge by updating the end of the last merged interval
                    intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
                } else {
                    // No overlap, move to the next position
                    index++;
                    intervals[index] = intervals[i];
                }
            }

            // The result will be the first `index + 1` intervals in the `intervals` array
            return Arrays.copyOfRange(intervals, 0, index + 1);
        }

        public static void main(String[] args) {
            // Example input
            int[][] intervals = {
                    {1, 3},
                    {2, 6},
                    {8, 10},
                    {15, 18}
            };

            // Call the merge function
            int[][] mergedIntervals = merge(intervals);

            // Print the merged intervals
            for (int[] interval : mergedIntervals) {
                System.out.println(Arrays.toString(interval));
            }
        }
    }


