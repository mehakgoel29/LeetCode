public class RepeatingAndMissing {
    public int[] findMissingAndRepeatedValues2DArray(int[][] grid) {
        int n = grid.length; //gives rows only and not the exact numbers
        int n2 = n * n;  // The maximum value in the grid (n^2)

        // Sum and sum of squares for numbers 1 to n^2
        long sum_n2 = (long) n2 * (n2 + 1) / 2;
        long sum_sq_n2 = (long) n2 * (n2 + 1) * (2 * n2 + 1) / 6;

        long sum_arr = 0;
        long sum_sq_arr = 0;

        // Iterate through the grid and calculate sum and sum of squares
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum_arr += grid[i][j];
                sum_sq_arr += (long) grid[i][j] * grid[i][j];  // Cast to long to prevent overflow
            }
        }

        // Calculate the differences
        long sum_diff = sum_n2 - sum_arr;  // Missing - Repeated
        long sum_sq_diff = sum_sq_n2 - sum_sq_arr;  // Missing^2 - Repeated^2

        // Using the formulas:
        // (x^2 - y^2) = (x - y)(x + y), so:
        // sum_sq_diff = (missing - repeated) * (missing + repeated)
        // sum_diff = missing - repeated
        // Solve for missing and repeated:

        long repeat_plus_missing = sum_sq_diff / sum_diff;  // (missing + repeated)
        long missing = (sum_diff + repeat_plus_missing) / 2;  // missing = (sum_diff + (missing + repeated)) / 2
        long repeat = missing - sum_diff;  // repeated = missing - sum_diff

        return new int[] {(int) repeat, (int) missing};

    }
        public int[] findMissingAndRepeatedValues1DArray(int[] nums) {
            int n = nums.length;
            int n2 = n;  // The number of elements is n, not n^2, in the 1D array

            // Sum and sum of squares for numbers 1 to n
            long sum_n = (long) n * (n + 1) / 2;  // Sum of first n natural numbers
            long sum_sq_n = (long) n * (n + 1) * (2 * n + 1) / 6;  // Sum of squares of first n natural numbers

            long sum_arr = 0;
            long sum_sq_arr = 0;

            // Iterate through the array and calculate sum and sum of squares
            for (int i = 0; i < nums.length; i++) {
                sum_arr += nums[i];
                sum_sq_arr += (long) nums[i] * nums[i];  // Cast to long to prevent overflow
            }

            // Calculate the differences
            long sum_diff = sum_n - sum_arr;  // Missing - Repeated
            long sum_sq_diff = sum_sq_n - sum_sq_arr;  // Missing^2 - Repeated^2

            // Using the formulas:
            // (x^2 - y^2) = (x - y)(x + y), so:
            // sum_sq_diff = (missing - repeated) * (missing + repeated)
            // sum_diff = missing - repeated
            // Solve for missing and repeated:

            long repeat_plus_missing = sum_sq_diff / sum_diff;  // (missing + repeated)
            long missing = (sum_diff + repeat_plus_missing) / 2;  // missing = (sum_diff + (missing + repeated)) / 2
            long repeat = missing - sum_diff;  // repeated = missing - sum_diff

            return new int[] {(int) repeat, (int) missing};
        }
    }


