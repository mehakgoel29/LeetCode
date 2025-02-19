package EASY;

import java.util.HashMap;
import java.util.HashSet;

public class AllOccurencesEqual {

        public boolean areOccurrencesEqual(String s) {
            HashMap<Character,Integer> map=new HashMap<>();
            for(int i=0;i<s.length();i++){
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                }
                else{
                    map.put(s.charAt(i),1);
                }
            }
            HashSet<Integer> set =new HashSet<>(map.values());
            boolean result=set.size()==1;
            return result;
        }

}
//time and space : o(n)