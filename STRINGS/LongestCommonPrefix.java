public class LongestCommonPrefix {
            public static String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            String input = strs[0];  // Start with the first string
            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {  // Iterate over characters of the first string
                char ch = input.charAt(i);

                for (int j = 1; j < strs.length; j++) { // Compare with every other string
                    if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                        return ans.toString();  // Stop when mismatch is found
                    }
                }
                ans.append(ch);  // If character matches in all strings, add to result
            }
            return ans.toString();
        }

    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        longestCommonPrefix(strs);
    }
    }



