package EASY;

public class FirstIndexOfFirstOccurrence {
    public int strStrEasy(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
//o(n)

        public int strStr(String haystack, String needle) {
            int m = haystack.length(), n = needle.length();

            for (int i = 0; i <= m - n; i++) {
                if (haystack.substring(i, i + n).equals(needle)) {
                    return i;
                }
            }

            return -1;
        }
//o(m*n)
}
