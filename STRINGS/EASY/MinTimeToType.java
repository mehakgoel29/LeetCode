package EASY;

public class MinTimeToType {
    public int minTimeToType(String word) {
        int time = 0;
        char prev = 'a';  // Pointer starts at 'a'

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            int distance = Math.abs(curr - prev);
            int move = Math.min(distance, 26 - distance);
            time += move + 1;
            prev = curr;
        }
        return time;
    }
}
