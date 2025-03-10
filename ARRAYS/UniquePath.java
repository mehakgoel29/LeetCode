public class UniquePath {
    public int uniquePaths(int m, int n) {
        // Create a DP array
        int dp[][] = new int[m][n];

        // // Initialize the first row and first column
        // for (int i = 0; i < m; i++) {
        //     dp[i][0] = 1; // Only one way to move down
        // }
        // for (int j = 0; j < n; j++) {
        //     dp[0][j] = 1; // Only one way to move right
        // }

        // Fill the DP array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 || j==0){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        // Return the value in the bottom-right corner
        return dp[m - 1][n - 1];
    }
}
