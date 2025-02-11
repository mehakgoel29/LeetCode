public class SumOfDigitsOfString {
    public int getLucky(String s, int k) {
        int sum = 0;

        // Convert characters to numbers and sum their digits directly
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a' + 1; // Get the position of the letter
            while (num > 0) {
                sum = sum + (num % 10); // Add the last digit
                num = num / 10; // Remove last digit
            }
        }

        // Perform transformation k-1 times
        int count = 1;
        while (count < k) {
            int newSum = 0;
            while (sum > 0) {
                newSum = newSum + (sum % 10); // Add last digit
                sum = sum / 10; // Remove last digit
            }
            sum = newSum; // Update sum
            count = count + 1; // Increment count
        }

        return sum;
    }
}
