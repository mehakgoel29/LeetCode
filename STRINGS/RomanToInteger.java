import java.util.HashMap;

public class RomanToInteger {

        public int romanToInt(String s) {
            // Use Character instead of String for HashMap keys
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            int sum = 0;
            int prevValue = 0;

            // Iterate from right to left
            for (int i = s.length() - 1; i >= 0; i--) {
                char current = s.charAt(i);
                int currentValue = map.get(current);

                // If current value is smaller than the previous value, subtract it
                if (currentValue < prevValue) {
                    sum -= currentValue;
                } else {
                    sum += currentValue;
                }

                // Update previous value
                prevValue = currentValue;
            }

            return sum;
        }
    }

