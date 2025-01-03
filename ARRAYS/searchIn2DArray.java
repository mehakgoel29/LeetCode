public class searchIn2DArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length - 1; //last column
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            }
            //reducing search space
            else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;

    }
}