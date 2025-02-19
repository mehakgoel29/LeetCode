package EASY;

public class IsPrefixString {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<words.length;i++){
            sb.append(words[i]);
            if (sb.toString().equals(s)) {
                return true;
            }
            if (sb.length() > s.length()) {
                return false; // No need to continue if the concatenation exceeds s
            }
        }
        return false;

    }
}
