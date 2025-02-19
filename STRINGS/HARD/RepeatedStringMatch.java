package HARD;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        // Append `a` until `result` is at least as long as `b`
        while (result.length() < b.length()) {
            result.append(a);
            count++;
        }
        if (result.toString().contains(b)) {
            return count;
        }
        result.append(a);
        count++;
        if (result.toString().contains(b)) {
            return count;
        }

        return -1;
    }
}
