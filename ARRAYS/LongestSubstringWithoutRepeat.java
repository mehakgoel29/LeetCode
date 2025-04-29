import java.util.HashMap;

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int maxLen=0;
        int start=0;
        for(int end=0;end<n;end++){
            char currentChar=s.charAt(end);
            if(map.containsKey(currentChar) && map.get(currentChar)>=start){
                start=map.get(currentChar)+1;
            }
            map.put(currentChar,end);
            maxLen=Math.max(maxLen,end-start+1);
        }
        return maxLen;
    }
}
