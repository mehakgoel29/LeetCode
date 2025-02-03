public class PowerOfX {
    //brute force approach
    //this solution gives TLE

    public static double myPow(double x, int n) {
        // Handle edge cases
        if (n == 0) {
            return 1.0; // Any number to the power 0 is 1
        }

        long absN = Math.abs((long) n); // Convert n to long to avoid overflow
        double ans = 1.0;

        // Compute power using a loop
        for (long i = 0; i < absN; i++) {
            ans = ans * x;
        }

        // If n is negative, return the reciprocal
        if (n < 0) {
            return 1.0 / ans;
        }

        return ans;
    }

    //optimal approach

    public static double myPowOpt(double x, int n) {
        return solve(x, (long)n);
    }
    public static double solve(double x, long n) {

        if(n == 0)
            return 1;

        if(n < 0)
            return 1/solve(x, -n);


        if(n%2 == 0) {
            return solve(x*x, n/2);
        }

        return x*solve(x*x, (n-1)/2);

    }
}

